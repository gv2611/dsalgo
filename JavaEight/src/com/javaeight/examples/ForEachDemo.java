package com.javaeight.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachDemo {

	public static void main(String[] args) {
		ForEachDemo fe = new ForEachDemo();
		fe.example();
	}

	private void example() {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i =0;i<10;i++)
			list.add(i);
		
		Iterator <Integer> it = list.iterator();
		while(it.hasNext())
		{
			Integer value = it.next();
			System.out.println(value);
		}
		
		
		list.forEach(new Consumer<Integer>(){
			public void accept(Integer t)
			{
				System.out.println("value here"+t);
			}
		});
		
		list.forEach((n) -> {System.out.println("lambda"+n);});
		
		//MyConsumer action = new MyConsumer();
		
	}

}
