package com.trees.examples;

import java.util.ArrayList;
import java.util.Collections;

class Node4
{
	int data;
	Node4 left, right;
	
	Node4(int data)
	{
		this.data=data;
		left=right=null;
	}
}



public class KthSmallestElement {
	Node4 root;
	ArrayList<Integer> al_inOrder = new ArrayList<Integer>();
	
	
	private int kthsmallest(Node4 root, int k) {
		ArrayList <Integer> sorted = new ArrayList<Integer>();
		sorted=inOrderTraversal(root);
		return sorted.get(k-1);
	}

	
	
	private ArrayList<Integer> inOrderTraversal(Node4 node) {

		if (node == null)
			return al_inOrder;
		inOrderTraversal(node.left);
		al_inOrder.add(node.data);
		inOrderTraversal(node.right);
		Collections.sort(al_inOrder);

		return al_inOrder;
	}

	public static void main(String[] args) {
		
		KthSmallestElement tree = new KthSmallestElement();
		
		
		
		
		tree.root = new Node4(20);
		tree.root.left = new Node4(8);
		tree.root.right = new Node4(22);
		tree.root.left.left = new Node4(4);
		tree.root.left.right = new Node4(12);
		tree.root.right.left = new Node4(10);
		tree.root.right.right = new Node4(14);
		//tree.root.left.left.left = new Node4(10);
	//	tree.root.left.left.left.left= new Node4 (11);
		System.out.println(tree.kthsmallest(tree.root, 3));
		// TODO Auto-generated method stub

	}

	

}
