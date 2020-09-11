//package com.example.multithreading;
//
//
//
//public class DeadlockDemo {
// 
//    public static void main(String[] args) {
//    	DeadlockDemo test = new DeadlockDemo();
// 
//        final A a = test.new A();
//        final B b = test.new B();
// 
//        // Thread-1
//        Runnable block1 = new Runnable() {
//            public void run() {
//                synchronized (b) {
//                	System.out.println("Acquired lock on A");
//                    try {
//                        // Adding delay so that both threads can start trying to
//                        // lock resources
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    // Thread-1 have A but need B also
//                    synchronized (a) {
//                        System.out.println("In block 1");
//                    }
//                }
//            }
//        };
// 
//        // Thread-2
//        Runnable block2 = new Runnable() {
//            public void run() {
//                synchronized (b) {
//                	System.out.println("Acquired lock on B");
//
//                    // Thread-2 have B but need A also
//                    synchronized (a) {
//                        System.out.println("In block 2");
//                    }
//                }
//            }
//        };
// 
//        new Thread(block1).start();
//        new Thread(block2).start();
//    }
// 
//    // Resource A
//    private class A {
//        private int i = 10;
// 
//        public int getI() {
//            return i;
//        }
// 
//        public void setI(int i) {
//            this.i = i;
//        }
//    }
// 
//    // Resource B
//    private class B {
//        private int i = 20;
// 
//        public int getI() {
//            return i;
//        }
// 
//        public void setI(int i) {
//            this.i = i;
//        }
//    }
//}
package com.example.multithreading;

import java.util.HashMap;

public class DeadlockDemo {
 
	static String removeSpaces(String s) {
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				ret.append(s.charAt(i));
			}
		}
		return ret.toString();
	}
	
    public static void main(String[] args) {
    	String s = "a   b";
    	System.out.println(removeSpaces(s));
    }
}