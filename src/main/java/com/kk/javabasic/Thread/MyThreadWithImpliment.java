package com.kk.javabasic.Thread;

public class MyThreadWithImpliment implements Runnable {

	@Override
	public void run() {
		System.out.println("线程的run方法被调用……");
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new MyThreadWithImpliment());
		thread.start();
	}
}
