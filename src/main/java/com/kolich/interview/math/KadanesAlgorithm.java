package com.kolich.interview.math;

// In computer science, the maximum subarray problem is the task of
// finding the contiguous subarray within a one-dimensional array of numbers
// (containing at least one positive number) which has the largest sum.
public class KadanesAlgorithm {

	private static final int kadane(int[] array) {
	    int max = array[0], currMax = array[0];
	    for (int i = 1; i < array.length-1; i++) {
	        currMax = Math.max(array[i], currMax + array[i]);
	        max = Math.max(max, currMax);
	    }
	    return max;
	}
	
	
	public static void main(String[] args) {

		System.out.println(kadane(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
		
	}

}
