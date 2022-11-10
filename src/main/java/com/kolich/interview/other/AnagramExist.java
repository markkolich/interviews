package com.kolich.interview.other;

import java.util.*;

/*You are given 2 strings
 * if string1 or any anagram of string 1 is present in string 2 return true else return false.
 * */
public class AnagramExist {

	public static boolean isAnagram(String s1, String s2) {

		boolean ans = true;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		//Fill the hashmap with count of characters 
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (hm.containsKey(c))
				hm.put(c, hm.get(c) + 1);
			else
				hm.put(c, 1);
		}
		//Remove one by one of the part of s2 that has come. If the hashmap has only zeros then its an anagram
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (hm.containsKey(c))
				hm.put(c, hm.get(c) - 1);
			else
				return false;
		}
		for (Character c : hm.keySet()) {
			if (hm.get(c) != 0)
				return false;
		}
		return ans;
	}

	public static boolean anagram(String s1, String s2) {
		
		/*if(s1.length()>s2.length())
			return false;*/

		int n = s1.length();
		//Send to the checking function Parts of s2 which are equal to s1

		for (int i = 0; i <= s2.length() - n; i++) {

			if (isAnagram(s1, s2.substring(i, i + n)))
				return true;

		}
		return false;
	}

	public static void main(String args[]) {
		String s1 = "baa";
		String s2 = "rabbitwhoeatscaBage";//Make sure you ask if there are spaces and can we omit the spaces for this question
		System.out.println(anagram(s1.toLowerCase(), s2.toLowerCase()));
	}
}
