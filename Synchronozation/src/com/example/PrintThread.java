package com.example;

public class PrintThread {
	public void printCount() {
		
		try {
			for(int i = 1; i <= 5; i++) {
				System.out.println("Counter  ---  " + i);
			}
		} catch (Exception e) {
			System.out.println("Thread Interrupted.");
		}
	}
}
