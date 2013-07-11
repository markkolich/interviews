package com.kolich.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursiveAlphabetSoup {
	
	private static final char[] alphabet__ = new char[] {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
		'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
		'U', 'V', 'W', 'X', 'Y', 'Z'
	};
	
	private static final List<String> recurse(final String input) {
		final List<String> result = new ArrayList<String>();
		final int wildcardIdx = input.indexOf("?");
		if(wildcardIdx < 0) {
			result.add(input);
		} else {
			final StringBuilder sb = new StringBuilder(input);
			// Iterate over all of the letters in the alphabet.
			for(int i = 0; i < 26; i++) {
				sb.setCharAt(wildcardIdx, alphabet__[i]);
				result.addAll(recurse(sb.toString()));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		final String input = "??";
		
		for(final String s : recurse(input)) {
			System.out.println(s);
		}
		
	}

}
