package com.trees.examples;

public class BinaryIndexTree {

	final static int MAX = 1000;
	static int BItree[] = new int[MAX];

	public static void main(String[] args) {

		BinaryIndexTree BI = new BinaryIndexTree();
		int arr[] = { 3, 6, 7, 54, 3, 89, 76, 45, 90 };
		BI.createBI(arr);
		long startTime=System.nanoTime();
		System.out.println(BI.getSum(8));
		long endTime=System.nanoTime();
		System.out.println("Total time taken in ns : "+(endTime-startTime));
		// TODO Auto-generated method stub
		long startTime2=System.nanoTime();

		System.out.println(BI.getSum2(arr, 8));
		long endTime2=System.nanoTime();
		System.out.println("Total time taken in ns wihtout using BItree : "+(endTime2-startTime2));


	}

	private int getSum2(int[] arr, int index) {
		int sum=0;
		for(int i=0;i<=index;i++)
		{
			sum=sum+arr[i];
		}
		return sum;
			
		
	}

	private void createBI(int[] arr) {

		for (int i = 0; i < arr.length; i++)
			BItree[i] = 0;

		for (int i = 0; i < arr.length; i++)
			updateBITree(arr.length, i, arr[i]);

	}

	private void updateBITree(int length, int index, int val) {
		index = index+1;
		while(index <= length)
		{
			BItree[index]  +=val;
			index += index & (-index);
		}
	}
	
	private int  getSum(int index)
	{
		int sum=0;
		index = index+1;
		while(index >0)
		{
			sum = sum+ BItree[index];
			index -=index &(-index);
		}
		return sum;
	}

}
