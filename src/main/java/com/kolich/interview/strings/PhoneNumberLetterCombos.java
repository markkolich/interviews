package com.kolich.interview.strings;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberLetterCombos {
	
	private static final String[][] keyMappings__ = {
		{"0"}, // 0
		{"1"}, // 1
		{"A", "B", "C"}, // 2
		{"D", "E", "F"}, // 3
		{"G", "H", "I"}, // 4
        {"J", "K", "L"}, // 5
        {"M", "N", "O"}, // 6
        {"P", "Q", "R", "S"}, // 7 
        {"T", "U", "V"}, // 8
        {"W", "X", "Y", "Z"} // 9		
	};

	public static void main(String[] args) {
		
		final String number = "8675309";
		
		final List<String> combos = generate(number);
        for(final String s : combos) {
            System.out.println(s);
        }
        
	}
	
	public static List<String> generate(final String number) {
		final List<String> combos = new ArrayList<String>();
		generateHelper(combos, "", number);
		return combos;
	}
	
	public static void generateHelper(final List<String> combos,
		final String prefix, final String remaining) {
		int digit = Integer.parseInt(remaining.substring(0, 1));
		if(remaining.length() == 1) {
			for(int i = 0; i < keyMappings__[digit].length; i++) {
                combos.add(prefix + keyMappings__[digit][i]);
            }
		} else {
			for(int i = 0; i < keyMappings__[digit].length; i++) {
				generateHelper(combos, prefix + keyMappings__[digit][i],
                	remaining.substring(1));
            }
		}
	}

}