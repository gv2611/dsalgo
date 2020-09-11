package com.multithreading.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class MyExecutor {
	private ExecutorService executor;

	MyExecutor() {
		executor = Executors.newFixedThreadPool(5);
		startWorking();
	}

	private void startWorking() {
		for (int i = 0; i < 10; i++) {
			final int j = i;
			
			Runnable r = new Runnable() {
				public void run() {
					System.out.println(
							Thread.currentThread().getName() + " Chotu doing kaam " + j);
				}
			};

			executor.submit(r);
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " Babu doing kaam" + i);
		}
	}
	
	public static void main(String[] args) {
		MyExecutor e = new MyExecutor();
	}
}