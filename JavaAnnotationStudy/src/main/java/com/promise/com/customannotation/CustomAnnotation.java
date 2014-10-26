/** @文件名: CustomAnnotation.java @创建人：邢健  @创建日期： 2013-10-18 上午8:06:56 */
package com.promise.com.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**   
 * @类名: CustomAnnotation.java 
 * @包名: com.promise.com.customannotation 
 * @描述: 自定义注解 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2013-10-18 上午8:06:56 
 * @版本: V1.0   
 */
/** 元注解 Retention 注解的生命周期有3个  javafile(SOURCE)-->classfile(CLASS)-->内存(RUNTIME)**/
/** 元注解 Target 指定放在什么位置,Method方法上面, type(class,interface,emun **/
/** 如果只有一个value需要复制的话，就可以省略 value= **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface CustomAnnotation {
	/** 注解属性 **/
	String color() default "blue";
	String value();
	/** 如果数组只有一个值可以省略大括号 如下写法
	 * @CustomAnnotation(color="red",value="abc",arrayAtt=1) **/
	int[] arrayAtt() default {1,2,3};
	Color colors() default Color.RED;
	MetaAnnotation annotationAtt() default @MetaAnnotation("dhcc");
}
