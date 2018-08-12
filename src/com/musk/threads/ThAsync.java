package com.musk.threads;

/**
 * synchronized��Ϊ����������������ͷ������������� jdk1.6Ϊ������ƫ��������������
 *
 * 1.synchronizedȡ�õ������Ƕ������������ǰ�һ�δ���򷽷�������
 * 2.����synchronized������о��첽ִ�У���synchronized������о���ͬ��ִ��
 * 3.��synchronized����һ����synchronized(this)�����Ҳ��������ǰ�����
 * 4.synchronized�ؼ��ּӵ�static��̬������synchronized(class)������϶����Ǹ�Class��������
 * ��synchronized�ؼ��ּӵ���static��̬�������Ǹ���������
 */
public class ThAsync {
	// ͬ�������
	public static void printA() {
		synchronized (ThAsync.class) {
			try {
				System.out.println("�߳�" + Thread.currentThread().getName() + "��" + System.currentTimeMillis() + "����");
				Thread.sleep(3000);
				System.out.println("�߳�" + Thread.currentThread().getName() + "��" + System.currentTimeMillis() + "�˳�");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// ��̬ͬ������
	public static synchronized void printB() {
		System.out.println("�߳�" + Thread.currentThread().getName() + "��" + System.currentTimeMillis() + "����");
		System.out.println("�߳�" + Thread.currentThread().getName() + "��" + System.currentTimeMillis() + "�˳�");
	}

	// ʵ��ͬ������
	public synchronized void printC() {
		System.out.println("�߳�" + Thread.currentThread().getName() + "��" + System.currentTimeMillis() + "����");
		System.out.println("�߳�" + Thread.currentThread().getName() + "��" + System.currentTimeMillis() + "�˳�");
	}
}