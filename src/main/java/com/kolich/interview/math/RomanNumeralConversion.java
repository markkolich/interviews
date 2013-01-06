package com.kolich.interview.math;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConversion {

	/*
	 * I	1
	 * V	5
	 * X	10
	 * L	50
	 * C	100
	 * D	500
	 * M	1,000
	 */
	
	// Numbers are formed by combining symbols together and adding
	// the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006.
	// Generally, symbols are placed in order of value, starting with
	// the largest values. When smaller values precede larger values,
	// the smaller values are subtracted from the larger values, and
	// the result is added to the total.
	// For example MCMXLIV = 1000 + (1000 - 100) + (50 - 10) + (5 - 1) = 1944.
	
	private static final Map<Character, Integer> romanNumerals__;
	static {
		romanNumerals__ = new HashMap<Character, Integer>();
		romanNumerals__.put('I', 1);
		romanNumerals__.put('V', 5);
		romanNumerals__.put('X', 10);
		romanNumerals__.put('L', 50);
		romanNumerals__.put('C', 100);
		romanNumerals__.put('D', 500);
		romanNumerals__.put('M', 1000);
	}
	
	public static int toInteger(final String rn) {
		int result = 0;
		for(int i = 0; i < rn.length(); i++) {
			// Extract the value of the current position in the string
			// and the next position, if one exists.
			int current = getValueAt(rn, i);
			int next = (i+1 <= rn.length()-1) ? getValueAt(rn, i+1) : 0;
			// If the next position is greater than the current position
			// then subtract current from next and increment the index.
			if(next > current) {
				result += (next - current);
				i++; // Move ahead since we've already processed next
			} else {
				// Normal operation, just add the value at the current
				// position and keep going.
				result += current;
			}
		}
		return result;
	}
		
	private static int getValueAt(final String rn, final int index) {
		Integer value = 0;
		if((value = romanNumerals__.get(rn.charAt(index))) == null) {
			// Better to throw an IllegalArgumentException here?
			value = 0;
		}
		return value;
	}
	
	public static void main(String[] args) {
		
		System.out.println(toInteger("MMVI")); // 2006
		System.out.println(toInteger("MMVVI")); // 2011
		
		System.out.println(toInteger("MCMXLIV")); // 1944		
		System.out.println(toInteger("MCMLIV")); // 1954

		System.out.println(toInteger("IV")); // 4
		
		System.out.println(toInteger("XX")); // 20

	}

}
