package com.promise.quartz.core;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.promise.quartz.utils.TaskUtil;

/**
 * 
 * 功能描述:计划任务执行
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2017年2月16日 下午1:24:25
 */
public class QuartzJobFactory implements Job {
	private static final Logger logger = LoggerFactory.getLogger(QuartzJobFactory.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		TaskUtil.invokMethod(scheduleJob);
	}
}