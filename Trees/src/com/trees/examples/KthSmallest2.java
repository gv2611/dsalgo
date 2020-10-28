package com.trees.examples;

import java.util.ArrayList;
import java.util.Collections;

class Node5
{
	
	int data; 
    Node5 left, right; 
    Node5(int x) 
    { 
        data = x; 
        left = right = null; 
    } 
}

public class KthSmallest2 {
	
	static ArrayList<Integer> al_inOrder = new ArrayList<Integer>();

	
	
	public static Node5 insert(Node5 root, int x) 
    { 
        if (root == null) 
            return new Node5(x); 
        if (x < root.data) 
            root.left = insert(root.left, x); 
        else if (x > root.data) 
            root.right = insert(root.right, x); 
        return root; 
    } 
	
	public static ArrayList<Integer> inOrderTraversal(Node5 node) {

		if (node == null)
			return al_inOrder;
		inOrderTraversal(node.left);
		al_inOrder.add(node.data);
		inOrderTraversal(node.right);

		return al_inOrder;
	}

	public static void main(String[] args) {
		
		 
        
        Node5 root = null; 
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 }; 
       
        for (int x : keys) 
            root = insert(root, x); 
          
        int k = 3; 
               // printKthSmallest(root, k); 
        System.out.println(inOrderTraversal(root));
          
          
    } 

	}


