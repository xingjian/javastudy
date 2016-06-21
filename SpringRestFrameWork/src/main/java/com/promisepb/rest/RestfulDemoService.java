package com.promisepb.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.promisepb.service.DemoService;

/**  
 * ��������: 
 * @author:<a href="mailto:xingjian@yeah.net">�Ͻ�</a>  
 * @version: V1.0
 * ����:2016��6��21�� ����5:08:43  
 */
@Component
@Path("/demo")
public class RestfulDemoService {
	@Autowired
    private DemoService demoService;
	
	@GET
    @Path("/say")
    public String sayHello() {
        return demoService.say();
    }
}
