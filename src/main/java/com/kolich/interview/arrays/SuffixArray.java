package com.kolich.interview.arrays;

import static java.util.regex.Pattern.quote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Given an input String, find the longest duplicated substring of
// characters in it.
public class SuffixArray {

	public static void main(String[] args) {
		
		final String s = "Ask not what your country can do for you, but what you can do for your country.";
		
		//final String s = "banana";
		
		final List<String> suffixes = new ArrayList<String>();
		
		for(int i = 0; i < s.length(); i++) {
			suffixes.add(s.substring(i));
		}
		
		// Mergesort
		Collections.sort(suffixes);
		
		for(int i = 0; i < suffixes.size(); i++) {
			//System.out.println(i + ": " + suffixes.get(i));		
		}
		//System.out.println("\n");
		
		int maxlen = 0, maxi = 0;
		for(int i = 0; i < suffixes.size()-1; i++) {
			int length = comlen(suffixes.get(i), suffixes.get(i+1));
			if(length > maxlen) {
				maxlen = length;
				maxi = i;
			}
		}
		
		System.out.println(suffixes.get(maxi).substring(0, maxlen));
		
	}
	
	public static final int comlen(CharSequence s, CharSequence m) {
	    int end = s.length() > m.length() ? m.length() : s.length();
	    int i = 0;
	    while (i < end && s.charAt(i) == m.charAt(i)) {
	        i++;
	    }
	    return i;
	}
		
	public static final String commonCharacters(final String x, final String y) {
		return x.replaceAll("[^"+quote(y)+"]","");
	}

}
