package com.musk.threads;

/**
 *线程实例变量对其他线程共享变量
 */
public class ThFieldThread extends Thread{
	
	private int count=5;
	
	public ThFieldThread(String name) {
		super();
		this.setName(name);
	}
	
	public ThFieldThread() {}
	
	@Override
	public /*synchronized*/ void run() {
		super.run();
		while(count>0) {
			count--;
			System.out.println("由"+ThFieldThread.currentThread().getName()+"计算,count="+count);
		}
	}
}