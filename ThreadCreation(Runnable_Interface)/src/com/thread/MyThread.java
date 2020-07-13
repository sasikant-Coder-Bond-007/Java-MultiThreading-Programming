package com.thread;

public class MyThread implements Runnable{
	private Thread t;
	private String threadName;
	
	public MyThread(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}
	
	public void run() {
		System.out.println("Running "+ threadName );
		try {
			for(int i=0;i<5;i++) {
				System.out.println("Thread "+ threadName + ", "+i);
				Thread.sleep(1000);
			} 
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " is inturrepted.");
		}
		System.out.println("Thread " + threadName + " execution completed.");
	}
	
	public void start() {
		System.out.println("Thread" + threadName + "execution started.");
		if(t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
