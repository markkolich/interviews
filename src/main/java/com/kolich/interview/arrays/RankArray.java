package com.kolich.interview.arrays;

import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;

import java.util.Arrays;

public final class RankArray {
	
	private static final int indexOf(final int[] array, final int value) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) {
				return i+1;
			}
		}
		return -1;
	}

	private static final int[] createRankArray(final int[] input) {
		final int[] sorted = new int[input.length], ranks = new int[input.length];
		arraycopy(input, 0, sorted, 0, input.length);
		sort(sorted); // tuned quicksort, O(n log n)	
		for(int i = 0; i < input.length; i++) {
			ranks[i] = indexOf(sorted, input[i]);
		}
		return ranks;
	}
	
	public static void main(String[] args) {
		
		final int[] sample = new int[]{79, 5, 18, 5, 32, 1, 16, 1, 82, 13};
		
		// Result: [2, 7, 4, 7, 3, 9, 5, 9, 1, 6]
		System.out.println(Arrays.toString(createRankArray(sample)));

	}

}