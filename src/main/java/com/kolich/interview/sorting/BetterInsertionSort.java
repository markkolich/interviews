package com.kolich.interview.sorting;

import java.util.Arrays;

public class BetterInsertionSort {

	public static void main(String[] args) {
		
		final int[] a = {5,3,1,4,2};
		
		for(int i = 1, j = 0; i < a.length; i++) {
			int temp = a[i];
			for(j = i; j > 0 && a[j-1] > temp; j--) {
				a[j] = a[j-1];				
			}
			a[j] = temp;
		}
		
		System.out.println(Arrays.toString(a));

	}

}
