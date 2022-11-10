package com.kolich.interview.other;
/*
 * Given a number in the form of a string example 1.0 returns true if the number is valid or false;
 * */
public class ValidNumber {
	public static boolean isValidNumber(String s){
		int i=0;
		s=s.trim();
		int n=s.length();
		if(s.charAt(i)=='+'|| s.charAt(i)=='-')i++;
		boolean isNumber=false;
		boolean isExp=true;
		while(i<n && Character.isDigit(s.charAt(i))){
			isNumber=true;
			i++;
		}
		if(i<n && s.charAt(i)=='.'){
			i++;
			while(i<n && Character.isDigit(s.charAt(i))){
				isNumber=true;
				i++;
			}
		}
		
		if(isNumber && i<n && s.charAt(i)=='e'){
			isExp=false;
			i++;
			if(s.charAt(i)=='+' || s.charAt(i)=='-') i++;
			while(i<n && Character.isDigit(s.charAt(i)))
			{
				isExp=true;
				i++;
			}
		}
			
		return isNumber && isExp && (i==n);
	}
	
	public static void main(String args[]){
		String testCases[]={"2e10.9","1","-1","0.00000","aa","1a2b","1.1.1.1.4"};
		for(String s:testCases)
		System.out.println("number: "+s+" result:"+isValidNumber(s));
		
	}
}
