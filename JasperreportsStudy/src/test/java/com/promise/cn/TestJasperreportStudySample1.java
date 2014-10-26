/** @文件名: TestJasperreportStudySample1.java @创建人：邢健  @创建日期： 2012-8-3 下午2:02:53 */

package com.promise.cn;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import net.sf.jasperreports.view.JasperDesignViewer;
import org.junit.Test;

/**   
 * @类名: TestJasperreportStudySample1.java 
 * @包名: com.promise.cn 
 * @描述: 测试 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-8-3 下午2:02:53 
 * @版本: V1.0   
 */
public class TestJasperreportStudySample1 {

	@Test
	public void testSample1(){
		URL fileURL = ClassLoader.getSystemClassLoader().getResource("com/promise/cn/sample1.jasper");
		File file;
		try {
			file = new File(fileURL.toURI());
			InputStream jrxml = new FileInputStream(file);
			JasperDesignViewer.viewReportDesign(jrxml, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
