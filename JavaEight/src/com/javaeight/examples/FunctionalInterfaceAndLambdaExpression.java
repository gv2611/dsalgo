package com.javaeight.examples;

public class FunctionalInterfaceAndLambdaExpression implements Runnable {

	@Override
	public void run() {
		//System.out.println("abc");
		// TODO Auto-generated method stub

	}
	
	Runnable r= new Runnable() {
		@Override
		public void run() {
			System.out.println("my runnable");
		}
	};
	
	Runnable r1 = ()->{
		System.out.println("lambda");
	};

	public static void main(String args[])
	{
		FunctionalInterfaceAndLambdaExpression demo = new FunctionalInterfaceAndLambdaExpression();
		demo.run();
		
		
}
}
