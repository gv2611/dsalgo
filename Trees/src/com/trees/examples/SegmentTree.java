package com.trees.examples;

public class SegmentTree {
	
	int segmentTreeNodes[];
	
	SegmentTree(int arr[], int n)
	{
		int heightOfST = (int) Math.ceil(Math.log(n)/Math.log(2));
		int maxSize = 2*(int)Math.pow(2, heightOfST)-1;
		segmentTreeNodes = new int[maxSize];
		
		ConstructSegmentTree(arr, 0, n-1, 0);
	}

	private int ConstructSegmentTree(int[] arr, int start, int end, int current) {
		if(start==end) {
			segmentTreeNodes[current] = arr[start];
			return arr[start];
		}
		
		int mid = getMid(start,end);
		segmentTreeNodes[current] = ConstructSegmentTree(arr, start, mid, current*2+1) +
				ConstructSegmentTree(arr, mid+1, end, current*2+2);
		return segmentTreeNodes[current];
	}

	private int getMid(int start, int end) {
		return start+ (end-start)/2;
	}

	public static void main(String[] args) {
		int arr[]= {1,6,54,8,3,57,7,3,23};
		SegmentTree st = new SegmentTree(arr, arr.length);

		System.out.println(st.getSum(arr.length,1,3));

	}

	private int getSum(int  n, int queryStart, int queryEnd) {
		if(queryStart < 0 || queryEnd > n-1 || queryStart >queryEnd)
		{
			System.out.println("invalid input");
			return -1;
		}
		return getSumUtil(0,n-1,queryStart,queryEnd,0);
		
	}

	private int getSumUtil(int start, int end, int queryStart, int queryEnd, int current) {
		
		if(queryStart<= start && queryEnd >= end)
			return segmentTreeNodes[current];
		if(end < queryStart || start > queryEnd)
			return 0;
		int mid = getMid(start, end);
		return getSumUtil(start, mid, queryStart, queryEnd, 2*current+1) +
				getSumUtil(mid+1, end, queryStart, queryEnd,2* current+2);
		
	}

}
