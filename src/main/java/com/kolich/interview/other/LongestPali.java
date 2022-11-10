package com.kolich.interview.other;


public class LongestPali {
	public static String func(String s,int left,int right)
	{
		while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right))
		{
			left--;
			right++;
		}
		return s.substring(left+1,right);
	}
	public static void main(String args[])
	{
		String s="Thisisaracecarpali";
		s=s.toLowerCase();
		String longestPali="";
		for(int i=0;i<s.length();i++){
			String t;
			t=func(s,i,i+1);
			if(t.length()>longestPali.length())
				longestPali=t;
			t=func(s,i,i);

			if(t.length()>longestPali.length())
				longestPali=t;
			
		}
		
		System.out.println(longestPali);
	}
}
