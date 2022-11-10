package com.kolich.interview.other;
import java.util.*;

public class NumToBinary{
    public static List<String> toBin(int n){
        List<String> ans = new ArrayList<String>();
        for(int i =0;i<n;i++){
        	StringBuffer sb= new StringBuffer(); 
        	sb.append(Integer.toBinaryString(i));
        	if (sb.length()<=3) {
        		//prepend 0s
        		for(int j =0;j<=3-sb.length();j++) sb.insert(0, "0");
        	}
        	
            ans.add(sb.toString());
        }
        return ans;
    }
    public static void main(String args[]){
        List<String> ans = toBin(8);
        System.out.println(ans);

    }
}