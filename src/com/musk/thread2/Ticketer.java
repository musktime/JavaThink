package com.musk.thread2;
/**
 *1.存在共享数据
 *2.多个线程读写共享数据
 */
public class Ticketer implements Runnable {

	private int ticket = 100;
	private Object obj=new Object();

	@Override
	public void run() {
		while (true) {
			/*synchronized (this) {*/
			synchronized (obj) {//区别是什么？
				if (ticket > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票！");
					ticket--;
				} else {
					System.out.println(Thread.currentThread().getName() + "票卖完了");
					break;
				}
			}
		}
	}

}