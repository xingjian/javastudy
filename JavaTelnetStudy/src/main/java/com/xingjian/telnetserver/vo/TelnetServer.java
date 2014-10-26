/** @文件名: TelnetServer.java @创建人：邢健  @创建日期： 2012-9-27 上午10:25:23 */
package com.xingjian.telnetserver.vo;

/**   
 * @类名: TelnetServer.java 
 * @包名: com.xingjian.telnetserver.vo 
 * @描述: TODO 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-9-27 上午10:25:23 
 * @版本: V1.0   
 */
public class TelnetServer {

	public String name;
	public boolean status;
	public String info;
	public int port;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

}
