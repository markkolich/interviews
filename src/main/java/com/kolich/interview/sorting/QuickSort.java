package com.kolich.interview.sorting;

import java.util.Arrays;

// Divide and conquer, find a middle point then quick sort those segments
// Best and average case O(n log n)
public class QuickSort {

	private static final int[] a = {
		199, 3452, 45, 7, 11, 245, 900, 88, 6
	};
	
	public static void main(String[] args) {
		
		quicksort(a, 0, a.length-1);
		
		System.out.println(Arrays.toString(a));
		
	}
	
	private static void quicksort(int[] numbers, int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high-low)/2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				int t = numbers[j];
				numbers[j] = numbers[i];
				numbers[i] = t;
				i++;
				j--;
			}
		}
		// Recursion, yay!
		if (low < j)
			quicksort(numbers, low, j);
		if (i < high)
			quicksort(numbers, i, high);
	}
	
	

}
