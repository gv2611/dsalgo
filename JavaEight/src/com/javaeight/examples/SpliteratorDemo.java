package com.javaeight.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorDemo {
	
	public static void main(String args[])
	{
		List <String> names = new ArrayList<String>();
		names.add("Nitin");
		names.add("Garima");
		names.add("Gaurav");
		
		Spliterator <String> namesSpliterator  = names.spliterator();
		namesSpliterator.forEachRemaining(System.out::print);
	}

}
