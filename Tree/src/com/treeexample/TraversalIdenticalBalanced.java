package com.treeexample;

import java.util.ArrayList;

class Node3 {
	int data;
	Node3 left, right;

	Node3(int data) {
		this.data = data;
		left = right = null;
	}
}

public class TraversalIdenticalBalanced {
	Node3 root = null;
	ArrayList<Integer> al_InOrder = new ArrayList<Integer>();
	ArrayList<Integer> al_PreOrder = new ArrayList<Integer>();
	ArrayList<Integer> al_PostOrder = new ArrayList<Integer>();

	public ArrayList<Integer> inOrderTraverse(Node3 node) {
		if (node == null)
			return al_InOrder;
		inOrderTraverse(node.left);
		al_InOrder.add(node.data);
		inOrderTraverse(node.right);
		return al_InOrder;
	}
	
	public ArrayList<Integer> preOrderTraverse(Node3 node) {
		if (node == null)
			return al_PreOrder;
		al_PreOrder.add(node.data);
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
		return al_PreOrder;
	}
	
	public ArrayList<Integer> postOrderTraverse(Node3 node) {
		if (node == null)
			return al_PostOrder;
		postOrderTraverse(node.left);
		postOrderTraverse(node.right);
		al_PostOrder.add(node.data);
		return al_PostOrder;
	}
	
	

	public static void main(String[] args) {

		TraversalIdenticalBalanced tree = new TraversalIdenticalBalanced();
		ArrayList<Integer> al_InOrderOp = new ArrayList<Integer>();
		ArrayList<Integer> al_PreOrderOp = new ArrayList<Integer>();
		ArrayList<Integer> al_PostOrderOp = new ArrayList<Integer>();
		tree.root = new Node3(1);
		tree.root.left = new Node3(2);
		tree.root.right = new Node3(3);
		tree.root.left.left = new Node3(4);
		tree.root.left.right = new Node3(5);
		tree.root.right.left = new Node3(6);
		tree.root.right.right = new Node3(7);
		al_InOrderOp = tree.inOrderTraverse(tree.root);
		System.out.println(al_InOrderOp);
		System.out.println(tree.preOrderTraverse(tree.root));
		System.out.println(tree.postOrderTraverse(tree.root));

		// TODO Auto-generated method stub

	}

}
