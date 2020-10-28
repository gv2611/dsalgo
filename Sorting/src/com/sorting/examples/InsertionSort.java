package com.sorting.examples;

/* Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands. The array is virtually 
 * split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.*/
//Time Complexity Best, average and worst : Ω(n)	θ(n^2)	O(n^2)

public class InsertionSort {

	public static void main(String[] args) {
		
		InsertionSort insert= new InsertionSort();
		int arr[]= {6,7,4,2,34,8,879};
		insert.insertionSort(arr);
		

	}

	private void insertionSort(int[] arr) {
		
		long startTime = System.nanoTime();

		for(int i=1;i<arr.length;i++)
		{
			int key=arr[i];
			int j=i-1;
			
			while(j>=0 && key<arr[j])
			{
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1] = key;
		}
		long endTime = System.nanoTime();
		System.out.println("Total time taken in ms = "+(endTime-startTime));

		printArray(arr);
		
	}
	
	private void printArray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

}
