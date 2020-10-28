package breaker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class Threadexample {
	
	final static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

	final static java.util.Random rand = new java.util.Random();
	final static Set<String> identifiers = new HashSet<String>();

	public static String randomIdentifier() {
		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = rand.nextInt(5) + 5;
			for (int i = 0; i < length; i++) {
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
			if (identifiers.contains(builder.toString())) {
				builder = new StringBuilder();
			}
		}
		return builder.toString();
	}
	public static void main(String[] args) throws InterruptedException {
		final PC pc = new PC();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Random r = new Random();
				int low = 10;
				int high = 100;
				while (true) {
					ArrayList<Person> persons = new ArrayList<Person>();
					for (int i = 0; i < r.nextInt(10); i++) {
						int result = r.nextInt(high - low) + low;
						String name = randomIdentifier();
						persons.add(new Person(result, name));
					}
					try {
						pc.produce(persons);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

	public static class Person {
		int age;
		String name;

		Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.name + " " + this.age;
		}

	}

	public static class PC {

		LinkedList<String> list = new LinkedList<>();
		LinkedList<String> list2 = new LinkedList<>();
		int capacity = 2;

		public void produce(ArrayList<Person> p) throws InterruptedException {
			synchronized (this) {
				while (list.size() == capacity)
					wait();

				for (Person p1: p) {
					System.out.println("Producer produced-" + p1.toString());
					list.add(p1.toString());
				}
				

				notify();

				Thread.sleep(10);
			}
		}

		

		public void consume() throws InterruptedException {
			while (true) {
				synchronized (this) {
					while (list.size() == 0)
						wait();
					
					int nremoved = 0;
					ArrayList<String> persons = new ArrayList<String>();
					while (nremoved < 10 && list.size() != 0) {
						String person = list.removeFirst();	
						persons.add(person);
						nremoved++;
					}
					
					for (String person : persons) {
						System.out.println("Consumer consumed-" + person);	
					}
				
					persons = new ArrayList<String>();
					if (list2.size() != 0) {
						while (nremoved < 10 && list2.size() > 0) {
							persons.add(list2.removeFirst());
							nremoved++;
						}
						for (String person : persons) {
							System.out.println("Consumer consumed-" + person);	
						}
					}

					notify();
					Thread.sleep(1000);
				}
			}
		}
	}
}
