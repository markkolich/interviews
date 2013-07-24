package com.kolich.interview.strings;

import static java.lang.Character.isWhitespace;

public class JustifyParagraphText {

	// How wide, in characters, a column can be.
	private static final int COLUMN_WIDTH = 40;
		
	public static void main(String[] args) {
		
		final String paragraph = "VMware developed a range of products, most " +
			"notable of which are their hypervisors. VMware became well " +
			"known for their first type 2 hypervisor known as GSX. This " +
			"product has since evolved into two hypervisor products lines, " +
			"VMware's type 1 hypervisors running directly on hardware, along " +
			"with their hosted type 2 hypervisors.";
		
		// Split the paragraph around word boundaries, get a List<String>
		// where each entry is a word.
		final String[] words = paragraph.split("\\s");
		
		//System.out.println(Arrays.toString(words));
		
		for(int i = 0; i < words.length-1; ) {
			// First step is find how many words can fit comfortably on a single
			// line without any wrapping.
			String line = new String();
			int j = i;
			for(; j < words.length && ((line.length() + words[j].length()) <= COLUMN_WIDTH); j++) {
				line += words[j] + " ";
			}
			i = j;
			// Hack to trim whitespace from the beginning and end of the string.
			final StringBuilder sb = new StringBuilder(line.trim());
			// Second step will involve padding spacing from the left->right to
			// make the text justified to fit the column width.						
			for(j = sb.length()-1; sb.length() < COLUMN_WIDTH; j--) {
				Character c = sb.charAt(j);
				if(isWhitespace(c)) {
					sb.insert(j, " ");
				}
				// If we're at the beginning of the String, reset the counter
				// so that it goes to the end so we can start padding more if
				// necessary to fill up the space.
				if(j <= 0) {
					j = sb.length()-1;
				}
			}
			System.out.println(sb.length() + ": " + sb.toString());
		}
		
	}

}
