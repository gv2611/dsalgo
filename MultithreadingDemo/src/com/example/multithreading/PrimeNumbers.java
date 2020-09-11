package com.example.multithreading;

public class PrimeNumbers {

	public static void main(String[] args) {
		PrimeNumbers pn = new PrimeNumbers();
		pn.findPrimes();
	}

	private void findPrimes() {
		//int lower_range=2, upper_range=100000;
		//int number_of_threads=5;
		//int intervals = (upper_range - lower_range)/number_of_threads;
		int flag;
		for(int i = 2;i<=100000 ;i++)
		{		
			flag=0;
			for (int j=2 ; j< Math.sqrt(i);j++)		
			{
				if(i%j == 0)
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				System.out.println(i);
			}
		}
		
	}
}
