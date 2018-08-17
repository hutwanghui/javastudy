package com.kk.javabasic.Thread;

public class producer extends Thread {

	@Override
	public void run() {
		System.out.println("线程的run方法被调用……");
	}

	public static void main(String[] args) {
		Thread thread = new producer();
		thread.start();
	}
}
