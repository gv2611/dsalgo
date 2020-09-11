package com.multithreading.examples;

public class MultithreadingDemo extends Thread {
	private String str;
	
	MultithreadingDemo(String str)
	{
		this.str=str;
	}
	
	
	/*public void run()
	{
		System.out.println("the thread is running...");
		try {
			sleep(2000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("the thread has run.");
		
	}*/
	
	/*
	 * public void run(){ for(int i=1;i<5;i++){
	 * try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
	 * System.out.println(i+"  "+this.str); } }
	 */
	
	public void run()
	{
		for(int i=1; i<5; i++)
		{
			try
			{
				Thread.sleep(500);
				
			}
			catch (InterruptedException e)
			{
				System.out.println(e);
			}
			System.out.println(i+" "+this.str);
			System.out.println(Thread.currentThread().getName());
			System.out.println("Priority:"+Thread.currentThread().getPriority());
			

		}
	}
	
	
	//public void start()
	//{
	//	System.out.println("thread is in start state");
	//}

	public static void main(String[] args) {
		
		MultithreadingDemo md = new MultithreadingDemo("a");
		MultithreadingDemo md2 = new MultithreadingDemo("b");
		MultithreadingDemo md3 = new MultithreadingDemo("c");
		md.setPriority(Thread.MAX_PRIORITY);


		md.start();
		//md2.start();
		//md.run();
		//md2.run();
		
		try
		{
			md.join(1500);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		md2.start();
		md3.start();
		md2.setName("Thread B");
		System.out.println(md2.getName());
		System.out.println(md2.getId());
		
		
		//System.out.println(md.isDaemon());
		//System.out.println(md.isAlive());

	}

}
