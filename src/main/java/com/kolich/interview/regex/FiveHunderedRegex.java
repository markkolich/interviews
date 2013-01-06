package com.kolich.interview.regex;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FiveHunderedRegex {

	/**
	 * Write a regular expression pattern to match "525", "528",
	 * and "530" to "599" exclusively.
	 */
	
	private static final List<String> test__ = Arrays.asList(new String[]{
		"525", "526", "528", "529", "530", "566", "599", "600"
	});
	
	public static void main(String[] args) {		
		
		final Pattern p = Pattern.compile("^5(25|28|([3-9]{1}[0-9]{1}))$");
		
		for(final String test : test__) {
			System.out.println(test + " = " + p.matcher(test).matches());
		}
		
	}

}
