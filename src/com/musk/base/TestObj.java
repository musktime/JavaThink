package com.musk.base;
/**
 *1.ջ���ռ�С�ٶȿ죬�洢������������
 *2.�ѣ��ռ���ٶ������洢���������
 *3.���������ڷ���������ջ---------������ִ��ԭ��
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