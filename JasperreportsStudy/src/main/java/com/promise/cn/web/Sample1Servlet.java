/** @文件名: Sample1Servlet.java @创建人：邢健  @创建日期： 2012-8-3 下午10:12:55 */

package com.promise.cn.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   
 * @类名: Sample1Servlet.java 
 * @包名: com.promise.cn.web 
 * @描述: Sample1Servlet 
 * @作者: xingjian xingjian@yeah.net
 * @日期:2012-8-3 下午10:12:55 
 * @版本: V1.0   
 */
@SuppressWarnings("all")
public class Sample1Servlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
