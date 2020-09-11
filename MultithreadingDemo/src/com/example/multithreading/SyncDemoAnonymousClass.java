package com.example.multithreading;

class Table2 {

	void printTable(int n) {
		synchronized (this) {
			for (int i = 1; i <= 10; i++) {
				System.out.println(n * i);
				try {
					Thread.sleep(400);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}

public class SyncDemoAnonymousClass {
	public static void main(String args[]) {
		Table2 obj = new Table2();

		Thread t1 = new Thread() {
			public void run() {
				obj.printTable(5);
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				obj.printTable(100);
			}
		};

		t1.start();
		t2.start();
	}
}
