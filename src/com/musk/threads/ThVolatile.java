package com.musk.threads;
/**
 * 1.在 JDK1.2 之前，Java的内存模型实现总是从主存（即共享内存）读取变量
 * 2.而在当前的 Java 内存模型下，线程可以把变量保存本地内存（比如机器的寄存器）中，而不是直接在主存中进行读写
 * 3.变量声明为 volatile，这就指示 JVM这个变量是不稳定，每次使用它都到主存中进行读取
 * 
 * 有volatile关键字会强制保证线程可见性，没有则jvm会尽力保证线程可见性
 * 加了输出或者sleep语句之后，CPU就有可能有时间去保证内存的可见性
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
			System.out.println("开始执行！");
			while(isRunning) {
				;//陷入死循环
			}
			System.out.println("执行结束!");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		MyThread th=new MyThread();
		th.start();
		
		Thread.sleep(2000);
		th.setRunning(false);
		System.out.println("设置标记为false！");
	}
}
