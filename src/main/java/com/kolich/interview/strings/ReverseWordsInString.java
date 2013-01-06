package com.kolich.interview.strings;

public class ReverseWordsInString {

	public static void main(String[] args) {
		
		System.out.println(reverseWordsInString("clifford the big red dog"));
		System.out.println(reverseWordsInString("Battle of the Vowels: Hawaii vs. Grozny"));

	}
	
	public static final String reverseWordsInString(final String input) {
		final String[] tokens = input.split("\\b");
		final StringBuffer sb = new StringBuffer();
		for(int i = tokens.length-1; i>0; i--) {
			sb.append(tokens[i]);
		}
		return sb.toString();
	}

}
