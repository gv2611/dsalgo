package com.arrays.examples;

import java.util.ArrayList;

public class MaxNonNegativeSubarray {
	

	private void getMaxNonNegative(int[] arr) {
		
		int left=0,right=arr.length-1,count=0,max_count=Integer.MIN_VALUE,sum=0, max_sum=Integer.MIN_VALUE;
		int start_index=0,end_index=0;
		ArrayList<Integer> al= new ArrayList<Integer>();
		
		for(int i=left;i<=right;i++)
		{
			//System.out.println("val of i "+i+ "");
			while(i<right+1 && arr[i]>=0)
			{
				start_index=i;

				count++;
				sum=sum+arr[i];
				al.add(arr[i]);
				i++;
				if(count>max_count)
				{
					end_index=i-1;
					max_count=count;
					
				}
				
				if(sum>max_sum)
				{
					max_sum=sum;
					
				}
				if(count==max_count)
				{
					System.out.println("in here when xount is"+count);
				}
				
			//	if(count==max_count)
				//if(sum>max_sum)
					//max_sum=sum;
			}
			count=0;		
		}
		
		System.out.println("start index="+start_index+" end index= "+end_index);
		System.out.println(max_count);
		//System.out.println(al);
		
	}
	
	
	public static int[] LargestLongestFirst(int[] source)
	{
	    int curSum = 0, curStart = 0, curLength = 0,
	        maxSum = 0, maxSart = 0, maxLength = 0;
	    for (int index = 0; index < source.length; index++)
	    {
	        if (source[index] < 0)
	        {
	            if ((curSum > maxSum) || ((curSum == maxSum) && (curLength > maxLength))) 
	            {
	                maxSum = curSum;
	                maxSart = curStart;
	                maxLength = curLength;
	            }
	            curStart = index + 1;
	            curSum = curLength = 0;
	        }
	        else
	        {
	            curSum += source[index];
	            ++curLength;
	        }
	    }
	    if ((curSum > maxSum) || ((curSum == maxSum) && (curLength > maxLength)))
	    {
	        maxSum = curSum;
	        maxSart = curStart;
	        maxLength = curLength;
	    }
	    int[] result = new int[maxLength];
	    System.arraycopy(source, maxSart, result, 0, maxLength);
	    return result;
	}
	
	public int[] maxset(int[] A) {
        int len=A.length;
        long max_ans=-1, curr_sum=0;
        int start=0, end=0;
        int s=0, e=0;
        int val;
        for(int i=0;i<len;i++) {
            val=A[i];
            //If values is negative, reset sum to 0 and continue to next val
            if(val<0) {
                s=i+1;
                curr_sum=0;
                continue;
            }
            //For non-negative values, keep adding to sum
            curr_sum+=val;
            e=i;
            //Update global max according to given problem NOTE
            if(max_ans<curr_sum) {
                max_ans=curr_sum;
                start=s; end=e;
            }else if(max_ans == curr_sum && end-start < e-s) {
                start=s; end=e;
            }
        }
        //Return the values in range
        if(max_ans != -1) {
            int ans[] = new int[end-start+1];
            int j=0;
            for(int i=start;i<=end;){
                ans[j++] = A[i++];
            }
            return ans;
        }
        return new int[0];
    }
	
	public static void printArray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		MaxNonNegativeSubarray max = new MaxNonNegativeSubarray();
		int arr[]= {2,3,4,-1,-2,1,5,6,3};
		int arr2[]= {1,0, 0, 1, -1, -1, 0, 0, 1, 0};
		int a[]=max.maxset(arr);
		max.printArray(a);
		

	}


}
