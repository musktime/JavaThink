package com.musk.thread2;

public class ThreadLockTest {
	static class ThreadA extends Thread {
		private ThreadLock threadLock;
		public ThreadA(ThreadLock threadLock) {
			this.threadLock=threadLock;
		}
		
		@Override
		public void run() {
			super.run();
			threadLock.A();
		}
	}
	
	static class ThreadB extends Thread {
		private ThreadLock threadLock;
		public ThreadB(ThreadLock threadLock) {
			this.threadLock=threadLock;
		}
		
		@Override
		public void run() {
			super.run();
			threadLock.B();
		}
	}
	
	public static void main(String[] args) {
		/*
		
		ThreadLock threadLock=new ThreadLock();
		ThreadA a=new ThreadA(threadLock);
		ThreadA aa=new ThreadA(threadLock);
		ThreadB b=new ThreadB(threadLock);
		
		//b.start();//-----≤‚ ‘synchronized(this)
		a.start();
		aa.start();//-----≤‚ ‘synchronized(Obecjt)
		
		*/
		
		//-----≤‚ ‘synchronized(class)
		ThreadLock2 tt2=new ThreadLock2();
		ThreadLock2 ttt2=new ThreadLock2();
		ThreadA a=new ThreadA(tt2);
		ThreadB b=new ThreadB(ttt2);
		
		a.start();
		b.start();
	}
}
