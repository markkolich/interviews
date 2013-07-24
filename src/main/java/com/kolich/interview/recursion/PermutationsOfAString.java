package com.kolich.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public final class PermutationsOfAString {

	private static final List<String> permute(final String input) {
		if(input == null) { // good error checking
			return null;
		}
		final List<String> permutations = new ArrayList<String>();
		if(input.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}
		final StringBuilder sb = new StringBuilder(input);
		// Get the first character.
		final char first = sb.charAt(0);
		// Remove the first character.
		sb.deleteCharAt(0);
		final List<String> words = permute(sb.toString());
		for(final String word : words) {
			for(int i = 0; i <= word.length(); i++) {
				permutations.add(new StringBuilder(word).insert(i, first).toString());
			}
		}
		return permutations;
	}
	
	public static void main(String[] args) {
		
		System.out.println(permute("abc")); // [abc, bac, bca, acb, cab, cba]

	}

}