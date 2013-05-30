package com.kolich.interview.arrays;

import java.util.Arrays;
import java.util.Random;

public class RandomNumbersNoDuplicates {

	public static void main(String[] args) {
		
		// Generate k unique random integers between 0 and n-1 without
		// duplicates in random order.
		
		int k = 5;
		int n = 1000;
		
		int result[] = new int[n];
		
		for(int i = 0; i<n-1; i++) {
			result[i] = i;
		}
		
		//System.out.println(Arrays.toString(result));
		
		final Dice die = new Dice();
		for(int i = 0; i<k; i++) {
			int temp = result[i];
			int roll = die.between(i, n-1);
			result[i] = roll;
			result[roll] = temp;
		}
		
		// OK, but we still have an array that's n long.
		// We need to shorten it!
		result = Arrays.copyOf(result, k);
		
		System.out.println(Arrays.toString(result));
		
	}
	
	public static final class Dice {
		private final Random random_;
		public Dice() {
			random_ = new Random();
		}
		public int roll(int sides) {
			return random_.nextInt(sides) + 1;
		}
		public int between(int min, int max) {
			return random_.nextInt(max - min + 1) + min;
		}
	}

}
