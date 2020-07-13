package com.thread;

public class MyThread extends Thread{
	private Thread t;
	private String threadName;
	
	public MyThread(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}
	
	public void run() {
		System.out.println("Running " + threadName);
		
		try {
			for(int i=0;i<4;i++) {
				System.out.println("Thread " + threadName + ", "+ i);
				Thread.sleep(2000);
			}
			
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thraed " + threadName + " execution finished.");
	}
	
	
	public void start() {
		System.out.println("Starting " + threadName );
		if(t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
	
}
