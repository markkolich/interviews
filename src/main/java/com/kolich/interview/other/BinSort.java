package com.kolich.interview.other;

import java.util.Arrays;
//An Efficient program to sort an array of only 0s and 1s

public class BinSort {
	public static void sort(int a[])
	{
		int i=0;
		int j=a.length-1;
		while(i<j)
		{
			if(a[i]==1 && a[j]==0)
			{
				a[i]=0;
				a[j]=1;
			}
			if(a[i]==0)
				i++;
			if(a[j]==1)
				j--;
		}
	}
	public static void main(String args[])
	{
		
		int a[]={1,0,1,1,1,1,1,1,1,0,0,0,1,0,1,0,1,0,1,0};
		System.out.println("Before sorting: "+ Arrays.toString(a));
		sort(a);
		System.out.println("After Sorting: "+Arrays.toString(a));
	}
}
