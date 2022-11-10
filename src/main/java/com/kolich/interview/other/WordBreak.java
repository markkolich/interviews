


package com.kolich.interview.other;
import java.util.*;
//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

public class WordBreak {
	public static String chk(String s, Set<String> st)
	{
		Set<String> memo=new HashSet<String>();
		String ans=split(s,st,memo);
		
		if(ans!=null)
			return ans;// can return true here if return type is boolean
		else
			return "No segments exist";	
	}
	
	public static String split(String s, Set<String> st,Set<String> memo)
	{
		if(st.contains(s))
			return s; //base case of recrusion return;
		if(memo.contains(s))
			return null; // Don't branch further if word is found in the memo cache(Words that result in recursive null calls are only added to this cache)
		for(int i=1;i<s.length();i++)
		{
			String pre=s.substring(0,i);
				if(st.contains(pre))
				{
					String suf=s.substring(i,s.length());
					String temp=split(suf,st,memo);
						if(temp!=null)
						{
							return pre + " " + temp;
						}
				}
		}
		memo.add(s);
		return null;
		
	}

	public static void main(String args[])
	{
		/*String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String dic="a aa aaa aaaa aaaaa aaaaaa aaaaaaa aaaaaaaa aaaaaaaaa aaaaaaaaaa ";*/
		String s="ab";
		String dic="a b";
		
		String word[]=dic.trim().split(" ");
		Set<String> st=new HashSet<String>();
		for(int i=0;i<word.length;i++)
		{
			st.add(word[i]);
		}
		System.out.println(chk(s,st));
	}
}
