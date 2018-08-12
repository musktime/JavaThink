package com.musk.thread2;

public class Test {
	public static void main(String[] args) {
		Ticketer ticketer=new Ticketer();
		Thread t1=new Thread(ticketer,"����1");
		Thread t2=new Thread(ticketer,"����2");
		Thread t3=new Thread(ticketer,"����3");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}