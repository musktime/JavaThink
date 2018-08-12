package com.musk.threads;
/**
 * 1.�� JDK1.2 ֮ǰ��Java���ڴ�ģ��ʵ�����Ǵ����棨�������ڴ棩��ȡ����
 * 2.���ڵ�ǰ�� Java �ڴ�ģ���£��߳̿��԰ѱ������汾���ڴ棨��������ļĴ������У�������ֱ���������н��ж�д
 * 3.��������Ϊ volatile�����ָʾ JVM��������ǲ��ȶ���ÿ��ʹ�������������н��ж�ȡ
 * 
 * ��volatile�ؼ��ֻ�ǿ�Ʊ�֤�߳̿ɼ��ԣ�û����jvm�ᾡ����֤�߳̿ɼ���
 * �����������sleep���֮��CPU���п�����ʱ��ȥ��֤�ڴ�Ŀɼ���
 */
public class ThVolatile {
	static class MyThread extends Thread{
		volatile private boolean isRunning=true;
		public void setRunning(boolean flag) {
			isRunning=flag;
		}
		
		@Override
		public void run() {
			super.run();
			System.out.println("��ʼִ�У�");
			while(isRunning) {
				;//������ѭ��
			}
			System.out.println("ִ�н���!");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		MyThread th=new MyThread();
		th.start();
		
		Thread.sleep(2000);
		th.setRunning(false);
		System.out.println("���ñ��Ϊfalse��");
	}
}
