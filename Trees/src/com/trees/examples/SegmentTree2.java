package com.trees.examples;

class Range {
	int left, right;

	Range(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	boolean equals(Range other) {
		return (this.left == other.left && this.right == other.right);
	}
	
	int getMid() {
		return this.left + (this.right - this.left)/2;
	}
}

public class SegmentTree2 {

	int segmentTree[];
	Range nodeRange[];

	SegmentTree2(int arr[], int n) {
		int heightOfST = (int) Math.ceil(Math.log(n) / Math.log(2));
		int maxSize = 2 * (int) Math.pow(2, heightOfST) - 1;
		segmentTree = new int[maxSize];
		nodeRange= new Range[maxSize];

		ConstructSegmentTree(arr, 0, n - 1, 0);
	}

	private int ConstructSegmentTree(int[] arr, int start, int end, int current) {

		if (start == end) {
			segmentTree[current] = arr[start];
			nodeRange[current] = new Range(start,end);
			return arr[start];

		}

		int mid = getMid(start, end);
		nodeRange[current] = new Range(start, end);
		segmentTree[current] = ConstructSegmentTree(arr, start, mid, current * 2 + 1)
				+ ConstructSegmentTree(arr, mid + 1, end, current * 2 + 2);
		//printArray(segmentTree);
		return segmentTree[current];

	}

	private void printArray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
	}
	private int getMid(int start, int end) {
		return start + (end - start) / 2;
	}

	private int getSum(int length, Range range) {
		if (range.left < 0 || range.right > length - 1 || range.left > range.right) {
			System.out.println("invalid input");
			return -1;
		}
		return getSumUtil(range, 0);

	}

	private int getSumUtil(Range range, int current) {
		int start = nodeRange[current].left;
		int end = nodeRange[current].right;
		System.out.println(start + "," + end + ", [" + range.left + "," + range.right+ "] " + current);
		
		if (start == end || range.equals(nodeRange[current])) {
			return segmentTree[current];
		}
		
		int mid = getMid(start, end);
		if (range.right <= mid) {
			return getSumUtil(range, 2 * current + 1);
		} else if (range.left > mid) {
			return getSumUtil(range, 2 * current + 2);
		}
		return getSumUtil(new Range(range.left, mid), 2 * current + 1) + getSumUtil(new Range(mid + 1, range.right), 2 * current + 2);

	}

	
	private void updateValue(int[] arr, int length, int i, int newValue) {
		
		if(i<0 || i>length-1)
		{
			System.out.println("invalid input");
			return;
		}
		int diff = newValue-arr[i];
		arr[i]=newValue;
		
		updateValueUtil (0, length-1, i, diff, 0);
	}

	private void updateValueUtil(int start, int end, int location, int diff, int current) {
		
		if(location < start || location > end)
			return;
		
		segmentTree[current] = segmentTree[current] + diff;
		if(end != start)
		{
			int mid = getMid(start, end);
			updateValueUtil(start, mid, location, diff, current*2+1);
			updateValueUtil(mid+1, end, location, diff, current*2+2);
			
		}
		
	}
	public static void main(String[] args) {
		int arr[] = { 1, 6, 54, 8, 3, 57, 7, 3, 23 };
		SegmentTree2 st = new SegmentTree2(arr, arr.length);
		Range range = new Range(5, 7);

		System.out.println(st.getSum(arr.length, range));
		st.updateValue(arr, arr.length, 6, 10);
		System.out.println(st.getSum(arr.length, range));

	}


}
