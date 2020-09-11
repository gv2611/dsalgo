package com.multithreading.examples;

public class InterruptedThreadDemo extends Thread {

	public void run() {
		
		for (int i = 0; i < 10000; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!Thread.interrupted()) {
				System.out.println("value of i=" + i);	
			}
			else {
				System.out.println("Thread has been interrupted!!!");
				break;
			}
		}
	}

	public static void main(String[] args) {
		InterruptedThreadDemo interrupted = new InterruptedThreadDemo();
		interrupted.start();
	
			interrupted.interrupt();
		}

	}

