package com.musk.base;
/**
 *1.for������һ��ִ�г�ʼ���������жϣ�����ִ���������
 */
public class TestFor {
	public static void main(String[]args) {
		System.out.println("====="+(foo("X")&&foo("Y")));
		int counter=2;
		for(foo("A");foo("B")&&counter>1;foo("C")) {
			counter--;
			foo("D");
		}
	}
	
	private static boolean foo(String str) {
		System.out.println(str);
		return true;
	}
}