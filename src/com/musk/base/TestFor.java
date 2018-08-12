package com.musk.base;
/**
 *1.for代码块第一次执行初始化和条件判断，不会执行条件变更
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