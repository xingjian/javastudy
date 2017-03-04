package com.promise.quartz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.promise.cn.util.PBFileUtil;
import com.promise.cn.util.StringUtil;
import com.promise.quartz.core.ScheduleJob;
import com.promise.quartz.core.ScheduleJobs;
import com.promise.quartz.utils.XMLUtil;

/**  
 * 功能描述:ScheduleJobService 接口实现类
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2017年2月9日 下午2:35:30  
 */
@Service("scheduleJobService")
public class ScheduleJobServiceImpl implements ScheduleJobService {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleJobServiceImpl.class);
	//ScheduleJob集合
	public Map<String,ScheduleJob> scheduleJobMapper = new HashMap<String,ScheduleJob>();
	
	/**
	 * 初始化任务集合
	 * 加载tasks目录下面所有的xml文件
	 */
	public void initScheduleJob(){
		String absPath = this.getClass().getResource("/tasks").getPath();
		List<String> filePaths = PBFileUtil.FindFilesByEndName(absPath, ".xml");
		for(String filePathTemp : filePaths){
			ScheduleJobs jobs = null;
			try {
				String fileName = StringUtil.GetFileName(filePathTemp);
				jobs = XMLUtil.ToBeanFromFile(absPath, fileName, ScheduleJobs.class);
				for(ScheduleJob sjTemp:jobs.getJobs()){
					scheduleJobMapper.put(sjTemp.getId(), sjTemp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("初始化加载目录tasks下面的文件......");
	}
	
	/**
	 * 将scheduleJobMapper转换list返回
	 */
	@Override
	public List<ScheduleJob> getAllScheduleJob() {
		if(scheduleJobMapper.isEmpty()){
			initScheduleJob();
		}
		List<ScheduleJob> list = new ArrayList<ScheduleJob>();  
        Iterator<String> it = scheduleJobMapper.keySet().iterator();  
        while (it.hasNext()) {  
           String key = it.next().toString();  
           list.add(scheduleJobMapper.get(key));  
        } 
        return list;
	}

	
	@Override
	public void addScheduleJob(ScheduleJob job) {
		scheduleJobMapper.put(job.getId(), job);
	}

	
	@Override
	public ScheduleJob getScheduleJobById(String jobId) {
		return scheduleJobMapper.get(jobId);
	}

	
	@Override
	public void changeStatus(String jobId, String cmd) {

	}

	
	@Override
	public void updateCron(String jobId, String cron) {

	}

	
	@Override
	public void pauseScheduleJob(ScheduleJob scheduleJob) {

	}

	
	@Override
	public void resumeScheduleJob(ScheduleJob scheduleJob) {

	}

	
	@Override
	public void deleteScheduleJob(ScheduleJob scheduleJob) {

	}

	
	@Override
	public void runScheduleJobNow(ScheduleJob scheduleJob) {

	}

}
