package com.java.concurrency;

public class MyThread implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Executing my Thread " + i);
		}
	}
}
