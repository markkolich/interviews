package com.kolich.interview.strings;

public class NonContiguousSubstringMatch {
	
	public static final boolean nonContiguousMatches(final String needle,
		final String haystack) {
		boolean found = true;
		for(int i = 0, leftOff = 0; i < needle.length(); i++) {
			final char at = needle.charAt(i);
			final int foundAt = haystack.substring(leftOff).indexOf(at);
			if(foundAt >= 0) {
				leftOff = foundAt;				
			} else {
				found = false;
				break;
			}
		}
		return found;
	}

	public static void main(String[] args) {
		
		System.out.println(nonContiguousMatches("hwr","hello world"));
		System.out.println(nonContiguousMatches("abc","baacbd"));
		
	}

}
