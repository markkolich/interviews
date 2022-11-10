package com.kolich.interview.other;

//Prints the number of distinct palindromes inside a given string

import java.util.*;
public class AllPalindromesInString {
	
		
		public static void expand(String s, int left,int right,HashSet<String> st)
		{
			
			while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
				{
					left--;
					right++;
					String l=s.substring(left+1,right);
					st.add(l);
					
				}
			
		}
		public static void main(String args[])
		{
			
			String s="abaaa";
			HashSet<String> st=new HashSet<String>();
			for(int i=0;i<s.length();i++)
			{
				expand(s,i,i+1,st);
				expand(s,i,i,st);
			}
			
			System.out.println(st);
			System.out.println("Number of palindromes are "+ st.size());
		}
	}