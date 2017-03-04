package com.promise.test;

import org.junit.Test;

import com.promise.quartz.core.ScheduleJobs;
import com.promise.quartz.utils.XMLUtil;

/**  
 * 功能描述:
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2016年12月4日 下午9:08:49  
 */
public class XMLUtilTest {

	@Test
	public void testToBean(){
		String absPath = this.getClass().getResource("/tasks").getPath();
		try {
			ScheduleJobs jobs = XMLUtil.ToBeanFromFile(absPath, "user_count_monitor", ScheduleJobs.class);
			System.out.println(jobs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
