package com.promisepb.service.impl;

import org.springframework.stereotype.Service;

import com.promisepb.service.DemoService;

/**  
 * ��������:
 * @author:<a href="mailto:xingjian@yeah.net">�Ͻ�</a>  
 * @version: V1.0
 * ����:2016��6��21�� ����4:56:55  
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

	
	@Override
	public String say() {
		return "welecome use spring rest !";
	}

}
