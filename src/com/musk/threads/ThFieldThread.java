package com.musk.threads;

/**
 *�߳�ʵ�������������̹߳������
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
			System.out.println("��"+ThFieldThread.currentThread().getName()+"����,count="+count);
		}
	}
}