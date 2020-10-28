package com.javaeight.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class SteamAPIDemo {
	public static void main(String args[]) {
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			myList.add(i);
		}

		Stream<Integer> sequential = myList.stream();
		Stream<Integer> parallel = myList.parallelStream();

		Stream<Integer> highNum = parallel.filter(p -> p > 90);
		Stream<Integer> sequenceHighNum = sequential.filter(p -> p > 90);

		// Iterator<Integer> itr = highNum.iterator();
		// while (itr.hasNext()) {
		// Integer i = itr.next();
		// System.out.println(i);

		// }

		highNum.forEach(p -> System.out.println(p));
		System.out.println("**********");
		sequenceHighNum.forEach(p -> System.out.println(p));

		System.out.println(myList.stream().filter(i -> i < 5).mapToInt(i -> i).sum());
		
		System.out.println(sumIterator(myList));

	}

	private static int sumIterator(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		int sum = 0;
		while (it.hasNext()) {
			int num = it.next();
			if (num > 10) {
				sum += num;
			}
		}
		return sum;
	}

}
