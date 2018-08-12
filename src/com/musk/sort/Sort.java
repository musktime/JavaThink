package com.musk.sort;

public class Sort {

	public static void main(String[] args) {
		int[]data=new int[] {12,112,45,8,23,234,68,785};
		orderBubble(data);
		
		
		System.out.print("num : ");
		for(int i:data) {
			System.out.print(i+" ");
		}
		
	}
	
	private static void orderBubble(int[]data) {
		for(int i=0;i<data.length-1;i++) {
			for(int j=0;j<data.length-i-1;j++) {
				if(data[j+1]<data[j]) {
					int tmp=data[j+1];
					data[j+1]=data[j];
					data[j]=tmp;
				}
			}
		}
	}
}