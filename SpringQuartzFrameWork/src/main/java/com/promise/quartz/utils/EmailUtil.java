package com.promise.quartz.utils;

import java.util.List;
import java.util.Properties;

import javax.mail.internet.InternetAddress;

import com.promise.cn.util.EncryptUtil;
import com.promise.cn.util.PBMailUtil;

/**  
 * 功能描述: 发送email帮助类
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2017年2月16日 下午4:44:48  
 */
public class EmailUtil {
	private String protocol;
	private String host;
	private String auth;
	private String mailUserName;
	private String mailPasswd;
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getMailUserName() {
		return mailUserName;
	}
	public void setMailUserName(String mailUserName) {
		this.mailUserName = mailUserName;
	}
	public String getMailPasswd() {
		return mailPasswd;
	}
	public void setMailPasswd(String mailPasswd) {
		this.mailPasswd = mailPasswd;
	}
	
	public synchronized void SendEmailText(List<InternetAddress> receiveMails,String subject,String content){
		try{
			Properties props = PBMailUtil.CreateProperties(this.protocol, this.host, this.auth, EncryptUtil.decrypt(this.mailUserName), EncryptUtil.decrypt(this.mailPasswd));
			InternetAddress sendMail = new InternetAddress(EncryptUtil.decrypt(this.mailUserName),"监测框架邮箱","UTF-8");
			PBMailUtil.SendEmailText(props, sendMail, receiveMails, null, null, subject, content);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	 
}
