package com.promise.quartz.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**  
 * 功能描述: 读取XML文件帮助类
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2016年12月4日 下午8:18:46  
 */
public class XMLUtil {
	
	/**
	 * 将xml转换成指定的java bean对象
	 * @param xmlStr
	 * @param cls
	 * @return
	 */
	public static <T> T  ToBean(String xmlStr,Class<T> cls){  
        XStream xstream=new XStream(new DomDriver());  
        xstream.processAnnotations(cls);  
        T obj=(T)xstream.fromXML(xmlStr);  
        return obj;              
    }
	
	/**
	 * 根据XML文件生成java bean
	 * @param absPath
	 * @param fileName
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static <T> T  ToBeanFromFile(String absPath, String fileName,Class<T> cls) throws Exception{  
        String filePath = absPath + File.separator +fileName+".xml";  
        InputStream ins = null ;  
        try {  
            ins = new FileInputStream(new File(filePath));  
        } catch (Exception e) {  
            throw new Exception("读{"+ filePath +"}文件失败！", e);  
        }  
        XStream xstream=new XStream(new DomDriver());  
        xstream.processAnnotations(cls);  
        T obj =null;  
        try {  
            obj = (T)xstream.fromXML(ins);  
        } catch (Exception e) {  
            throw new Exception("解析{"+ filePath +"}文件失败！",e);  
        }  
        if(ins != null)  
            ins.close();  
        return obj;              
    }   
}
