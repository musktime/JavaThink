package com.musk.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * 等待/通知机制<br>
 * <br>
 *
 * 是指一个线程A调用了对象O的wait()方法进入等待状态，而另一个线程B调用了对象O的
 * notify()/notifyAll()方法，线程A收到通知后退出等待队列，进入可运行状态，进而 执行后续操作
 */
public class ThWaitNotify {
	static class MyList {
		private static List<String> list = new ArrayList<String>();

		public static void add() {
			list.add("someThing");
		}

		public static int size() {
			return list.size();
		}
	}

	static abstract class ThreadA extends Thread {
		@SuppressWarnings("unused")
		private Object lock;

		public ThreadA(Object lock) {
			this.lock = lock;
		}
	}

	public static void main(String[] args) {
		try {
			Object lock = new Object();
			//元素个数到不是5时阻塞
			new ThreadA(lock) {
				@Override
				public void run() {
					super.run();
					synchronized (lock) {
						if (MyList.size() != 5) {
							try {
								System.out.println("wait start:" + System.currentTimeMillis());
								lock.wait();
								System.out.println("wait end:" + System.currentTimeMillis());
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

						}
					}
				}
			}.start();
			
			Thread.sleep(30);
			
			//元素个数是5时唤醒上一个线程
			new ThreadA(lock) {
				@Override
				public void run() {
					super.run();
					synchronized (lock) {
						for (int i = 0; i < 10; i++) {
							MyList.add();
							if (MyList.size() == 5) {
								lock.notify();
								System.out.println("发出通知！");
							}
							System.out.println("添加了" + i + "个元素");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}.start();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}