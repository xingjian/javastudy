package pub;
/** @文件名: TestWebService.java @创建人：邢健  @创建日期： 2012-9-11 下午1:41:55 */
import javax.xml.ws.Endpoint;

import com.promise.pub.service.HelloService;

/**   
 * @类名: TestWebService.java 
 * @包名:  
 * @描述: TODO 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-9-11 下午1:41:55 
 * @版本: V1.0   
 */
public class TestWebService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:8001/HelloServicePort", new HelloService());   
	}

}
