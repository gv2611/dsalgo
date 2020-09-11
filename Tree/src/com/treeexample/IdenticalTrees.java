package com.treeexample;

class Node2
{
	Node2 left, right;
	int data;
	
	Node2(int d)
	{
		data=d;
		left = right = null;
	}
}

public class IdenticalTrees {
	Node2 root1, root2;
	
	private boolean isIdentical(Node2 root1, Node2 root2) {
		
		if(root1 == null && root2== null)
			return true;
		if(root1!=null && root2!=null)
		{
			return(root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
		}
		
		return false;
	}
	
	private int isIdentical2( Node2 root1, Node2 root2)
	{
		boolean flag=isIdentical(root1, root2);
		if(flag==true)
		{
			return 1;
		}
		else
			return 0;
	}

	public static void main(String[] args) {
		IdenticalTrees tree= new IdenticalTrees();
		//it.root2 = new Node2(1);
	    tree.root1 = new Node2(1); 
        tree.root1.left = new Node2(2); 
        tree.root1.right = new Node2(3); 
        tree.root1.left.left = new Node2(4); 
        tree.root1.left.right = new Node2(5); 
   
        tree.root2 = new Node2(1); 
        tree.root2.left = new Node2(2); 
        tree.root2.right = new Node2(3); 
        tree.root2.left.left = new Node2(4); 
        tree.root2.left.right = new Node2(5); 
		
		System.out.println(tree.isIdentical2 (tree.root1, tree.root2) );
		

	}

	

}
