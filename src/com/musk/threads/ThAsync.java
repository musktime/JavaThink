package com.musk.threads;

/**
 * synchronized称为重量锁，获得锁和释放锁很消耗性能 jdk1.6为此引入偏向锁和轻量级锁
 *
 * 1.synchronized取得的锁都是对象锁，而不是把一段代码或方法当做锁
 * 2.不在synchronized代码块中就异步执行，在synchronized代码块中就是同步执行
 * 3.和synchronized方法一样，synchronized(this)代码块也是锁定当前对象的
 * 4.synchronized关键字加到static静态方法和synchronized(class)代码块上都是是给Class类上锁，
 * 而synchronized关键字加到非static静态方法上是给对象上锁
 */
public class ThAsync {
	// 同步代码块
	public static void printA() {
		synchronized (ThAsync.class) {
			try {
				System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入");
				Thread.sleep(3000);
				System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "退出");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 静态同步方法
	public static synchronized void printB() {
		System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入");
		System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "退出");
	}

	// 实例同步方法
	public synchronized void printC() {
		System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入");
		System.out.println("线程" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "退出");
	}
}