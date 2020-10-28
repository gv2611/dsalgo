package com.trees.examples;


class Node2{
	Node2 left, right;
	int data;
	
	Node2(int data)
	{
		this.data= data;
		left= right = null;
	}
}


public class MaxDepth {
	Node2 root=null;
	
	public int findDepth(Node2 root)
	{
		
		if(root == null)
			return 0;
		
		else
		{
			int leftDepth = findDepth(root.left);
			int rightDepth = findDepth(root.right);
			
			if(leftDepth < rightDepth)
				return rightDepth+1;
			
			else
				return leftDepth+1;
			
		}			
	}


	public static void main(String[] args) {
		
		MaxDepth md = new MaxDepth();
		md.root = new Node2(1);
		md.root.left= new Node2(2);
		md.root.right = new Node2(3);
		md.root.left.left = new Node2(4);
		md.root.left.left.left = new Node2(5);
		System.out.println(md.findDepth(md.root));

	}

}
