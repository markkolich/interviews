package com.kolich.interview.math;

import static java.lang.Math.min;

public final class MedianOfThreeNumbers {

	private static final int median(final int a, final int b, final int c) {
		return (min(a,b) ^ min(b,c) ^ min(a,c));
	}
	
	public static void main(String[] args) {
		
		System.out.println(median(1, 2, 3)); // 2
		
		System.out.println(median(30, 10, 40)); // 30
		
	}

}