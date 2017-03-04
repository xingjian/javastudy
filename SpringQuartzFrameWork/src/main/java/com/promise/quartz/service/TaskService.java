package com.promise.quartz.service;

import com.promise.quartz.core.ScheduleJob;

/**  
 * 功能描述:任务执行类的方法
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2017年2月15日 下午4:31:31  
 */
public interface TaskService {
	/**
	 * 执行之前
	 * @param sj
	 * @return
	 */
	public String beforeTask(ScheduleJob sj);
	/**
	 * 执行
	 * @param sj
	 * @return
	 */
	public String executeTask(ScheduleJob sj);
	/**
	 * 执行之后
	 * @param sj
	 * @return
	 */
	public String afterTask(ScheduleJob sj);
}
