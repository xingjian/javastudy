package com.promise.quartz.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.promise.quartz.core.QuartzJobFactory;
import com.promise.quartz.core.QuartzJobFactoryDisallowConcurrentExecution;
import com.promise.quartz.core.ScheduleJob;
import com.promise.quartz.service.ScheduleJobService;

/**  
 * 功能描述: 定时任务运行帮助类
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2016年12月4日 下午7:38:20  
 */
public class TaskUtil {

	private static final Logger logger = LoggerFactory.getLogger(TaskUtil.class);
	
	@Autowired
	private ScheduleJobService scheduleJobService;
	
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	
	private static EmailUtil emailUtil;
	//保存实力好的数据对象
	private static Map<String,Object> mapObject = new HashMap<String,Object>();
	
	/**
	 * 启动整个任务框架
	 */
	public void startTasks(){
		List<ScheduleJob> jobList = scheduleJobService.getAllScheduleJob();
		for (ScheduleJob job : jobList) {
			startTask(job);
        }
	}
	
	/**
	 * 启动单个job
	 * @param job
	 * @return
	 */
	public void startTask(ScheduleJob job){
		if (job == null) {
            return;
        }
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getName(), job.getGroupName());
        try {
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			//不存在，创建一个
	        if (null == trigger) {
	        	//1 到点就执行，不会管上次执行是否完成 0等待上次完成
	            Class clazz = "1".equals(job.getConcurrent()) ? QuartzJobFactory.class : QuartzJobFactoryDisallowConcurrentExecution.class;
	            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getName(), job.getGroupName()).build();
	            jobDetail.getJobDataMap().put("scheduleJob", job);
	            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
	            trigger = TriggerBuilder.newTrigger().withIdentity(job.getName(), job.getGroupName()).withSchedule(scheduleBuilder).build();
	            scheduler.scheduleJob(jobDetail, trigger);
	        } else {
	            // Trigger已存在，那么更新相应的定时设置
	            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
	            // 按新的cronExpression表达式重新构建trigger
	            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
	            // 按新的trigger重新设置job执行
	            scheduler.rescheduleJob(triggerKey, trigger);
	        }
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
        
        
	}
	
	public static void invokMethod(ScheduleJob scheduleJob) {
		Object object = null;
		Class clazz = null;
		if (StringUtils.isNotBlank(scheduleJob.getId())) {
			try {
				if(null==mapObject.get(scheduleJob.getTargetObject())){
					clazz = Class.forName(scheduleJob.getTargetObject());
					object = clazz.newInstance();
					mapObject.put(scheduleJob.getTargetObject(), object);
					logger.info("任务名称 = [" + scheduleJob.getId()+":"+scheduleJob.getName()+ "]----------启动成功");
				}else{
					object = mapObject.get(scheduleJob.getTargetObject());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (object == null) {
			logger.error("任务名称 = [" + scheduleJob.getId()+":"+scheduleJob.getName()+ "]--------未启动成功，请检查是否配置正确！");
			return;
		}
		clazz = object.getClass();
		Method method = null;
		try{
			if(null!=scheduleJob.getMethodParameter()&&!scheduleJob.getMethodParameter().trim().equals("")){
				method = clazz.getDeclaredMethod(scheduleJob.getTargetMethod(),String.class);
				logger.info("任务名称 = [" + scheduleJob.getId()+":"+scheduleJob.getName()+ "]----------开始执行。");
				method.invoke(object,scheduleJob.getMethodParameter());
				logger.info("任务名称 = [" + scheduleJob.getId()+":"+scheduleJob.getName()+ "]----------执行结束。");
			}else{
				method = clazz.getDeclaredMethod(scheduleJob.getTargetMethod());
				logger.info("任务名称 = [" + scheduleJob.getId()+":"+scheduleJob.getName()+ "]----------开始执行。");
				method.invoke(object);
				logger.info("任务名称 = [" + scheduleJob.getId()+":"+scheduleJob.getName()+ "]----------执行结束。");
			}
			List<InternetAddress> receiveMails = scheduleJob.getReceiveMails();
			if(receiveMails.size()>0){
				String content = "你好! 监测框架执行完成。任务ID : [" + scheduleJob.getId()+"    "+scheduleJob.getName()+ "]";
				emailUtil.SendEmailText(receiveMails, "["+scheduleJob.getId()+"----"+scheduleJob.getName()+"]", content);
			}
		}catch (NoSuchMethodException e) {
			logger.error("任务名称 = [" + scheduleJob.getId()+":"+scheduleJob.getName()+ "]---------------未启动成功，方法名设置错误！");
		}catch (Exception e) {
			logger.error(e.toString());
		}
	}

	public static void setEmailUtil(EmailUtil emailUtil) {
		TaskUtil.emailUtil = emailUtil;
	}
	
	
}
