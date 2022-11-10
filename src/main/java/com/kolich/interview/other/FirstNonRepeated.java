package com.kolich.interview.other;

//Return the first non repeating character in a given string

import java.util.*;
public class FirstNonRepeated {
	
	public static char noRepeat(String s)
	{
	
		Set<Character> repeated=new HashSet<Character>();
		Set<Character> nonrep=new LinkedHashSet<Character>();
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(!repeated.contains(c))
			{
				if(!nonrep.contains(c))
					nonrep.add(c);
				else{
					repeated.add(c);
					nonrep.remove(c);
				}
			}
		}
		//System.out.println(repeated+"\n"+nonrep);
		
		if(nonrep.size()>=1)
		{
			
			for(Character c: nonrep)//return the first character in the linked hashmap
			{
				
				return c;
			}
		}
		return '!';
	}
	public static void main(String args[])
	{
		String s="The quick brown fox jumps over the lazy dog";
		s=s.toLowerCase();
		char c=noRepeat(s);
		if(c!='!')
			System.out.println("The first non repeating character is: " +c);
		else
			System.out.println("No non repeating characters exist in the string");
	}
}
