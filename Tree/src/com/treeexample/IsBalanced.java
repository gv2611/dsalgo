package com.treeexample;


class Node1
{
	Node1 left, right;
	int data;
	Node1(int d)
	{
		data= d;
		right = left = null;
	}
}

public class IsBalanced {
	
	Node1 root;
	
	public static int isBalanced(Node1 node)
	{
		int left_height, right_height;
		if(node == null)
			return 1;
		
		left_height = height (node.left);
		right_height = height (node.right);
		if(Math.abs(left_height - right_height) <= 1 && isBalanced(node.left)==1 && isBalanced(node.right)==1)
				return 1;
		
		return 0;
		
	}
	
	public static int height (Node1 node)
	{
		if(node == null)
			return 0;
		
		return 1 + Math.max(height(node.left),height( node.right));
	}
	
	

	public static void main(String[] args) {
		IsBalanced balanced = new IsBalanced();
		balanced.root = new Node1(1);
		balanced.root.left = new Node1(2);
		balanced.root.right = new Node1(3);
		balanced.root.left.left = new Node1(4);
		balanced.root.left.right = new Node1(5);
		balanced.root.left.left.left = new Node1 (10);
		int isBalanced = isBalanced(balanced.root);
		System.out.println("Is the tree balanced? "+isBalanced);
		

	}

}
