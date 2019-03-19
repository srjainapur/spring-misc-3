package com.java.concurrency;

public class ThradTest {
	public static void main(String[] args) {
		Thread th = new Thread(new MyThread(), "MyThread");
		th.start();
		
		Thread th2 = new Thread(new ExtendsThread());
		th2.start();
	}
}
