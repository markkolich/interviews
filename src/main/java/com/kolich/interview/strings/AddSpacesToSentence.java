package com.kolich.interview.strings;

import java.util.HashSet;
import java.util.Set;

public class AddSpacesToSentence {

	public static void main(String[] args) {

		final Set<String> dictionary = new HashSet<String>();
		dictionary.add("interviews");
		dictionary.add("are");
		dictionary.add("awesome");
		StringBuilder sb = new StringBuilder("interviewsareawesome");
		
		System.out.println(printWords(sb, dictionary)); // prints out "interviews are awesome"

	}
	
	public static final String printWords(final StringBuilder sb,
		final Set<String> dict) {
		final StringBuilder currentWord = new StringBuilder();
		for (int i = sb.length() - 1; i >= 0; i--) {
			currentWord.insert(0, sb.charAt(i));
			if (dict.contains(currentWord.toString()) && i != 0) {
				sb.insert(i, " ");
				currentWord.setLength(0);
			}
		}
		return sb.toString();
	}

}