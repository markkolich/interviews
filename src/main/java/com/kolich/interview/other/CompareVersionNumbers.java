package com.kolich.interview.other;
/*
 * a simple program to compare 2 given version numbers;
 * ex: 0.1 < 1.1 < 1.2 < 13.37
 * */
public class CompareVersionNumbers {
	public static int compareVersion(String version1, String version2){
		String v1[]=version1.split("\\.");
		String v2[]=version2.split("\\.");
		int min=Math.min(v1.length, v2.length);
		for(int i =0;i<min;i++){
			int a=Integer.parseInt(v1[i]);
			int b=Integer.parseInt(v2[i]);
			if(a>b)return 1;
			if(b>a) return -1;	
		}
		if(v1.length==v2.length) return 0;
		
		for(int i =min ; i<v1.length;i++){
			if(Integer.parseInt(v1[i])!=0) return 1;
		}
		for(int i =min; i<v2.length;i++){
			if(Integer.parseInt(v2[i])!=0) return -1;
		}
			
		return 0;
	}
	public static void main(String args[]){
		String version1="1.1.2";
		String version2="1.1";
		int ans=compareVersion(version1,version2);
		if(ans==1) System.out.println("Version 1 is Greater");
		else if(ans==-1)System.out.println("Version 2 is Greater");
		else System.out.println("Both versions are equal");
				
		
	}
}
