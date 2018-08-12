package com.musk.thread2;

public class ThreadJoin {
	static class TestJoin extends Thread {
		
		public TestJoin(String name) {
			super(name);
		}
		@Override
		public void run() {
			super.run();
			for (int i = 0; i < 100; i++) {
				System.out.println(this.getName() + ":" + i);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TestJoin t1=new TestJoin("AA");
		TestJoin t2=new TestJoin("BB");
		
		t1.start();
		t1.join();
		
		t2.start();
	}
}