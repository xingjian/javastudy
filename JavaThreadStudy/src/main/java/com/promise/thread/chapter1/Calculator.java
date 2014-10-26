/** @文件名: Calculator.java @创建人：邢健  @创建日期： 2014-8-9 上午6:19:12 */
package com.promise.thread.chapter1;

/**   
 * @类名: Calculator.java 
 * @包名: com.promise.thread.chapter1 
 * @描述: TODO 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2014-8-9 上午6:19:12 
 * @版本: V1.0   
 */
public class Calculator implements Runnable {

	private int number;
	@Override
	public void run() {
		for(int i=1;i<10;i++){
			System.out.printf("%s: %d * %d = %d\n",Thread.currentThread().getName(),number,i,i*number);
		}
	}
	
	public Calculator(int number) {
		this.number = number;
	}
	
	public static void main(String[] args) {
		for(int i=1;i<10;i++){
			Calculator c = new Calculator(i);
			Thread thread = new Thread(c);
			thread.start();
		}
	}


}
