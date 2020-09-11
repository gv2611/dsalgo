package com.multithreading.examples;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random
;
class Worker implements Runnable {
	private int workerId;
	// This is the queue from which the worker will pick work from.
	private Queue<Integer> q;
	public Worker(int workerId, Queue<Integer> q) {
		this.workerId = workerId;
		this.q = q;
	}
	@Override
	public void run() {
		// Keep trying to get work from the queue.
		while (true) {

			// Take lock on the queue and try to get work from it.

			synchronized (this.q) {

				// Check if there is work in the queue.

				if (this.q.size() > 0) {

					Integer work = this.q.remove();

					System.out.println("      [Worker " + workerId + "] worked on : " + work);

				}

			}

		}

	}

}

class Server {

	private Queue<Integer> workQueue;

	private ArrayList<Worker> workers;

	private static int numberOfWorkers = 5;

	public Server() {

		// Work queue is a Queue (interface). It's implementation is provided by
		// LinkedList

		// class in java.util.

		this.workQueue = new LinkedList<Integer>();

		this.workers = new ArrayList<Worker>();

	}

	public void startServing() {

		// Start all the workers.

		startWorkers();

		Random randomDelay = new Random();

		int workId = 0;

		// Keep giving work to the workers indefinitely.

		while (true) {

			// Sleep for a random duration before giving more work.

			try {

				Thread.sleep(200 + randomDelay.nextInt(1000));

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

			// Take lock on the queue and add work to the queue.

			synchronized (this.workQueue) {

				System.out.println("[Server] Adding work " + workId + " to work Queue");

				this.workQueue.add(workId);

			}

			workId++;

		}

	}

	private void startWorkers() {

		for (int i = 0; i < numberOfWorkers; i++) {

			Worker worker = new Worker(i, this.workQueue);

			this.workers.add(worker);

			// Start the worker (pss: which is nothing but a thread).

			(new Thread(worker)).start();

		}

	}

}

public class ServerWorker {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Server s = new Server();

		s.startServing();

	}

}
