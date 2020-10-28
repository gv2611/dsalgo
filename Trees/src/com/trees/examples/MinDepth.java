package com.trees.examples;
class Node3{
	int data;
	Node3 left, right;
	
	Node3(int data)
	{
		this.data = data;
	}
}


public class MinDepth {
	
	Node3 root = null;
	
	public int findMinDepth(Node3 root)
	{
		if(root == null)
			return 0;
		if(root.left == null && root.right== null)
			return 1;
		if(root.left == null)
			return findMinDepth(root.right)+1;
		if(root.right==null)
			return findMinDepth(root.left)+1;
		
		return Math.min(findMinDepth(root.left), findMinDepth(root.right )) +1;
		
	}
	
	

	public static void main(String[] args) {
		MinDepth md = new MinDepth();
		md.root = new Node3(1); 
        md.root.left = new Node3(2); 
        md.root.right = new Node3(3); 
        md.root.left.left = new Node3(4); 
        md.root.left.right = new Node3(5); 
        System.out.println(md.findMinDepth(md.root));
		
		

	}

}
