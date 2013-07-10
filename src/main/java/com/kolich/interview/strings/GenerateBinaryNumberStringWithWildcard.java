package com.kolich.interview.strings;

import java.util.ArrayList;
import java.util.List;

// Given a string pattern of 0s, 1s, and ?s (wildcards),
// generate all 0-1 strings that match this pattern.
// e.g. 1?00?101 -> [10000101, 10001101, 11000101, 11001101]
public class GenerateBinaryNumberStringWithWildcard {
	
	// Classic recursion problem.

	public static final List<String> permute(final String input) {
		final List<String> result = new ArrayList<String>();
		final int wildcardIdx = input.indexOf("?");
		if(wildcardIdx < 0) {
			result.add(input);
		} else {
			final StringBuilder sb = new StringBuilder(input);			
			// Permute around the binary digit 0
			sb.setCharAt(wildcardIdx, '0');
			result.addAll(permute(sb.toString()));
			// Permute around the binary digit 1
			sb.setCharAt(wildcardIdx, '1');
			result.addAll(permute(sb.toString()));
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		final String input = "1?00?101";
		
		for(final String s : permute(input)) {
			System.out.println(s);
		}

	}

}
