package com.kolich.interview.strings;

import java.util.HashSet;
import java.util.Set;

public class StringCheckIfHasNoDuplicates {

	private static final boolean hasUniqueCharacters(final String input) {
		final Set<Character> chars = new HashSet<Character>();
		for(int i = 0; i < input.length(); i++) {
			final Character c = input.charAt(i);
			if(!chars.add(c)) {
				return false;
			}			
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println(hasUniqueCharacters("abdc")); // true
		System.out.println(hasUniqueCharacters("aabdc")); // false

	}

}