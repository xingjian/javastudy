/** @文件名: MailSender.java @创建人：邢健  @创建日期： Jan 25, 2015 4:40:01 PM */
package com.promise.javamodel.factory;

 /**  
 * @类名: MailSender.java
 * @包名: com.promise.javamodel.factory
 * @描述: TODO
 * @作者: xingjian xingjian@yeah.net  
 * @日期:Jan 25, 2015 4:40:01 PM
 * @版本: V1.0  
 */
public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("this is mailsender!");
	}

}
