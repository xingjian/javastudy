/** @文件名: SenderFactory.java @创建人：邢健  @创建日期： Jan 25, 2015 4:51:56 PM */
package com.promise.javamodel.factory;

 /**  
 * @类名: SenderFactory.java
 * @包名: com.promise.javamodel.factory
 * @描述: TODO
 * @作者: xingjian xingjian@yeah.net  
 * @日期:Jan 25, 2015 4:51:56 PM
 * @版本: V1.0  
 */
public class SenderFactory {

	public Sender produce(String type){
		if("mail".equals(type)){
			return new MailSender();
		}else if("sms".equals(type)){
			return new SmsSender();
		}else{
			return null;
		}
	}
}
