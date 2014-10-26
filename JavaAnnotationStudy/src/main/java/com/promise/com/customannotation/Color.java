/** @文件名: Color.java @创建人：邢健  @创建日期： 2013-10-18 上午11:04:31 */
package com.promise.com.customannotation;

/**
 * @类名: Color.java
 * @包名: com.promise.com.customannotation
 * @描述: TODO
 * @作者: xingjian xingjian@yeah.net
 * @日期:2013-10-18 上午11:04:31
 * @版本: V1.0
 */
public enum Color {
	RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
	// 成员变量
	private String name;
	private int index;

	// 构造方法
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(int index) {
		for (Color c : Color.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}

	// get set 方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
