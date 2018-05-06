/** @文件名: Calculator.java @创建人：邢健  @创建日期： 2014-8-9 上午6:19:12 */
package com.promisepb.study.threadstudy;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

/**   
 * @类名: Calculator.java 
 * @包名: com.promise.thread.chapter1 
 * @描述: chapter1 1.3 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2014-8-9 上午6:19:12 
 * @版本: V1.0   
 */
public class Calculator1 implements Runnable {

	private int number;
	@Override
	public void run() {
		for(int i=1;i<10;i++){
			System.out.printf("%s: %d * %d = %d\n",Thread.currentThread().getName(),number,i,i*number);
		}
	}
	
	private static void writeThreadInfo(PrintWriter pw, Thread thread,State state){
		pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
		pw.printf("Main : Priority %d\n", thread.getPriority());
		pw.printf("Main : Old State: %s\n", state);
		pw.printf("Main : New State: %s\n", thread.getState());
		pw.printf("Main : ********************************\n");
	}
	
	public Calculator1(int number) {
		this.number = number;
	}
	
	public static void main(String[] args) {
		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];
		for(int i=0;i<10;i++){
			Calculator1 c = new Calculator1(i);
			threads[i] = new Thread(c);
			if((i%2)==0){
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}else{
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread"+i);
		}
		
		try {
			FileWriter file = new FileWriter(".\\data\\log.txt");
			PrintWriter pw = new PrintWriter(file);
			for(int i=0;i<10;i++){
				pw.println("Main : Status of Thread"+i+" : "+threads[i].getState());
				status[i]=threads[i].getState();
			}
			for(int i=0;i<10;i++){
				threads[i].start();
			}
			boolean finish = false;
			while(!finish){
				for(int i=0;i<10;i++){
					if(threads[i].getState()!=status[i]){
						writeThreadInfo(pw, threads[i], status[i]);
						status[i] = threads[i].getState();
					}
				}
				finish = true;
				for(int i=0;i<10;i++){
					finish=finish&&(threads[i].getState()==State.TERMINATED);
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
