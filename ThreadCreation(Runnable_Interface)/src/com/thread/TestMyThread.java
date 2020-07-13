package com.thread;

public class TestMyThread {

	public static void main(String[] args) {
		MyThread T1 = new MyThread("Thread - 1");
		T1.start();
		
		MyThread T2 = new MyThread("Thread - 2");
		T2.start();

	}

}
