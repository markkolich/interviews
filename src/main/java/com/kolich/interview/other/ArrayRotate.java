package com.kolich.interview.other;



//import java.util.*;
public class ArrayRotate {
	
			
	public void print(int arr[][]){
		int m=arr.length;
		int n=arr[0].length;
		for(int i=0;i<m;i++){		
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]+"\t");
			}
		System.out.println();
		}
	}
	public int [][] rotate(int arr[][],int n){
		int tmp;
		int a[][]=arr;
		for (int i=0; i<n/2; i++){
	        for (int j=i; j<n-i-1; j++){
	                tmp=a[i][j];
	                a[i][j]=a[j][n-i-1];
	                a[j][n-i-1]=a[n-i-1][n-j-1];
	                a[n-i-1][n-j-1]=a[n-j-1][i];
	                a[n-j-1][i]=tmp;
	        }
	}
		
		return arr;
	}
	
	public int [] rev(int a[])
	{
		int j=a.length-1;
		int i=0;
		int t;
		while(i<j)
		{
			t=a[j];
			a[j]=a[i];
			a[i]=t;
			i++;
			j--;
		}
		return a;
	}
	public int[][] rotate(int arr[][])
	{
		
		
		int r,c;
		r=arr.length;
		c=arr[0].length;

	
		int t[][]=new int[c][r];
		int temp=r;
		r=c;
		c=temp;
		for(int i=0;i<c;i++)
		{
			for(int j=0;j<r;j++)
				{
					t[j][i]=arr[i][j];
				}
		}
		for(int i=0;i<r;i++)
			t[i]=rev(t[i]);
		return t;
	}
	public static void main(String args[]){
		ArrayRotate ar=new ArrayRotate();

		
		int arr[][]={{1,2,3},
					{4,5,6},
					{7,8,9}
					};
		
		
		ar.print(arr);
		arr=ar.rotate(arr,arr.length);
		
		System.out.println("Rotated array is:\n");
		ar.print(arr);

	}

}
