package com.treeexample;

import java.util.ArrayList;

class Node {
	int key;
	Node left;
	Node right;

	Node(int item) {
		key = item;
		left = right = null;
	}
}

public class TreeTraversal {
	Node root;
	ArrayList<Integer> al_InOrder = new ArrayList<Integer>();
	ArrayList<Integer> al_PreOrder = new ArrayList<Integer>();
	ArrayList<Integer> al_PostOrder = new ArrayList<Integer>();

	TreeTraversal() {
		root = null;
	}

	// Inorder (Left, Root, Right) : 4 2 5 1 3
	// Preorder (Root, Left, Right) : 1 2 4 5 3
	// Postorder (Left, Right, Root) : 4 5 2 3 1

	// normal function to print the tree

	void printInorder(Node node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.key + " ");
		printInorder(node.right);
	}

	// same function which returns an arraylist

	ArrayList<Integer> printInorder2(Node node) {
		if (node == null)
			return null;
		printInorder2(node.left);
		al_InOrder.add(node.key);
		printInorder2(node.right);
		return al_InOrder;
	}

	void printPreorder(Node node) {
		if (node == null)
			return;

		System.out.print(node.key + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	ArrayList<Integer> printPreorder2(Node node) {
		if (node == null)
			return null;
		al_PreOrder.add(node.key);
		printPreorder2(node.left);
		printPreorder2(node.right);
		return al_PreOrder;

	}

	void printPostorder(Node node) {
		if (node == null)
			return;

		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.key + " ");
	}

	ArrayList<Integer> printPostorder2(Node node) {
		if (node == null)
			return null;
		printPostorder2(node.left);
		printPostorder2(node.right);
		al_PostOrder.add(node.key);
		return al_PostOrder;

	}

	void printPostorder() {
		printPostorder(root);
	}

	void printInorder() {
		printInorder(root);
	}

	void printPreorder() {
		printPreorder(root);
	}

	static void buildMaxHeap(int arr[], int n) {
		int startIdx = (n / 2) - 1;
		for (int i = startIdx; i >= 0; i--) {
			heapifyMaxHeap(arr, n, i);
		}
	}

	static void buildMinHeap(int arr[], int n) {
		int startIdx = (n / 2) - 1;
		for (int i = startIdx; i >= 0; i--) {
			heapifyMinHeap(arr, n, i);
		}
	}

	static void heapifyMaxHeap(int arr[], int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		System.out.println("l="+l+" r="+r);

		if (l < n && arr[l] > arr[largest])
		{
			System.out.println("in if 1");
			System.out.println("arr[l]="+arr[l]+" arr[largest]="+arr[largest]);
			largest = l;
		}

		if (r < n && arr[r] > arr[largest])
			largest = r;
		System.out.println("largest="+largest);

		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			heapifyMaxHeap(arr, n, largest);
		}
	}

	static void heapifyMinHeap(int arr[], int n, int i) {
		int smallest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && arr[l] < arr[smallest])
			smallest = l;

		if (r < n && arr[r] < arr[smallest])
			smallest = r;

		if (smallest != i) {
			int swap = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = swap;
			heapifyMinHeap(arr, n, smallest);
		}
	}

	static void printHeap(int arr[], int n) {
		// System.out.println("Array representation of Heap is:");
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		TreeTraversal binarytree = new TreeTraversal();
		binarytree.root = new Node(1);
		binarytree.root.left = new Node(2);
		binarytree.root.right = new Node(3);
		binarytree.root.left.left = new Node(4);
		binarytree.root.left.right = new Node(5);
		ArrayList<Integer> alInOrderOutput = new ArrayList<Integer>();
		ArrayList<Integer> alPreOrderOutput = new ArrayList<Integer>();
		ArrayList<Integer> alPostOrderOutput = new ArrayList<Integer>();
		// the commented lines below are the function call that straightaway prints the
		// traversed nodes
		// binarytree.printInorder();
		// binarytree.printPostorder();
		// binarytree.printPreorder();
		alInOrderOutput = binarytree.printInorder2(binarytree.root);
		System.out.println(alInOrderOutput);
		alPreOrderOutput = binarytree.printPreorder2(binarytree.root);
		System.out.println(alPreOrderOutput);
		alPostOrderOutput = binarytree.printPostorder2(binarytree.root);
		System.out.println(alPostOrderOutput);
		System.out.println();
		int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
		int n = arr.length;
		buildMaxHeap(arr, n);
		System.out.println("\nPrinting Max Heap : ");
		printHeap(arr, n);
		buildMinHeap(arr, n);
		System.out.println("Printing Min Heap : ");
		printHeap(arr, n);

	}

}
