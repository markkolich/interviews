package com.kolich.interview.sorting;

import java.util.Arrays;

public class BubbleSort {

	private static final int[] a = {
		199, 3452, 45, 7, 11, 245, 900, 88, 6
	};
	
	public static void main(String[] args) {
	
		int i = 0, j = 0, t = 0;
		
		for(i = 0; i < a.length; i++) {
			// Inner loop starts at one
			for(j = 1; j < a.length; j++) {
				if(a[j-1] > a[j]) {
					// Temp value
					t = a[j-1];
					// Swap!
					a[j-1] = a[j];
					a[j] = t;
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
		
	}

}
