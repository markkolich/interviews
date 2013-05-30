package com.kolich.interview.arrays;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberNotInBlacklist {
	
	private static final int GENERATE_COUNT = 10; // Generate this many random numbers.

	public static void main(String[] args) {
		
		int range = 10000; // The range of numbers to pick from
		
		Integer[] blacklist = {2,3,5,9,199,200,344,1000,999}; // Numbers that cannot be in the list
				
		final Set<Integer> blacklisted = new HashSet<Integer>(asList(blacklist));
		final Set<Integer> pool = new HashSet<Integer>();
		
		// Only add numbers to the pool if they're not in the blacklist
		for(int i = 1; i <= range; i++) {
			if(!blacklisted.contains(i)) {
				pool.add(i); // Autoboxing, yay
			}
		}
		
		// Now pick N-numbers from the pool.
		final Dice die = new Dice();
		for(int i = 0; i < GENERATE_COUNT; i++) {
			// Only pick a number from 1 to pool size.  The pool will
			// shrink as numbers are picked and removed.
			final Integer random = die.roll(pool.size()-1);
			// Print the number we picked.
			System.out.println(random);
			// Remove the selected number from the pool.
			pool.remove(random);
		}
		
	}
	
	private static final class Dice {
		private final Random random_;
		public Dice() {
			random_ = new Random();
		}
		public int roll(int sides) {
			return random_.nextInt(sides) + 1;
		}
	}

}
