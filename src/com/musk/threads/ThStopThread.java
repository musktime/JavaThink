package com.musk.threads;
/**
 *����ֹͣһ���߳�
 */
public class ThStopThread extends Thread{
	@Override
	public void run() {
		super.run();
		for(int i=0;i<500000;i++) {
			if(this.isInterrupted()) {
				System.out.println("����ֹͣ״̬���˳���....");
				return;
				//break;
			}
			System.out.println("i="+(i+1));
		}
		System.out.println("�˴���ʾ�̲߳�δ��ֹ��");
	}
}