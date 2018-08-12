package com.musk.threads;
/**
 *测试停止一个线程
 */
public class ThStopThread extends Thread{
	@Override
	public void run() {
		super.run();
		for(int i=0;i<500000;i++) {
			if(this.isInterrupted()) {
				System.out.println("处于停止状态，退出中....");
				return;
				//break;
			}
			System.out.println("i="+(i+1));
		}
		System.out.println("此处表示线程并未终止！");
	}
}