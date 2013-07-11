package com.kolich.interview.arrays;

/**
 * Given an array of integers, say [1,2,3,4,5] if we iterate over
 * each element in the array N-times, find which element we end on.
 * For example, if we iterate over the array 9 times jumping back to
 * index 0 when we reach the end of the array, we would end on element 4.
 *
 * Write a function that returns the element we end on after iterating
 * over an array of integers, N-times.
 */
public class DuckDuckGooseArray {
	
	private static final int[] array__ = new int[]{
		1, 2, 3, 4, 5
	};
	
	private static final int duckDuckGoose(final int steps,
		final int[] array) {
		return array[steps % array.length];
	}
	
	public static void main(String[] args) {
		
		System.out.println(duckDuckGoose(0, array__)); // start case
		System.out.println(duckDuckGoose(1, array__)); // middle case
		System.out.println(duckDuckGoose(4, array__)); // end case
		
		System.out.println(duckDuckGoose(1001, array__)); // craziness
		
		// If presented with a circular graph instead of an array, you'd have
		// to flatten the graph into an array (maintaining order) then you can
		// easily use the algorithm defined herein.

	}

}