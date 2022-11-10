package com.kolich.interview.other;

import java.util.*;

/*
 * Given an Array of integers, Make the largest number from it
 * */
public class LargestNumberString {
	
	public static void main(String args[])
	{
		int[] arr={3, 30, 34, 5, 9};
		//9 5 34 3 31
		 
		List<String> ts=new ArrayList<String>();
		for(int i=0;i<arr.length;i++)
		{
			ts.add(Integer.toString(arr[i]));
		}
		Collections.sort(ts, new StringComparator());
		System.out.println(ts);

		StringBuffer sb=new StringBuffer();
		for(String z: ts)
		{
			sb.insert(0,z);
			
		}
		String s=sb.toString();
		System.out.println(s);
	}	
	
}


class StringComparator implements Comparator<String>{
    public int compare(String s1, String s2){//3,30
        if(s1.length() == 0 && s2.length() == 0) return 0;
        if(s2.length() == 0) return 1;
        if(s1.length() == 0) return -1;
        for(int i = 0; i < s1.length() && i < s2.length(); i++){
            if(s1.charAt(i) > s2.charAt(i)){
                return 1;
            }else if(s1.charAt(i) < s2.charAt(i)){
                return -1;
            }
        }
        //This part is for very special cases. (such as 3,30)
        if(s1.length() == s2.length()) return 0;
        if(s1.length() > s2.length()){
            if(s1.charAt(0) < s1.charAt(s2.length()))
                return 1;
            else if(s1.charAt(0) > s1.charAt(s2.length()))
                return -1;
            else 
                return compare(s1.substring(s2.length()), s2);
        }else{
            if(s2.charAt(0) < s2.charAt(s1.length()))
                return -1;
            else if(s2.charAt(0) > s2.charAt(s1.length()))
                return 1;
            else
                return compare(s1, s2.substring(s1.length()));
        }
    }
}