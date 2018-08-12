package com.musk.thread2;
/**
 *1.���ڹ�������
 *2.����̶߳�д��������
 */
public class Ticketer implements Runnable {

	private int ticket = 100;
	private Object obj=new Object();

	@Override
	public void run() {
		while (true) {
			/*synchronized (this) {*/
			synchronized (obj) {//������ʲô��
				if (ticket > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "��������" + ticket + "��Ʊ��");
					ticket--;
				} else {
					System.out.println(Thread.currentThread().getName() + "Ʊ������");
					break;
				}
			}
		}
	}

}