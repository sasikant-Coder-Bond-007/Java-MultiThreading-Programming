package com.example;

public class TestThread {
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();
	
	public static void main(String[] args) {
		MyThread1 T1 = new MyThread1();
		MyThread2 T2 = new MyThread2();
		
		T1.start();
		T2.start();

	}
	
	private static class MyThread1 extends Thread {
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread - 1 : Holding lock 1 ...");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("Thread - 2 : is waiting for lock 2 ...");
				
				synchronized (lock2) {
					System.out.println("Thread - 1 : Holding lock 1 & 2 ...");
				}
			}
		}
	}
	
	private static class MyThread2 extends Thread {
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread - 2 : Holding lock 1 ... ");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Thread - 2 : is waiting for lock 2 ....");
				
				synchronized (lock2) {
					System.out.println("Thread - 2 : Holding lock 1 & 2 ...");
				}
			}
		}
	}

}
