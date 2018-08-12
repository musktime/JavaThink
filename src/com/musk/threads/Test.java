package com.musk.threads;

/**
 * �̵߳Ĳ�ͬ���췽ʽ
 */
public class Test {

	public static void main(String[] args) {
		// testNonShared();
		// testShared();
		
		testStop();
	}

	static void testStop() {
		try {
			ThStopThread stopThread = new ThStopThread();
			stopThread.start();
			Thread.sleep(200);
			stopThread.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("ִ�г���"+e.getMessage());
		}
		System.out.println("ִ�н�����");
	}

	// ���ԣ������߳�ʵ�������������̹߳������
	static void testShared() {
		ThFieldThread myThread = new ThFieldThread();
		Thread a = new Thread(myThread, "A");
		Thread b = new Thread(myThread, "B");
		Thread c = new Thread(myThread, "C");
		Thread d = new Thread(myThread, "D");
		Thread e = new Thread(myThread, "E");
		a.start();
		b.start();
		try {
			b.join();// �ȴ����߳���ֹ
			Thread.yield();// ������ǰCPU����Դ
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} //
		c.start();
		d.start();
		e.start();
	}

	// ���ԣ������߳�ʵ�������������̲߳��������
	static void testNonShared() {
		ThFieldThread a = new ThFieldThread("A");
		ThFieldThread b = new ThFieldThread("B");
		ThFieldThread c = new ThFieldThread("C");
		a.start();
		b.start();
		c.start();
	}
}