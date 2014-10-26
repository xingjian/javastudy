/** @文件名: TelnetServerServiceImpl.java @创建人：邢健  @创建日期： 2012-9-27 上午10:20:58 */
package com.xingjian.telnetserver.service.impl;

import com.xingjian.telnetserver.service.TelnetServerService;
import com.xingjian.telnetserver.vo.TelnetServer;

/**   
 * @类名: TelnetServerServiceImpl.java 
 * @包名: com.xingjian.telnetserver.service.impl 
 * @描述: TelnetServerService接口实现 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-9-27 上午10:20:58 
 * @版本: V1.0   
 */
public class TelnetServerServiceImpl implements TelnetServerService {

	private TelnetServer telnetServer;
	
	@Override
	public String startServer() {
		return null;
	}

	@Override
	public String shutdownServer() {
		return null;
	}

	@Override
	public String getServerInfo() {
		return null;
	}
	
	public TelnetServer getTelnetServer() {
		return telnetServer;
	}

	public void setTelnetServer(TelnetServer telnetServer) {
		this.telnetServer = telnetServer;
	}

	/**
	 * 入口方法
	 */
	public static void main(String[] args) {

	}

}
