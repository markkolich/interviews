package com.kolich.interview.other;

public class StringMatch {
	

	public static boolean match(String p, String s) {
		return match(s,0,p,0);
	}
	public static boolean match(String str,int si, String pat, int pi){
		if(pi>pat.length()-1) return si>str.length()-1;
		
		if(pi+1<pat.length() && pat.charAt(pi+1)=='*'){
			while(si<str.length() && (pat.charAt(pi)=='.' || pat.charAt(pi)==str.charAt(si))){
				if(match(str,si,pat,pi+2)) return true;
				si++;
			}
			return match(str,si,pat,pi+2);
		}
		else
		{
			boolean rest=si<str.length() && (pat.charAt(pi)=='.' || pat.charAt(pi)==str.charAt(si));
			boolean recurse=match(str,si+1,pat,pi+1);
			return rest && recurse;
		}
	}
	

	public static void main(String args[])
	{
		String p="AAA";
		String t="aaa";
		p=p.toLowerCase();
		t=t.toLowerCase();
		System.out.println(match(p,t));

	}
}
