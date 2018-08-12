package com.musk.threads;
/**
 *volatile�ؼ����ܱ�֤ԭ������?
 */
public class ThVolatile2 {
	static class MyThread extends Thread{
		volatile private static int count;
		public MyThread(String name) {
			this.setName(name);
		}
		
		//�������ܱ�֤ԭ������
		synchronized private static void addCount() {
			for(int i=0;i<100;i++) {
				count=i;
			}
			System.out.println("�߳�"+Thread.currentThread().getName()+"��count="+count);
		}
		
		@Override
		public void run() {
			super.run();
			addCount();
		}
	}
	
	public static void main(String[] args) {
		MyThread[]thArr=new MyThread[100];
		for(int i=0;i<100;i++) {
			thArr[i]=new MyThread(""+i);
		}
		for(int i=0;i<100;i++) {
			thArr[i].start();
		}
	}
}
/**
 *volatile�ؼ������߳�ͬ����������ʵ�֣�����volatile���ܿ϶���synchronized�ؼ���Ҫ�á�
 *����volatile�ؼ���ֻ�����ڱ�����synchronized�ؼ��ֿ������η����Լ�����顣synchronized��
 *������JavaSE1.6֮���������Ҫ����Ϊ�˼��ٻ�������ͷ����������������Ķ������ƫ��������������
 *�Լ����������Ż�֮��ִ��Ч����������������ʵ�ʿ�����ʹ��synchronized�ؼ��ֻ��Ǹ���һЩ��
    
    ���̷߳���volatile�ؼ��ֲ��ᷢ����������synchronized�ؼ��ֿ��ܻᷢ������
  
  volatile�ؼ����ܱ�֤���ݵĿɼ��ԣ������ܱ�֤���ݵ�ԭ���ԡ�synchronized�ؼ������߶��ܱ�֤��
  
  volatile�ؼ������ڽ�������ڶ���߳�֮��Ŀɼ��ԣ���synchronized�ؼ��ֽ�����Ƕ���߳�֮�������Դ��ͬ���ԡ�

*/