package com.multithreading.examples;

class Table1 {
	void printTable(int a) {
		synchronized(this)
		{
		for (int i = 1; i <= 5; i++) {
			System.out.println(a * i);
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		}
	}
}

class MyThread3 extends Thread {
	Table1 t;

	MyThread3(Table1 t) {
		this.t = t;
	}

	public void run() {
		t.printTable(11);
	}
}

class MyThread4 extends Thread {
	Table1 t;

	MyThread4(Table1 t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}

public class SyncBlockDemo {

	public static void main(String[] args) {

		Table1 table = new Table1();
		MyThread3 t1 = new MyThread3(table);
		MyThread4 t2 = new MyThread4(table);
		t1.start();
		t2.start();

	}

}
