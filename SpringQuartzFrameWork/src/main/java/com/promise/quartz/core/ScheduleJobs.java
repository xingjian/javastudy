package com.promise.quartz.core;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**  
 * 功能描述:
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2017年2月7日 下午2:45:09  
 */
@XStreamAlias("jobs")
public class ScheduleJobs {

	@XStreamImplicit
	private List<ScheduleJob> jobs;

	public List<ScheduleJob> getJobs() {
		return jobs;
	}

	public void setJobs(List<ScheduleJob> jobs) {
		this.jobs = jobs;
	}
	
}
