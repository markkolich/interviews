package com.kolich.interview.strings;

public class ConvertSentenceIntoPigLatin {
	
	private static final String convertWordIntoPiglatin(final String word) {
		final StringBuilder sb = new StringBuilder(word);
		if(word.length() > 1) {
			return sb.append(sb.charAt(0)).deleteCharAt(0).append("ay").toString();
		} else {
			return word;
		}
	}
	
	private static final String convertSentenceIntoPiglatin(final String sentence) {
		final String[] words = sentence.split(" ");
		final StringBuilder result = new StringBuilder();
		for(int i = 0; i < words.length; i++) {
			result.append(convertWordIntoPiglatin(words[i])).append(" ");
		}
		return result.toString().trim();
	}

	public static void main(String[] args) {
		
		// elloHay ymay amenay siay arkMay
		
		System.out.println(convertSentenceIntoPiglatin("Hello my name is Mark"));
		
	}

}
