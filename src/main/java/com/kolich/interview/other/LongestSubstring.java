package com.kolich.interview.other;

// Returns the longest substring of non repeated characters
import java.util.*;
public class LongestSubstring {
	 public static String lengthOfLongestSubstring(String word) {

		    int start = 0;
		    int end = 0;
		    int maxStart = 0;
		    int maxEnd = 0;
		 
		    HashMap<Character,Integer> mp=new HashMap<Character,Integer>();

		    for (int i = 0; i < word.length(); i++) {
		        char c = word.charAt(i);
		        if(mp.containsKey(c) && mp.get(c)>=start)
		        {
		        	start=mp.get(c)+1;
		        }
		        end++;
		        mp.put(c, i);
		        if(end-start>maxEnd-maxStart)
		        {
		        	maxEnd=end;
		        	maxStart=start;
		        }
		    }
		    return word.substring(maxStart,maxEnd);
		
		    		

	 }

	 public static void main(String args[])
	 {
		String s="abcdaefghdps";
		 System.out.println(s.length());
		 System.out.println(lengthOfLongestSubstring(s));
	 }

}
