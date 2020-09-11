package com.example.multithreading;

class Table1 {
	synchronized void printTable(int n) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}

class MyThread5 extends Thread {
	Table1 t;

	MyThread5(Table1 t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}

}

class MyThread6 extends Thread {
	Table1 t;

	MyThread6(Table1 t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}

public class SyncDemo {
	public static void main(String args[]) {
		Table1 obj = new Table1();
		MyThread5 t1 = new MyThread5(obj);
		MyThread6 t2 = new MyThread6(obj);
		t1.start();
		t2.start();
	}
}