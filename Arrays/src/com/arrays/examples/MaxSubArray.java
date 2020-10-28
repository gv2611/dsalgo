package com.arrays.examples;

public class MaxSubArray {

	public int maxSubArray(final int[] arr) {

		int sum = 0;
		int max_sum = -1000000;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			
			if (sum < 0) {
				sum = 0;
			}
			System.out.println("sum="+sum);

			if (sum > max_sum) {
				max_sum = sum;
			}

		}
		return max_sum;
	}
	
	public int maxSubArray2(final int[] arr) {

		int sum = 0;
		int max_sum = -1000000;
		for (int i = 0; i < arr.length; i++) {
			sum = Math.max(sum + arr[i], arr[i]);
			System.out.println("sum="+sum);

			if (sum > max_sum) {
				max_sum = sum;
			}

		}
		return max_sum;
	}

	public static void main(String[] args) {
		int arr[]= {-5,-1,-10,-7};
		MaxSubArray max= new MaxSubArray();
		System.out.println(max.maxSubArray2(arr));

	}

}
