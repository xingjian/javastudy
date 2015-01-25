/** @文件名: SmsSender.java @创建人：邢健  @创建日期： Jan 25, 2015 4:41:33 PM */
package com.promise.javamodel.factory;

 /**  
 * @类名: SmsSender.java
 * @包名: com.promise.javamodel.factory
 * @描述: TODO
 * @作者: xingjian xingjian@yeah.net  
 * @日期:Jan 25, 2015 4:41:33 PM
 * @版本: V1.0  
 */
public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("this is SmsSender!");
	}

}
