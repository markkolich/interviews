package com.kolich.interview.sorting;

import java.util.ArrayList;
import java.util.List;

public class SortBinaryDigitsNoCounting {

	public static void main(String[] args) {
		
		final int input[] = {1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1};
		
		// Loop over each index in the array and add up the "sum".
		int sum = 0;
		for(int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		
		final List<Integer> result = new ArrayList<Integer>();
		
		// Print out the zeros.
		// If the length is 15 and the sum is 8 then we print out 7 zeros.
		// 15 - 8 = 7
		for(int i = 0; i < input.length - sum; i++) {
			result.add(0);
		}
		// Print out the ones.
		// Start at index 7 (15-8) and print ones to the end of the array.
		for(int i = input.length - sum; i < input.length; i++) {
			result.add(1);
		}
		
		//System.out.println(input.length);
		System.out.println(result);
		//System.out.println(result.size());

	}

}
