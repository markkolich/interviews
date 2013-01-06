package com.kolich.interview.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		
		System.out.println(firstNonRepeated("teeter"));
		System.out.println(firstNonRepeated("toot"));
		
	}
	
	// Using a Map gives us a lookup of O(n) in constant time
	public static final Character firstNonRepeated(final String s) {
		
		// Could use a Hashtable here if synchronization is an issue.
		// HashMap does not guarantee any kind of thread safety.
		final Map<Character, Integer> charCounts =
			new HashMap<Character, Integer>();
		
		for(int i = 0; i < s.length(); i++) {
			final Character c = s.charAt(i);
			Integer count = 0; // Autoboxing, yay!
			if((count = charCounts.get(c)) != null) {
				count++;
			} else {
				count = 1;
			}
			charCounts.put(c, count);
		}
		
		// At this point, the charCounts map contains a list of all
		// characters and how many times they've appeared.
		// Now what we have to do is iterate over all characters in the
		// string, and the first character to have a count of 0 (zero)
		// is our winner.
		
		Character winner = null;
		for(int i = 0; i < s.length(); i++) {
			final Character c = s.charAt(i);
			if(charCounts.get(c) == 1) {
				winner = c;
				break;
			}
		}
		
		// Returns null if there are no repeating characters.
		return winner;
		
	}

}
