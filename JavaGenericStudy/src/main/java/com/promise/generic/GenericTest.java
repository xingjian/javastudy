/** @文件名: GenericTest.java @创建人：邢健  @创建日期： Jan 28, 2015 8:41:25 PM */
package com.promise.generic;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

 /**  
 * @类名: GenericTest.java
 * @包名: com.promise.generic
 * @描述: TODO
 * @作者: xingjian xingjian@yeah.net  
 * @日期:Jan 28, 2015 8:41:25 PM
 * @版本: V1.0  
 */
public class GenericTest {

	/**
	 * 打印任意类型的集合
	 * ? 同配符
	 * @param collection
	 */
	public static void printCollection(Collection<?> collection){
		//collection.add("abc");编译报错
		System.out.println(collection.size());
	}
	
	/**
	 * 交换任意数组
	 * @param a
	 * @param i
	 * @param j
	 */
	public static <T> void swap(T[] a, int i,int j){
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * <T> 声明T是任意引用类型
	 * @param x
	 * @param y
	 * @return
	 */
	public static <T> T add(T x,T y){
		return x;
	}
	
	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws Exception {
		//集合方式
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		//反射方式
		Constructor<String> con = String.class.getConstructor(StringBuffer.class);
		String str = con.newInstance(new StringBuffer("abc"));
		System.out.println(str);
		//泛行是让java编译器用的。编译之后就会把泛型去掉，不影响效率
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		System.out.println(list.getClass()==list1.getClass());//输出true
		//list1.add(1);编译报错,下面通过反射跳过泛型的编译
		list1.getClass().getMethod("add", Object.class).invoke(list1, "abc");
		System.out.println(list1.get(0));//1
		System.out.println(list1.get(1));//abc
		//限定通配符的上边界
		Vector<? extends Number> vec = new Vector<Integer>();
		//Vector<? extends Number> vec1 = new Vector<String>();//编译报错
		//限定通配符的下边界
		Vector<? super Integer> vec2 = new Vector<Number>();
		//Vector<? super Integer> vec3 = new Vector<Byte>();//编译报错
		
		HashMap<String ,Integer> maps= new HashMap<String ,Integer>();
		maps.put("aaaa", 1111);
		maps.put("bbbb", 2222);
		maps.put("cccc", 3333);
		Set<Map.Entry<String,Integer>> entrySet = maps.entrySet();
		for(Map.Entry<String, Integer> entry:entrySet){
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		
		
		
	}

}
