package com.promise.fileupload;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import java.util.*;

public class UploadServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		//设置保存上传文件的目录
		String uploadDir = getServletContext().getRealPath("/upload");
		if(uploadDir == null){
			out.println("无法访问存储目录");
			return;
		}
		File fUploadDir = new File(uploadDir);
		if(!fUploadDir.exists()){
			if(!fUploadDir.mkdir()){
				out.println("无法创建存储目录");
				return;
			}
		}
		
		if(!DiskFileUpload.isMultipartContent(request)){
			out.println("只能处理multipart/form-data类型的数据!");
			return;
		}
		DiskFileUpload fu = new DiskFileUpload();
		//最多上传200M数据
		fu.setSizeMax(1024*1024*200);
		//超过1M的字段数据采用临时文件缓存
		fu.setSizeThreshold(1024*1024);
		//采用默认的临时文件存储
		//fu.setRepositoryPath(...)
		//设置上传的普通字段的名称和文件字段的文件名所采用的字符集编码
		fu.setHeaderEncoding("gb2312");
		
		//得到所有表单字段对象的集合
		List fileItems  = null;
		try{
			fileItems = fu.parseRequest(request);
		}catch(FileUploadException e){
			out.println("解析数据时出现如下问题");
			e.printStackTrace(out);
			return;
		}
		//处理每个表单字段
		Iterator i = fileItems.iterator();
		while(i.hasNext()){
			FileItem fi = (FileItem)i.next();
			if(fi.isFormField()){
				String content = fi.getString("gb2312");
				String fieldName = fi.getFieldName();
				request.setAttribute(fieldName,content);
			}else{
				try{
					String pathSrc = fi.getName();
					//如果用户没有在form表单的文件字段中选择任何文件那么忽略对该字段的处理
					if(pathSrc.trim().equals("")){
						continue;
					}
					int start = pathSrc.lastIndexOf('\\');
					String filedName = pathSrc.substring(start+1);
					File pathDest = new File(uploadDir,filedName);
					fi.write(pathDest);
					String fieldName = fi.getFieldName();
					request.setAttribute(fieldName,filedName);
				}catch(Exception e){
					out.println("存储文件时出现如下问题：");
					e.printStackTrace(out);
					return;
				}finally{
					fi.delete();
				}
			}
		}
		
		out.println("用户："+request.getAttribute("author")+"<br>");
		out.println("来自："+request.getAttribute("company")+"<br>");
		//将上传的文件名组合成'file1,file2'这种形式显示出来，如果没有上传任何文件则显示无 如果只上传了第二个文件
		//则显示file2
		StringBuffer fileList = new StringBuffer();
		String file1 = (String)request.getAttribute("file1");
		makeUpList(fileList,file1);
		String file2 = (String)request.getAttribute("file2");
		makeUpList(fileList,file2);
		out.println("成功上传文件"+(fileList.length()==0?"无":fileList.toString()));
	}
	/**
	* 将一段字符串追加到另一个字符串中，如果结果字符串的初始内容不为空
	* 在追加当前这段字符串之前先追加一个逗号(,)。 在组合sql语句的查询条件时，
	* 经常要用到类似的方法，第一个条件没有 and 而后面的条件前都需要用 and
	* 做连词，如果没有选择第一个条件，第二个条件就变成第一个，以此类推。
	*
	**/
	 
	private void makeUpList(StringBuffer result,String fragment){
		if(fragment !=null){
			if(result.length()!=0){
				result.append(",");
			}
			result.append(fragment);
		}
	} 
	
	
}