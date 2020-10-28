package com.trees.examples;

import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
	}
}

public class FindLeastCommonAncestor {
	
	Node root = null;
	ArrayList <Integer> path1 = new ArrayList<Integer>();
	ArrayList <Integer> path2 = new ArrayList<Integer>();

	
	public boolean findPath (Node root, int toFind, List<Integer> path)
	{
		if( root == null)
			return true;
		
		path.add(root.data);
		if(root.data == toFind)
			return true;
		if(root.left!= null && findPath(root.left, toFind, path ))
			return true;
		if(root.left!=null && findPath(root.right, toFind, path))
			return true;
		//path.remove(path.size()-1);
		//System.out.println(path);
		return false;
			
	}
	 public int findLCA (Node root, int a, int b)
	 {
		 if(!findPath(root, a, path1 )|| !findPath(root, b, path2))
		 {
			 System.out.println(path1.size()>0 ? "A is found" : "A is missing");
			 System.out.println(path2.size()>0 ?" B is found" :" B is missing");
			 
		 }
		 
		 int i;
		 for(i = 0 ; i< path1.size() && i <path2.size(); i++)
		 {
			 if(!path1.get(i).equals(path2.get(i)))
			 {
				 break;
			 }
		 }
		 
		 return path1.get(i-1);
		 
	 }
	

	public static void main(String[] args) {
		
		FindLeastCommonAncestor  lca = new FindLeastCommonAncestor();
		
		
		lca.root = new Node(1);
		lca.root.left = new Node(2);
		lca.root.right = new Node(3);
		lca.root.left.left = new Node(4);
		lca.root.left.right = new Node(5);
		lca.root.right.left = new Node(6);
		lca.root.right.right = new Node(7);
		lca.root.right.right.left= new Node(11);
		
		//lca.findPath(lca.root, 7);
		
		System.out.println(lca.findLCA(lca.root, 7, 11));

	}

}
