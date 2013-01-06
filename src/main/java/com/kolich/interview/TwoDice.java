package com.kolich.interview;

import java.util.Random;

public class TwoDice {
	
	private static class Dice {
		private Random random_;
		public Dice() {
			random_ = new Random();
		}
		public int roll() {
			// Returns an integer between 1 and 6.
			return random_.nextInt(6) + 1;
		}
	}

	public static void main(String[] args) {

		// Holds counts between 2-12, indexes 0 and 1 are unused
		final int[] totals = new int[13];
		
		// Roll each 200 times.
		final Dice d1 = new Dice(), d2 = new Dice();
		for(int i = 0; i < 200; i++) {
			int total = d1.roll() + d2.roll();
			totals[total]++;			
		}
		
		// Print out a nice bell curve like diagram.
		for(int i = 2; i <= 12; i++) {
			int total = totals[i];
			System.out.print(i + ":\t");
			for(int j = total; j > 0; j--) {
				if(j % 2 == 0) {
					System.out.print("XX");
				}				
			}
			System.out.println("");
		}
		
	}

}
