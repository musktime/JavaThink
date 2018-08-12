package com.musk.threads;

/**
 * 线程的不同构造方式
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
			System.out.println("执行出错："+e.getMessage());
		}
		System.out.println("执行结束！");
	}

	// 测试：定义线程实例变量对其他线程共享变量
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
			b.join();// 等待该线程终止
			Thread.yield();// 放弃当前CPU的资源
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} //
		c.start();
		d.start();
		e.start();
	}

	// 测试：定义线程实例变量对其他线程不共享变量
	static void testNonShared() {
		ThFieldThread a = new ThFieldThread("A");
		ThFieldThread b = new ThFieldThread("B");
		ThFieldThread c = new ThFieldThread("C");
		a.start();
		b.start();
		c.start();
	}
}