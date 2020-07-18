package com.example;

public class MyThread extends Thread{
	private Thread t;
	private String threadName;
	PrintThread PD;
	
	public MyThread(String name, PrintThread pd) {
		threadName = name;
		PD = pd;
	}
	
	public void run() {
		synchronized (PD) {
			PD.printCount();
		}
		System.out.println("Thread " + threadName +" execution finished.");
	}
	
	public void Start() {
		System.out.println("Thread " + threadName + " execution started!");
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
