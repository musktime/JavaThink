package com.musk.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * �ȴ�/֪ͨ����<br>
 * <br>
 *
 * ��ָһ���߳�A�����˶���O��wait()��������ȴ�״̬������һ���߳�B�����˶���O��
 * notify()/notifyAll()�������߳�A�յ�֪ͨ���˳��ȴ����У����������״̬������ ִ�к�������
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
			//Ԫ�ظ���������5ʱ����
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
			
			//Ԫ�ظ�����5ʱ������һ���߳�
			new ThreadA(lock) {
				@Override
				public void run() {
					super.run();
					synchronized (lock) {
						for (int i = 0; i < 10; i++) {
							MyList.add();
							if (MyList.size() == 5) {
								lock.notify();
								System.out.println("����֪ͨ��");
							}
							System.out.println("�����" + i + "��Ԫ��");
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