package com.promise.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.promise.cn.util.PBFileUtil;

/**  
 * 功能描述:日志环境测试类
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2016年12月4日 下午7:52:07  
 */
public class Slf4jTest {

	private static final Logger logger = LoggerFactory.getLogger(Slf4jTest.class);
	
	@Test
	public void testSlf4jEnable(){
		logger.trace("this is Slf4j trace logs!");
		logger.debug("this is Slf4j debug logs!");
		logger.info("this is Slf4j info logs!");
		logger.warn("this is Slf4j warn logs!");
		logger.error("this is Slf4j error logs!");
	}
	
	@Test
	public void testWriteLog(){
		String filepath = "d:\\log.txt";
		PBFileUtil.WriteStringToTxt("this is Slf4j trace logs! \n", filepath);
		PBFileUtil.WriteStringToTxt("this is Slf4j trace logs! \n", filepath);
		PBFileUtil.WriteStringToTxt("this is Slf4j debug logs! \n", filepath);
		PBFileUtil.WriteStringToTxt("this is Slf4j info logs! \n", filepath);
		PBFileUtil.WriteStringToTxt("this is Slf4j warn logs! \n", filepath);
		PBFileUtil.WriteStringToTxt("this is Slf4j error logs! \n", filepath);
	}
	
}
