package com.promise.quartz.core;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.promise.quartz.utils.TaskUtil;

/**
 * 
 * 功能描述:若一个方法一次执行不完下次轮转时则等待改方法执行完后才执行下一次操作
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2017年2月16日 下午1:25:33
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {
	private static final Logger logger = LoggerFactory.getLogger(QuartzJobFactoryDisallowConcurrentExecution.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		TaskUtil.invokMethod(scheduleJob);

	}
}