package com.trees.examples;

import java.util.ArrayList;

class Node0 {
	int data;
	Node0 left, right;

	Node0(int data) {
		this.data = data;
	}
}

public class TraversalIdenticalBalanced {

	Node0 root;
	ArrayList<Integer> al_inOrder = new ArrayList<Integer>();
	ArrayList<Integer> al_preOrder = new ArrayList<Integer>();
	ArrayList<Integer> al_postOrder = new ArrayList<Integer>();

	private ArrayList<Integer> inOrderTraversal(Node0 node) {

		if (node == null)
			return al_inOrder;
		inOrderTraversal(node.left);
		al_inOrder.add(node.data);
		inOrderTraversal(node.right);

		return al_inOrder;
	}
	
	private ArrayList<Integer> preOrderTraversal(Node0 node) {

		if (node == null)
			return al_preOrder;
		al_preOrder.add(node.data);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);

		return al_preOrder;
	}
	
	private ArrayList<Integer> postOrderTraversal(Node0 node) {

		if (node == null)
			return al_postOrder;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		al_postOrder.add(node.data);

		return al_postOrder;
	}
	
	private boolean isIdentical(Node0 node1, Node0 node2)
	{
		if(node1 == null && node2== null)
			return true;
		if(node1!=null && node2!=null)
		{
		return(node1.data == node2.data && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right));
		}
		return false;
	}
	
	private boolean isBalanced(Node0 n1)
	
	{
	
		if(n1 == null)
			return true;
		
		int heightLeft = findHeight (n1.left);
		int heightRight = findHeight (n1.right);
		
		if(Math.abs(heightRight-heightLeft)<=1 && isBalanced(n1.left) && isBalanced(n1.right))
			return true;
		
		return false;
		
		
	}
	
	
	public int findHeight(Node0 n1)
	{
		int height= 0;
		if(n1== null)
			return 0;
		
		height = 1 + Math.max(findHeight(n1.left), findHeight(n1.right));
		
		return height;
	}

	public static void main(String[] args) {

		TraversalIdenticalBalanced trees = new TraversalIdenticalBalanced();
		TraversalIdenticalBalanced trees2 = new TraversalIdenticalBalanced();

		trees.root = new Node0(1);
		trees.root.left = new Node0(2);
		trees.root.right = new Node0(3);
		trees.root.left.left = new Node0(4);
		trees.root.left.right = new Node0(5);
		trees.root.right.left = new Node0(6);
		trees.root.right.right = new Node0(7);
		trees.root.left.left.left = new Node0 (10);
		trees.root.left.left.left.left= new Node0(11);
		//trees.inOrderTraversal(trees.root);
		
		trees2.root = new Node0(9);
		trees2.root.left = new Node0(9);
		trees2.root.right = new Node0(3);
		trees2.root.left.left = new Node0(4);
		trees2.root.left.right = new Node0(5);
		trees2.root.right.left = new Node0(6);
		trees2.root.right.right = new Node0(7);
		
		System.out.println(trees.inOrderTraversal(trees.root));
		System.out.println(trees.preOrderTraversal(trees.root));
		System.out.println(trees.postOrderTraversal(trees.root));
		
		System.out.println("Are the trees Identical? "+(trees.isIdentical(trees.root, trees2.root)));
		System.out.println("Is the tree Balanced? "+(trees.isBalanced(trees.root)));

	}

}
