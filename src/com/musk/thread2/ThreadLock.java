package com.musk.thread2;

/**
 * synchronized (this) synchronized (object) synchronized (class)
 */
public class ThreadLock {
	private String lock=new String();
	/*
	  public void A() {
	   		System.out.println("run----objectMethodA"); 
	  }
	 */

	/*
	public synchronized void A() {
		System.out.println("run----objectMethodA");
	}
	 */
	public void A() {
		try {
			//����������������ͬһ�������첽ִ��
			synchronized (lock) {
				System.out.println("a begin");
				Thread.sleep(3000);
				System.out.println("a end");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void B() {
		synchronized (this) {
			try {
				for (int i = 1; i <= 10; i++) {
					System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}