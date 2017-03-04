package com.promise.test;

/**  
 * 功能描述:
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2017年2月16日 下午3:19:46  
 */
public class TaskInstanceTest {

	private int count;
	
	public void testTaskExecute(String str){
		count++;
		System.out.println("count="+count+"----"+str);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
