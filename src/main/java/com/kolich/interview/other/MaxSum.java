package com.kolich.interview.other;

import java.util.Arrays;

//This is kadane's algo to print the max/ min sum of a subarray.
public class MaxSum {
	public static int[] func(int a[]) {
		int i, max_cur = Integer.MIN_VALUE;//For Min sum of array change this to Integer.MAX_VALUE;
		int max = max_cur;
		int begin = 0, end = 0,  temp=0;//temp if min sum is required
		
		for (i = 0; i < a.length; i++) {
			if (max_cur < 0) {//Change this to max_cur>0 for min sum
				max_cur = a[i];
				temp=i;
			} else 
				max_cur = max_cur + a[i];
			
			if (max_cur > max){//Change this to <= for min sum
				max = max_cur;
				begin=temp;
				end=i;
			}
		}
		System.out.println(max); //If the final answer required is the max sum.
		System.out.println(begin + " " + end); // If the final answer required is the range in the original array
		int ans[]=Arrays.copyOfRange(a, begin, end+1);// If the final answer requires the array.
		return ans;
	}
	public static void main(String args[])
	{
		int a[]={1,2,-13,-14,-5,-2,3,2,4,5,6,7,8,9};
		System.out.println(a.length);
		System.out.println(Arrays.toString(func(a)));
	}
}
