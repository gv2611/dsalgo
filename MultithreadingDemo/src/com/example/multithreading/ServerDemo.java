package com.example.multithreading;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread1 implements Runnable {
	private int value;

	public WorkerThread1(int value) {
		this.value = value;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " value from queue=" + value);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}

	}
}

public class ServerDemo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		int valToAdd = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		while(true) {
			queue.add(valToAdd);
			valToAdd++;
			while (!queue.isEmpty()) {
				Runnable worker = new WorkerThread1(queue.remove());
				executor.execute(worker);
			}

		}
		//executor.shutdown();


		//ServerDemo sd = new ServerDemo();
		

	}

}
