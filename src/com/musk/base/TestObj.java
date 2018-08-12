package com.musk.base;
/**
 *1.栈：空间小速度快，存储八种数据类型
 *2.堆：空间大速度慢，存储对象和数组
 *3.主函数【在方法区】进栈---------【方法执行原理】
 */

class Dog{
	String color;
	double weight;
	double height;
	public void protectHome() {
		System.out.println("home");
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
public class TestObj {
	Dog dog=new Dog();
}