package com.promise.quartz.core;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.InternetAddress;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**  
 * 功能描述: 任务类
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2016年12月4日 下午8:51:34  
 */
@XStreamAlias("job")
public class ScheduleJob implements Serializable{
	private static final long serialVersionUID = -62683301985868L;
    /** 任务ID */
	@XStreamAsAttribute()
    private String id;
    /** 任务名称 */
	@XStreamAsAttribute()
    private String name;
    /** 任务分组 */
	@XStreamAsAttribute()
    private String groupName;
    /** 任务状态 0禁用 1启用 2删除*/
    private String jobStatus;
    /** 任务运行时间表达式 */
    private String cronExpression;
    /** 任务描述 */
    private String description;
    /** 任务类 */
    private String targetObject;
    /** 任务方法 */
    private String targetMethod;
    /** 是否并发 0禁用 1启用 */
    private String concurrent;
    /** 一系列的子任务,逗号分开,表示该任务执行完，之后需要执行的任务 ,目前不支持*/
    private List<ScheduleJob> childJobs;
    /** 发送邮件,多人的话使用逗号分隔 */
    private String toEmail;
    /** 方法参数,用逗号分隔 */
    private String methodParameter;
    
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTargetObject() {
		return targetObject;
	}
	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}
	public String getTargetMethod() {
		return targetMethod;
	}
	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}
	public String getConcurrent() {
		return concurrent;
	}
	public void setConcurrent(String concurrent) {
		this.concurrent = concurrent;
	}
	public List<ScheduleJob> getChildJobs() {
		return childJobs;
	}
	public void setChildJobs(List<ScheduleJob> childJobs) {
		this.childJobs = childJobs;
	}
	public String getMethodParameter() {
		return methodParameter;
	}
	public void setMethodParameter(String methodParameter) {
		this.methodParameter = methodParameter;
	}
    
	public List<InternetAddress> getReceiveMails(){
		List<InternetAddress> receiveMails = new ArrayList<InternetAddress>();
		if(null!=this.toEmail&&!this.toEmail.trim().equals("")&&this.toEmail.indexOf("@")!=-1){
			String[] mailArr = this.toEmail.split(",");
			for(String mailTemp : mailArr){
				InternetAddress receiveMail = null;
				try {
					receiveMail = new InternetAddress(mailTemp,mailTemp,"UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				receiveMails.add(receiveMail);
			} 
		}
		return receiveMails;
	}
	
    
}
