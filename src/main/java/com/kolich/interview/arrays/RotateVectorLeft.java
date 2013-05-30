package com.kolich.interview.arrays;

public class RotateVectorLeft {

	public static void main(String[] args) {
		
		final String input = "thamy";
		
		System.out.println("Reverse: " + reverse(input));
		
		// Should produce: abcdefgh -> efghabcd
		System.out.println("Before: " + input);
		System.out.println("After:  " + rotateLeft(input, 4));
		
	}
		
	public static String rotateLeft(String input, int positions) {
		final char[] chars = input.toCharArray();
		for(int i = 0; i < positions; i++) {
			// Grab the first character on the array.
			final Character temp = chars[0]; // Autoboxing
			// Shift all remaining characters over N-positions
			for(int j = 1; j < chars.length; j++) {
				chars[j-1] = chars[j];
			}
			// Tack the temp character back onto the end of
			// the array.
			chars[chars.length-1] = temp;
		}
		return new String(chars);
	}
	
	public static String reverse(String input) {
		final StringBuilder sb = new StringBuilder();
		// Could totally use sb.reverse() here but that's
		// not very kewl.
		for(int i = input.length()-1; i>=0; i--) {
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}

}
