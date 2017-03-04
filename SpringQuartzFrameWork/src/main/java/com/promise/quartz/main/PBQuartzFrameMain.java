package com.promise.quartz.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.promise.quartz.utils.TaskUtil;

/**  
 * 功能描述: 框架的启动程序
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2017年2月15日 下午4:47:12  
 */
public class PBQuartzFrameMain {

	/**
	 * 程序的入库函数
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		TaskUtil taskUtil = (TaskUtil)ac.getBean("taskUtil");
		taskUtil.startTasks();
	}

}
