/** @文件名: TelnetServerService.java @创建人：邢健  @创建日期： 2012-9-27 上午10:20:08 */
package com.xingjian.telnetserver.service;

/**   
 * @类名: TelnetServerService.java 
 * @包名: com.xingjian.telnetserver.service 
 * @描述: TODO 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-9-27 上午10:20:08 
 * @版本: V1.0   
 */
public interface TelnetServerService {

	/**
	 * 启动服务
	 * @return
	 */
	public String startServer();
	/**
	 * 关闭服务
	 * @return
	 */
	public String shutdownServer();
	/**
	 * 获取服务信息包括运行状态
	 * @return
	 */
	public String getServerInfo();
}
