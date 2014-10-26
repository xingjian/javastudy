/** @文件名: HelloService.java @创建人：邢健  @创建日期： 2012-9-11 下午1:14:42 */
package com.promise.pub.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**   
 * @类名: HelloService.java 
 * @包名: com.promise.service 
 * @描述: web service 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-9-11 下午1:14:42 
 * @版本: V1.0   
 */
@WebService(name="helloService",portName="helloServicePort",targetNamespace="http://www.xingjian.com")
public class HelloService {

	/**
	 * 进入命令行，进入工程跟目录
	 * wsgen -cp target\classes -s .\src\main\java\ -d .\src\main\java com.promise.pub.service.HelloService
	 * @param value
	 * @return
	 */
	@WebMethod
	public String getValue(String value){
		return "you recevice:"+value;
	}
	
}
