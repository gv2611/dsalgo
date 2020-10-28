package com.arrays.examples;

public class Partitions2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Partitions2 p = new Partitions2();
		int arr[] = { 0, 1, 2, 1, -1, 2, 1, -3, 1, 2, -1, 1, 2, 1, 0 };
		p.partition(arr);

	}

	private void partition(int[] arr) {
		int sum=0; int eachPartition=0;
		for(int i=0;i<arr.length;i++)
			sum=sum+arr[i];
		if(sum%3==0)
			eachPartition= sum/3;
		else
			System.out.println("no such partition");
		int arrayLeft[] = cumulativeSumFromLeft(arr);
		int arrayRight[] = cumulativeSumFromRight(arr);
		System.out.println("array left :");
		printArray(arrayLeft);
		System.out.println("array right :");
		printArray(arrayRight);
		int locationFromLeft[] = findLocationFromLeft(arrayLeft, eachPartition);
		int locationFromRight[] = findLocationFromRight(arrayRight, eachPartition);
		System.out.println("printing locations");
		printArray(locationFromLeft);
		printArray(locationFromRight);

		
		//return 0;
	}

	private int[] findLocationFromRight(int[] arrayRight, int eachPartition) {
		int locationFromRight[]= new int[3];
		int location=0;
		for(int i=0; i< arrayRight.length;i++)
		{
			if(arrayRight[i]==eachPartition)
			{
				locationFromRight[location] = i;
				location++;
			}
		}
		return locationFromRight;
	}

	private int[] findLocationFromLeft(int[] arrayLeft, int eachPartition) {

		int locationFromLeft[]= new int[3];
		int location=0;
		for(int i=0; i< arrayLeft.length;i++)
		{
			if(arrayLeft[i]==eachPartition)
			{
				locationFromLeft[location] = i;
				location++;
			}
		}
		return locationFromLeft;
	
	}

	private int[] cumulativeSumFromRight(int[] arr) {
		int right[] = new int[arr.length];
		int sum = 0;
		for (int i = arr.length-1; i >= 0; i--) {
			sum = sum + arr[i];
			right[i] = sum;
		}
		return right;
	}

	public void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i+"th location in array= "+arr[i]);
		}
	}

	private int[] cumulativeSumFromLeft(int[] arr) {
		int left[] = new int[arr.length];
		int sum = 0;
		for (int i = 0; i <arr.length; i++) {
			//System.out.println("sum=" + sum);
			sum = sum + arr[i];
			left[i] = sum;
		}
		return left;
	}

}
