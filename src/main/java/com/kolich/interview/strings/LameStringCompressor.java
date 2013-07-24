package com.kolich.interview.strings;

// Converts a string like "aaabbccccddd" into "3a2b4c3d"
public final class LameStringCompressor {
	
	private static final String compress(final String input) {
		final StringBuilder sb = new StringBuilder();
		int charCount = 0;
		Character charAt = input.charAt(0);
		for(int i = 0; i < input.length(); i++) {
			final Character c = input.charAt(i);
			if(c.equals(charAt)) {
				charCount++;
			} else {
				sb.append(charCount).append(charAt);
				charCount = 1;
				charAt = c;
			}
		}
		sb.append(charCount).append(charAt);
		return sb.toString();
	}

	public static void main(String[] args) {
		
		System.out.println(compress("aaabbccccddd")); // "3a2b4c3d" 
		System.out.println(compress("a")); // "1a"

	}

}