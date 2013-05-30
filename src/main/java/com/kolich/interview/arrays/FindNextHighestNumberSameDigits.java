package com.kolich.interview.arrays;

import java.util.Arrays;

// Given a number, find the next higher number which has the
// exact same set of digits as the original number.
public class FindNextHighestNumberSameDigits {

	public static void main(String[] args) {
		
		System.out.println(nextDigit(38276));
		System.out.println(nextDigit(38762));
		
		System.out.println(nextDigit(113));

	}

	public static int nextDigit(int number) {
		String num = String.valueOf(number);
		int stop = 0;
		char[] chars = null;
		outer: for (int i = num.length() - 1; i > 0; i--) {
			chars = num.toCharArray();
			for (int j = i; j > 0; j--) {
				char temp = chars[j];
				chars[j] = chars[j - 1];
				chars[j - 1] = temp;
				if (Integer.valueOf(new String(chars)) > number) {
					stop = j;
					break outer;
				}
			}
		}
		Arrays.sort(chars, stop, chars.length);
		return Integer.valueOf(new String(chars));
	}

}
