package com.example.multithreading;

class Customer {
	int amount = 10000;

	synchronized public void withdraw(int withdrawn) {
		if (amount < withdrawn) {
			System.out.println("Insufficient Balance!");
			try
			{
				wait();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		} else
		{
			amount = amount - withdrawn;
			System.out.println("Account Balance is "+amount);
		}
	}

	synchronized public void deposit(int deposited) {
		System.out.println("In deposited fuction");
		System.out.println("Amount credited with rupees "+deposited);
		amount = amount + deposited;
		System.out.println("Account Balance is "+amount);
		notify();
	}

}

class Thread1 extends Thread
{
	Customer c;
	Thread1(Customer c)
	{
		this.c=c;
	}
	
	public void run()
	{
		c.withdraw(100000);
		try
		{
			Thread.sleep(200);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
	}
}


class Thread2 extends Thread
{
	Customer c;
	Thread2(Customer c)
	{
		this.c=c;
	}
	
	public void run()
	{
		c.deposit(100);
		try
		{
			Thread.sleep(200);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
	}
}
public class InterthreadCommunicationDemo {
	public static void main(String args[])
	{
		Customer c = new Customer();
		Thread1 t1= new Thread1(c);
		Thread2 t2= new Thread2(c);
		t1.start();
		t2.start();
		
	}

}
