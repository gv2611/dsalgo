package com.treeexample;

import java.util.ArrayList;
import java.util.Collections;

class TreeNode {
	TreeNode left, right;
	int data;

	TreeNode(int d) {
		data = d;
		right = left = null;
	}
}

public class KthSmallestnumber {

	ArrayList<Integer> al_inOrder = new ArrayList<Integer>();
	static TreeNode root;

	public int kthsmallest(TreeNode root, int k) {

		ArrayList<Integer> sorted = new ArrayList<Integer>();
		inOrderTraversal(root);
		Collections.sort(al_inOrder);
		return al_inOrder.get(k - 1);
	}

	private void inOrderTraversal(TreeNode node) {

		if (node == null)
			return;
		inOrderTraversal(node.left);
		al_inOrder.add(node.data);
		inOrderTraversal(node.right);
		//Collections.sort(al_inOrder);

		//return al_inOrder;
	}

	public static void main(String[] args) {

		KthSmallestnumber small = new KthSmallestnumber();
		small.root = new TreeNode(4);
		small.root.left = new TreeNode(1);
		small.root.right = new TreeNode(9);
		small.root.left.left = new TreeNode(1);
		small.root.left.right = new TreeNode(19);
		small.root.right.left = new TreeNode(0);
		small.root.right.right = new TreeNode(51);
		System.out.println(small.kthsmallest(root, 5));

	}

}
