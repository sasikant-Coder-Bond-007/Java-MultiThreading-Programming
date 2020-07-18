package com.example;

public class TestThread {

	public static void main(String[] args) {
		PrintThread PD = new PrintThread();
		
		MyThread T1 = new MyThread("Thread - 1", PD);
		MyThread T2 = new MyThread("Thread - 2", PD);
		
		T1.Start();
		T2.Start();
		
		try {
			T1.join();
			T2.join();
		} catch (Exception e) {
			System.out.println("Interruped.");
		}

	}

}

/*
 Output :
	
	Thread Thread - 1 execution started!
	Thread Thread - 2 execution started!
	Counter  ---  1
	Counter  ---  2
	Counter  ---  3
	Counter  ---  4
	Counter  ---  5
	Thread Thread - 1 execution finished.
	Counter  ---  1
	Counter  ---  2
	Counter  ---  3
	Counter  ---  4
	Counter  ---  5
	Thread Thread - 2 execution finished.

*/