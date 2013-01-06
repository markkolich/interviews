package com.kolich.interview.strings;

public class IntToString {

	public static void main(String[] args) {
		
		System.out.println(intToString(124));
		System.out.println(intToString(0));
		System.out.println(intToString(-3459));
		
		System.out.println(intToString(-0));

	}
	
	private static final int MAX_DIGITS = 10;
	
	public static final String intToString(int input) {
		int i = 0;
		boolean negative = false;
		// Allocate a buffer large enough for an max int and a negative sign.
		char[] temp = new char[MAX_DIGITS + 1];
		// Is the number negative?
		if(input<0) {
			negative = true;
			input *= -1;
		}
		// Fill buffer with the digit chars
		do {
			temp[i++] = (char)((input % 10) + '0');
			input /= 10;
		} while(input != 0);
		StringBuffer buf = new StringBuffer();
		// Negative?
		if(negative) {
			buf.append("-");
		}
		// Walk backwards through the temp array and recreate the string.
		while(i>0) {
			buf.append(temp[--i]);
		}
		return buf.toString();
	}

}
