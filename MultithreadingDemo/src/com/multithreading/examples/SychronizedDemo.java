package com.multithreading.examples;

class MyCounter {
	private static int count = 0;

	public static synchronized void add(int value) {
		for (int i = 0; i < 10; i++) {
			count += value;
			System.out.println("Count = " + count);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public static synchronized void substract(int value) {
		for (int i = 0; i < 10; i++) {
			count -= value;
			System.out.println("Count = " +count);

			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

class MyThread5 extends Thread {
	MyCounter c;

	MyThread5(MyCounter counter) {
		this.c = counter;

	}

	public void run() {
		System.out.println("In thread mythread5");
		c.add(1);

	}
}

class MyThread6 extends Thread {
	MyCounter c;

	MyThread6(MyCounter counter) {
		this.c = counter;
	}

	public void run() {
		System.out.println("In thread mythread6");
		c.substract(1);
	}
}

public class SychronizedDemo {

	public static void main(String[] args) {
		MyCounter mycount = new MyCounter();
		MyThread5 t1 = new MyThread5(mycount);
		MyThread6 t2 = new MyThread6(mycount);
		t1.start();
		t2.start();
		// TODO Auto-generated method stub

	}

}
