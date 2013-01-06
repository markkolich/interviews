package com.kolich.interview.strings;

public class ParseInt {

	public static void main(String[] args) {
		
		System.out.println(parseInt("137"));
		System.out.println(parseInt("-34345"));

	}
	
	public static int parseInt(final String input) {
		// DON'T FORGET CHECKS FOR INT.MAX_VALUE AND NULL OF INPUT
		int i = 0, num = 0, length = input.length();
		boolean negative = false;
		// If the input is negative, start at index 1.
		if(input.charAt(0)=='-') {
			negative = true;
			i = 1;
		}
		while(i<length) {
			num *= 10;
			// The value of a digit character is equal to the value of
			// the digit plus the value of '0'.  This means you subtract
			// the value of '0' from a digit character to find it's numeric
			// value.
			num += (input.charAt(i++) - '0');
		}
		if(negative) {
			num *= -1;
		}
		return num;
	}

}
