package com.treeexample;

import java.util.ArrayList;

class Node4 {
	int val;
	Node4 left, right;

	Node4(int val) {
		this.val = val;
		left = right = null;
	}
}

public class InvertTree {

	Node4 root = null;
	ArrayList<Integer> al_InOrder = new ArrayList<Integer>();
	
	public Node4 inverttree(Node4 root)
	{
		if(root == null)
			return null;
		
		Node4 left= inverttree(root.left);
		Node4 right= inverttree(root.right);
		
		root.left= right;
		root.right=left;
		
		return root;
			
	}
	
	public ArrayList<Integer> inOrderTraverse(Node4 node) {
		if (node == null)
			return al_InOrder;
		inOrderTraverse(node.left);
		al_InOrder.add(node.val);
		inOrderTraverse(node.right);
		return al_InOrder;
	}

	public static void main(String[] args) {

		InvertTree invert = new InvertTree();
		invert.root = new Node4(1);
		invert.root.left = new Node4(2);
		invert.root.right = new Node4(3);
		invert.root.left.left = new Node4(4);
		invert.root.left.right = new Node4(5);
		System.out.println(invert.inOrderTraverse(invert.root));
		invert.al_InOrder.clear();

		Node4 newNode = invert.inverttree(invert.root);
		System.out.println(invert.inOrderTraverse(newNode));

	}

}
