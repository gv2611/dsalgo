package com.treeexample;

import java.util.ArrayList;

class TreeNode2 {
	TreeNode2 left;
	TreeNode2 right;
	int data;

	TreeNode2(int d) {
		data = d;
		right = left = null;
	}
}

public class SortedArrayToBST {
	
	public static void main (String[] args)
    {
		 int A1[] = {1, 2, 3};
	        int A2[] = {1, 2, 3};
	        if (A1.equals(A2))
	            System.out.println("Same");
	        else
	            System.out.println("Not same");
     }
    


}
