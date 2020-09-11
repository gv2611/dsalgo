package com.multithreading.examples;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MyExecutor2 {
	private ExecutorService executor;

	MyExecutor2() {
		executor = Executors.newFixedThreadPool(5);
		startWorking();
	}

	private void startWorking() {
		for (int i = 0; i < 10; i++) {
			final int j = i;
			
//			Callable<String> c = new Callable<String>() {
//				public String call() {
//					
//				}
//			};

			CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {}
				return Thread.currentThread().getName() + " Chotu doing kaam " + j;
			}, executor);
			
			completableFuture.thenAccept(MyExecutor2::callback);
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " Babu doing kaam" + i);
		}
	}
	
	public static void callback(Object s) {
		System.out.println((String) s);
	}
	
	public static void main(String[] args) {
		MyExecutor2 e = new MyExecutor2();
	}
}