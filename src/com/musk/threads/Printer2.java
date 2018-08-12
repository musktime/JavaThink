package com.musk.threads;

public class Printer2 {

	static class Num {
		private int i = 1;
	}

	public static void main(String[] args) {
		Num num = new Num();
		Thread th1 = new Thread() {
			@Override
			public void run() {
				super.run();
				while (num.i < 100) {
					synchronized (num) {
						if (num.i % 2 == 0) {
							System.out.println(Thread.currentThread().getName() + "------" + num.i++);
						} else {
							try {
								num.notify();
								num.wait();
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
				while (num.i < 100) {
					synchronized (num) {
						if (num.i % 2 == 1) {
							System.out.println(Thread.currentThread().getName() + "---" + num.i++);
						} else {
							try {
								num.notify();
								num.wait();
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