	package com.trees.examples;

import java.util.ArrayList;

class Node6
{
	Node6 left, right;
	int data;
	
	Node6(int data)
	{
		this.data= data;
	}
}

public class ArrayToBalancedBST {
	Node6 root = null;
	ArrayList<Integer> al_preOrder = new ArrayList<Integer>();
	ArrayList<Integer> al_inOrder = new ArrayList<Integer>();

	
	
	
	
	public Node6 sortedArrayToBST(final int[] A) {
        int start= 0, end =A.length-1;
        Node6 newNode = convertToBalancedBST(A,start,end);
        return newNode;
    }
	
	private Node6 convertToBalancedBST (int arr[], int start, int end)
	{
		if(start > end)
			return null;
		
		int mid = (start+end)/2;
		Node6 node = new Node6(arr[mid]);
		node.left = convertToBalancedBST(arr, start, mid-1);
		node.right = convertToBalancedBST(arr, mid+1, end);
		return node;
		
	}
	

	private ArrayList<Integer> preOrderTraversal(Node6 node) {

		if (node == null)
			return al_preOrder;
		al_preOrder.add(node.data);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);

		return al_preOrder;
	}
	private ArrayList<Integer> inOrderTraversal(Node6 node) {

		if (node == null)
			return al_inOrder;
		inOrderTraversal(node.left);
		al_inOrder.add(node.data);
		inOrderTraversal(node.right);

		return al_inOrder;
	}

	public static void main(String[] args) {
		ArrayToBalancedBST bst = new ArrayToBalancedBST();
		int arr[] = {1};
		Node6 newNode = bst.sortedArrayToBST(arr);
		System.out.println(bst.inOrderTraversal(newNode));
	}

}
