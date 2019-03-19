package com.java.concurrency;

public class ExtendsThread extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Executing ExtendsThread");
		}
	}
}
