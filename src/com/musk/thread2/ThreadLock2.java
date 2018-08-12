package com.musk.thread2;

/**
 * synchronized (this) synchronized (object) synchronized (class)
 */
public class ThreadLock2 extends ThreadLock{
	
	public void A() {
		try {
			//����������������ͬһ�������첽ִ��
			synchronized (ThreadLock2.class) {
				System.out.println("a begin");
				Thread.sleep(3000);
				System.out.println("a end");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void B() {
		synchronized (ThreadLock2.class) {
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