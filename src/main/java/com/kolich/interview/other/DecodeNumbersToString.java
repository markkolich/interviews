package com.kolich.interview.other;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Given a Stream of numbers as input decode them into Strings such that 1->A, 2->B.. and so on
 * if the input is something like 12 The answer will have [AB,L] and for something like 
 * 123 [ABC,L,W]
 * */
public class DecodeNumbersToString {

	public static char decode(int n) {
		return (char) (n - 1 + 'A');
	}
	public static int helper(String s,int n)
	{
		if(n==0)
			return 1;
		
		int r = s.length()-n;
		if(s.charAt(r) == '0') return 0;
		int result = helper(s,n-1);
		if(n>=2 && Integer.parseInt(s.substring(r,r+2))<=26)
		{
			result +=helper(s,n-2);
		}
		return result;
	}
	public static int numDecodings(String input){
		return helper(input,input.length());
	}

	public static void main(String args[]) {
		String input = "123";
		System.out.println(numDecodings(input));
	}
}
