package com.java.fraction;

public class OverloadDemo {
	public void print(Integer num) {
		System.out.println("Printing Integer num " + num);
	}
	
	public void print(String str) {
		System.out.println("Printing String str " + str);
	}
	
	public static void main(String[] args) {
		OverloadDemo dd = new OverloadDemo();
		dd.print(10);
	}
}
