package com.musk.threads;

public class ThAsynRun {

	public static void main(String[] args) {
		ThAsync async=new ThAsync();
		new MyThread(async,"A") {
			@Override
			public void run() {
				super.run();
				ThAsync.printA();
			}
		}.start();
		
		new MyThread(async,"B") {
			@Override
			public void run() {
				super.run();
				ThAsync.printB();
			}
		}.start();
		
		new MyThread(async,"C") {
			@Override
			public void run() {
				super.run();
				async.printC();
			}
		}.start();
	}
	
	static abstract class MyThread extends Thread{
		@SuppressWarnings("unused")
		private ThAsync async;
		
		public MyThread(ThAsync async,String name) {
			this.async=async;
			this.setName(name);
		}
	}
}