package com.arrays.examples;

public class MaxAbsoluteDifference {
	
	private int findMaxAbsoluteDifference(int[] array) {
		
		int max1= Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		for(int i =0 ; i<array.length;i++)
		{
			max1= Math.max(max1, array[i]+i);
			min1 = Math.min(min1, array[i]+i);
			max2 = Math.max(max2 , array[i]-i);
			min2 = Math.min(min2, array[i]-i);
			 
		}
		return Math.max(max1-min1,max2-min2);
		
		
	}

	public static void main(String[] args) {
		MaxAbsoluteDifference max = new MaxAbsoluteDifference();
		int array[] = {-70, -64, -6, -56, 64, 
                61, -57, 16, 48, -98};
		System.out.println(max.findMaxAbsoluteDifference(array));

	}



}
