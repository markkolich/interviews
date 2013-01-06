package com.kolich.interview.sorting;

import java.util.Arrays;

// Pick a value then find the right place for it in the list.
// Average and worst performance O(n^2)
public class InsertionSort {

	private static final int[] a = {
		199, 3452, 45, 7, 11, 245, 900, 88, 6
	};
	
	public static void main(String[] args) {
		
		for(int i = 1; i < a.length; i++) {
			int j = i, t = a[i];
			while((j > 0) && (a[j-1] > t)) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = t;
			System.out.println(Arrays.toString(a));
		}
		
		//System.out.println(Arrays.toString(a));
		
	}

}
