package com.example;

public class TestThread {
	
	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();
	
	public static void main(String[] args) {
		MyThread1 T1 = new MyThread1();
		MyThread2 T2 = new MyThread2();
		
		T1.start();
		T2.start();

	}
	
	private static class MyThread1 extends Thread {
		public void run() {
			synchronized (Lock1) {
				System.out.println("Thread - 1 : Holding lock 1...");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("Thread - 1 : is waiting for lock 2...");
			
				synchronized (Lock2) {
					System.out.println("Thread - 2 : Holding lock 1 & 2 ...");
				}
			}
		}
	}

	private static class MyThread2  extends Thread {
		public void run() {
			synchronized (Lock2) {
				System.out.println("Thread - 2 : Holding lock 2...");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Thread - 2 : is waiting for lock 1 ....");
			
				synchronized (Lock1) {
					System.out.println("Thread - 1 : Holding lock 1 & 2 ...");
				}
			}
		}
	}
}
