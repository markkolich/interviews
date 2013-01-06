package com.kolich.interview.sorting;

import java.util.Arrays;

// Find mininum and swap, keep going
// Always O(n^2) performance
public class SelectionSort {

	private static final int[] a = {
		199, 3452, 45, 7, 11, 245, 900, 88, 6
	};
	
	public static void main(String[] args) {
		
		for(int i = 0; i < a.length; i++) {
			// The min index can only start where the last index left off.
			int minIndex = i;
			for(int j = i+1; j < a.length; j++) {
				if(a[j] < a[minIndex]) {
					 /* found new minimum; remember its index */
					minIndex = j;
				}
			}
			if(i != minIndex) {
				int temp = a[minIndex];
				a[minIndex] = a[i];
				a[i] = temp;
			}
		}
		
		System.out.println(Arrays.toString(a));
		
	}

}
