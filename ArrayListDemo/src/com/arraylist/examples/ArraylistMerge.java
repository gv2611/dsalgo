package com.arraylist.examples;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraylistMerge {

	public static void main(String[] args) {
		ArraylistMerge alm = new ArraylistMerge();
		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(-4,3));
		ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(-2,-2));

		System.out.println(alm.merge2(arr1, arr2));

	}

	private ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {

		int i = 0;
		int j = 0;
		while (i < a.size() && j < b.size()) {
			if (a.get(i) <= b.get(j)) {
				i++;
			} else {
				a.add(i, b.get(j));
				j++;
			}
		}
		while (j < b.size()) {
			a.add(i, b.get(j));
			j++;
		}
		
		return a;
	}
	
	private ArrayList<Integer> merge2(ArrayList<Integer> a, ArrayList<Integer> b) {
		int itr=0;
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i)<b.get(itr))
				continue;
			else if(a.get(i)>=b.get(itr))
			{
				a.add(i, b.get(itr));
				itr++;
			}
		}
		while(itr!=b.size()-1)
		{
			a.add(b.get(itr));
			itr++;
		}
		
		return a;

	}

}
