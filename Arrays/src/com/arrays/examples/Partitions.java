package com.arrays.examples;

public class Partitions {

	public static void main(String[] args) {
		
		Partitions p = new Partitions();
		int arr[] = {0,1,-1,0};
		System.out.println(p.partition(arr));

	}

	private int partition(int[] arr) {
		int sum = calculateSum(arr);
		boolean partitionExists=false;
		if(sum%3 !=0)
			return 0;
		int eachPartition = sum/3;
		System.out.println(eachPartition);
		int finalcount=1;
		sum=0;
		int count=0;
		//System.out.println(eachPartition);
		for(int i=0;i<arr.length;i++)
		{
			sum=sum+arr[i];
			if(sum>eachPartition)
				return 0;
			if(sum==eachPartition)
			{
				sum=0;
				count++;
				continue;
			}
		}
		if(count==3)
		{
			System.out.println("here");
			partitionExists=true;
		}
		System.out.println(partitionExists);
		
		int noOfZeroes = calNumOfZeroes(arr);
		System.out.println(noOfZeroes);
		if(partitionExists && eachPartition==0)
			return 1;
		if(partitionExists && eachPartition !=0 && noOfZeroes==1)
			return 2;
		if(partitionExists && eachPartition !=0 && noOfZeroes>1)
		{
			for(int c=0;c<=noOfZeroes;c++)
				 finalcount=finalcount+c;
		}
		return finalcount;
	}

	private int calNumOfZeroes(int[] arr) {
		int count =0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==0)
				count++;
		}
		return count;
	}

	private int calculateSum(int[] arr) {
		int sum= 0;
		for(int i=0;i<arr.length;i++)
		{
			sum=sum+arr[i];
		}
		return sum;
	}

}
