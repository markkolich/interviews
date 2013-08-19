package com.kolich.interview.sorting;

import java.util.Arrays;

public final class MergeSort {

	private static final void sort(final int[] input, final int low,
		final int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			sort(input, low, middle);
			sort(input, middle + 1, high);
			merge(input, low, middle, high);
		}
	}

	private static final void merge(final int[] input, final int low,
		final int middle, final int high) {
		final int[] helper = new int[input.length];
		for (int i = low; i <= high; i++) {
			helper[i] = input[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				input[k] = helper[i];
				i++;
			} else {
				input[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			input[k] = helper[i];
			k++;
			i++;
		}
	}

	public static void main(String[] args) {

		final int[] sample = new int[]{10, 8, 2, 7, 1, 11, 23};

		sort(sample, 0, sample.length - 1); // Mergesort, O(n log n)

		System.out.println(Arrays.toString(sample));

	}

}