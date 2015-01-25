/** @文件名: SenderFactoryTest.java @创建人：邢健  @创建日期： Jan 25, 2015 4:57:07 PM */
package com.promise.javamodel;

import org.junit.Test;

import com.promise.javamodel.factory.Sender;
import com.promise.javamodel.factory.SenderFactory;

 /**  
 * @类名: SenderFactoryTest.java
 * @包名: com.promise.javamodel
 * @描述: 工厂模式测试类
 * @作者: xingjian xingjian@yeah.net  
 * @日期:Jan 25, 2015 4:57:07 PM
 * @版本: V1.0  
 */
public class SenderFactoryTest {

	@Test
	public void testSendFactory(){
		SenderFactory factory = new SenderFactory();
		Sender sender1 = factory.produce("mail");
		sender1.send();
		Sender sender2 = factory.produce("mail");
		sender2.send();
	}
}
