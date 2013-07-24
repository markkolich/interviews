package com.kolich.interview.recursion;

import java.util.LinkedHashSet;
import java.util.Set;

public final class PairsOfParentheses {

	private static final Set<String> generateParens(final int remaining) {
		final Set<String> pairs = new LinkedHashSet<String>();
		if(remaining == 0) { // base case
			pairs.add("");
		} else {
			final Set<String> prev = generateParens(remaining - 1);			
			for(final String s : prev) {
				for(int i = 0; i < s.length(); i++) {
					if(s.charAt(i) == '(') {
						pairs.add(new StringBuilder(s).insert(i+1,"()").toString());
					}
				}
				pairs.add("()" + s);
			}
		}
		return pairs;
	}
	
	public static void main(String[] args) {
		
		System.out.println(generateParens(3)); // [(()()), ((())), ()(()), (())(), ()()()]

	}

}