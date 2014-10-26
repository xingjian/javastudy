/** @文件名: SunAnnotationStudy.java @创建人：邢健  @创建日期： 2013-10-18 上午7:51:59 */
package com.promise.com.sunannotation;

import java.util.ArrayList;
import java.util.List;


/**   
 * @类名: SunAnnotationStudy.java 
 * @包名: com.promise.com.sunannotation 
 * @描述: TODO 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2013-10-18 上午7:51:59 
 * @版本: V1.0   
 */
public class SunAnnotationStudy {

	private String name;
	
	/**
	 * 过时的注解 生命周期（runtime）
	 */
	@Deprecated 
	public void save(){
		System.out.println("这是过时的注解");
	}
	
	/**
	 * 重写的注解 生命周期（source）
	 */
	@Override
	public boolean equals(Object object){
		if(((SunAnnotationStudy)object).name == name){
			return true;
		}
		return false;
	}
	
	/**
	 * 警告的注解 生命周期（source）
	 */
	@SuppressWarnings("all")
	public void update(){
		List list = new ArrayList<Object>();
	}
	
}
