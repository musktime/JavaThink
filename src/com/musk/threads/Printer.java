package com.musk.threads;
/**
 * �����ӡż��������
 * lock��Printer.classͬ����ʲô����
 */
public class Printer {

	private static Object lock = new Object();
	private static int i = 1;

	public static void main(String[] args) {
		Thread th1 = new Thread() {
			@Override
			public void run() {
				super.run();
				while (i <= 10) {
					synchronized (lock) {
						if (i % 2 == 1) {
							System.out.println("th1-------" + i++);
						} else {
							try {
								lock.notify();
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		};
		Thread th2 = new Thread() {
			@Override
			public void run() {
				super.run();
				while (i <= 10) {
					synchronized (lock) {
						if (i % 2 == 0) {
							System.out.println("th2---" + i++);
						} else {
							try {
								lock.notify();
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		};
		th1.start();
		th2.start();
	}
}