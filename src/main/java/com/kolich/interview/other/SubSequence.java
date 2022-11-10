package com.kolich.interview.other;
import java.util.*;

//Program to print Longest increasing subsequence in a given array
public class SubSequence {
	public static int getLow(int a[],int len,int key)
	{
		int left=-1;
		int right=len;
		while(right-left>1)
		{
			int mid=(left+right)/2;
			if(a[mid]<key)
				left=mid;
			else
				right=mid;
		}
		return right;
	}
	public static int[] lis(int a[])
	{
		int n=a.length;
		int b[]=new int[n];
		int len[]=new int[n];
		int x=0;
		for(int i=0;i<n;i++)
		{
			int j=getLow(b,x,a[i]);
			if(j==x)
				x++;
			b[j]=a[i];
			len[i]=j+1;
		}
		int ans[]=new int[x];
		for(int i=n-1;i>=0;i--)
			if(len[i]==x &&(x==ans.length || a[i]<ans[x]))
				ans[--x]=a[i];
		return ans;
			
	}
	public static void main(String args[])
	{
		int a[]={3,2,6,4,5,1};
		//expected answer is 2,4,5
		System.out.println("The original list is:"+Arrays.toString(a));
		System.out.println("Longest increasing subsequence: is"+Arrays.toString(lis(a)));
		
	}
}
