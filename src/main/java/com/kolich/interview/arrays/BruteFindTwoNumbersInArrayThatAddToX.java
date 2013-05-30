package com.kolich.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteFindTwoNumbersInArrayThatAddToX {

	public static void main(String[] args) {

		int[] input = { 7, 1, 4, 8, 2, 3 };

		Arrays.sort(input);

		for(final int[] result : findSumsBruteForce(input, 11)) {
			System.out.println(Arrays.toString(result));
		}

	}

	public static final List<int[]> findSumsBruteForce(int[] inputNumbers, int sum) {
		final List<int[]> result = new ArrayList<int[]>();
		for (int i = 0; i < inputNumbers.length; i++) {
			for (int j = i + 1; j < inputNumbers.length; j++) {
				if (inputNumbers[i] + inputNumbers[j] == sum) {
					int temp[] = new int[2];
					temp[0] = inputNumbers[i];
					temp[1] = inputNumbers[j];
					result.add(temp);
				}
			}
		}
		return result;
	}

}
