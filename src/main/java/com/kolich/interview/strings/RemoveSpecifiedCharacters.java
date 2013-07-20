package com.kolich.interview.strings;

import java.util.HashSet;
import java.util.Set;

public class RemoveSpecifiedCharacters {

	public static void main(String[] args) {
		
		System.out.println(removeSpecifiedChars("dog", "clifford the big red dog"));
		System.out.println(removeSpecifiedChars("aeiou", "Battle of the Vowels: Hawaii vs. Grozny"));
		
		System.out.println(removeSpecifiedCharsSet("dog", "clifford the big red dog"));
		System.out.println(removeSpecifiedCharsSet("aeiou", "Battle of the Vowels: Hawaii vs. Grozny"));

	}
	

	// Linear lookup time O(n)
	public static final String removeSpecifiedCharsSet(final String remove,
		final String input) {
		// Loop over each of the characters in the to-remove string
		// and add them to the set giving us O(n) lookup time.
		final Set<Character> toRemove = new HashSet<Character>();
		for(int i = 0; i < remove.length(); i++) {
			toRemove.add(remove.charAt(i));
		}
		// Iterate over each character in the input string, and if the
		// hashset contains that character, then it needs to be removed.
		// The StringBuffer here will contain the "good" characters that are
		// not to be removed (they weren't found in the Hashset).
		final StringBuffer sb = new StringBuffer();
		for(int j = 0; j < input.length(); j++) {
			if(!toRemove.contains(input.charAt(j))) {
				sb.append(input.charAt(j));
			}
		}
		return sb.toString();		
	}
	
	// Linear lookup time O(n)
	public static final String removeSpecifiedChars(final String remove,
		final String input) {
		boolean[] flagged = new boolean[input.length()];
		for(int i = 0; i < input.length(); i++) {
			final String character = input.substring(i /*inclusive*/, i+1 /*exclusive*/);
			if(remove.contains(character)) {
				flagged[i] = true;
			}
		}
		// For each of the flagged characters, don't bother to
		// include them in the "new" string.
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<flagged.length; i++) {
			if(!flagged[i]) {
				sb.append(input.charAt(i));
			}
		}
		return sb.toString();
	}

}
