package com.kolich.interview.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Write a function that removes duplicate integers from an array.
public class RemoveDuplicatesFromArray {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(removeDuplicates(new int[]{3, 9, 8, 10, 4, 3, 8, 7, 6, 9})));
		
		System.out.println(Arrays.toString(removeDuplicates(new int[]{1, 1, 1, 1, 1})));
		
		System.out.println(Arrays.toString(removeDuplicates(new int[]{})));

	}
	
	public static int[] removeDuplicates(final int[] input) {
		final Set<Integer> ints = new HashSet<Integer>(); // Set has no duplicates
		for(int i = 0; i < input.length; i++) {
			ints.add(input[i]);
		}
		final int[] result = new int[ints.size()];
		final Iterator<Integer> it = ints.iterator();
		for(int i = 0; it.hasNext(); i++) {
			result[i] = it.next();
		}
		return result;
	}

}
