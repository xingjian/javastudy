package com.promise.quartz.service;

import java.util.List;

import com.promise.quartz.core.ScheduleJob;

/**  
 * 功能描述:ScheduleJob 接口设计
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2017年2月9日 下午2:20:25  
 */
public interface ScheduleJobService {

	
	/**
	 * 获取全部的任务
	 * @return
	 */
	public List<ScheduleJob> getAllScheduleJob();
	/**
	 * 增加任务
	 * @param job
	 */
	public void addScheduleJob(ScheduleJob job);
	/**
	 * 通过ID获取任务ID
	 * @param jobId
	 * @return
	 */
	public ScheduleJob getScheduleJobById(String jobId);
	/**
	 * 更改任务的运行状态
	 * @param jobId
	 * @param cmd
	 */
	public void changeStatus(String jobId, String cmd);
	/**
	 * 更改任务 cron表达式
	 * @param jobId
	 * @param cron
	 */
	public void updateCron(String jobId, String cron);
	/**
	 * 暂停 
	 * @param scheduleJob
	 */
	public void pauseScheduleJob(ScheduleJob scheduleJob);
	/**
	 * 恢复
	 * @param scheduleJob
	 */
	public void resumeScheduleJob(ScheduleJob scheduleJob);
	/**
	 * 删除
	 * @param scheduleJob
	 */
	public void deleteScheduleJob(ScheduleJob scheduleJob);
	/**
	 * 立即运行
	 * @param scheduleJob
	 */
	public void runScheduleJobNow(ScheduleJob scheduleJob);
}
