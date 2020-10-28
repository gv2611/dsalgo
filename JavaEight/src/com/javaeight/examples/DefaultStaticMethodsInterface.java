package com.javaeight.examples;


interface interface1
{
	void method1();
	default void log(String str)
	{
		System.out.println("log method of interface 1 that prints : "+str);
	}
	
	static void print (String str)
	{
		System.out.println(str);
	}
	
}

interface interface2
{
	void method2();
	
	static void log(String str)
	{
		System.out.println("log method of interface 2 that prints : "+str);
	}
	
	static void print2 (String str)
	{
		System.out.println("interface 2 : static method print 2");
	}
}


public class DefaultStaticMethodsInterface implements interface1, interface2 {

	@Override
	public void method2() {
		
	}

	@Override
	public void method1() {
		
	}
	
	

	//@Override
	//public void log(String str) {
	//	interface1.super.log(str);
	//}
	
	//public void log2(String str)
	//{
	//	interface2.super.log2(str);
	//}
	
	
	
	
	
	@Override
	//public void log(String str) {
		// TODO Auto-generated method stub
		//interface1.super.log(str);
	//}
	
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		interface1.print("abc");
		interface1.super.log(str);
		interface2.log(str);
	}

	public static void main(String args[])
	{
		DefaultStaticMethodsInterface dm= new DefaultStaticMethodsInterface();
		dm.log("Hi");
		interface2.print2("hey");
		
	}
	
	

}
