package com.musk.threads;
/**
 *volatile关键字能保证原子性吗?
 */
public class ThVolatile2 {
	static class MyThread extends Thread{
		volatile private static int count;
		public MyThread(String name) {
			this.setName(name);
		}
		
		//加锁就能保证原子性了
		synchronized private static void addCount() {
			for(int i=0;i<100;i++) {
				count=i;
			}
			System.out.println("线程"+Thread.currentThread().getName()+"的count="+count);
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
 *volatile关键字是线程同步的轻量级实现，所以volatile性能肯定比synchronized关键字要好。
 *但是volatile关键字只能用于变量而synchronized关键字可以修饰方法以及代码块。synchronized关
 *键字在JavaSE1.6之后进行了主要包括为了减少获得锁和释放锁带来的性能消耗而引入的偏向锁和轻量级锁
 *以及其它各种优化之后执行效率有了显著提升，实际开发中使用synchronized关键字还是更多一些。
    
    多线程访问volatile关键字不会发生阻塞，而synchronized关键字可能会发生阻塞
  
  volatile关键字能保证数据的可见性，但不能保证数据的原子性。synchronized关键字两者都能保证。
  
  volatile关键字用于解决变量在多个线程之间的可见性，而synchronized关键字解决的是多个线程之间访问资源的同步性。

*/