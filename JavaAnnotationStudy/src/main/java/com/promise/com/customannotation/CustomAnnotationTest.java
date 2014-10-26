/** @文件名: CustomAnnotationTest.java @创建人：邢健  @创建日期： 2013-10-18 上午8:09:45 */
package com.promise.com.customannotation;

/**   
 * @类名: CustomAnnotationTest.java 
 * @包名: com.promise.com.customannotation 
 * @描述: 测试注解 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2013-10-18 上午8:09:45 
 * @版本: V1.0   
 */
@CustomAnnotation(color="red",value="abc",colors=Color.YELLO,annotationAtt=@MetaAnnotation("annotation"))
public class CustomAnnotationTest {

	/** 如果只有一个value需要赋值的话，就可以省略 value= **/
	@CustomAnnotation("xyz")
	public static void main(String[] args) {
		if(CustomAnnotationTest.class.isAnnotationPresent(CustomAnnotation.class)){
			CustomAnnotation ca = (CustomAnnotation)CustomAnnotationTest.class.getAnnotation(CustomAnnotation.class);
			System.out.println(ca);
			System.out.println(ca.color());
			System.out.println(ca.value());
			System.out.println(ca.arrayAtt().length);
			System.out.println(ca.colors().getName());
			System.out.println(ca.annotationAtt().value());
		}
	}

}
