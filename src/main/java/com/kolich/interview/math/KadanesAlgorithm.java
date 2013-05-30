package com.kolich.interview.math;

public class KadanesAlgorithm {

	public static void main(String[] args) {

		System.out.println(kadane(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
		
	}

	public static int kadane(int[] array) {
	    int max = array[0], currMax = array[0];	     
	    for (int i = 1; i < array.length-1; i++) {
	        currMax = Math.max(array[i], currMax + array[i]);
	        max = Math.max(max, currMax);
	    }	     
	    return max;
	}

}
