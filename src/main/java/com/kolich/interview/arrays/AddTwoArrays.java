package com.kolich.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddTwoArrays {

	public static void main(String[] args) {
		
		//final int[] a = {2,0,4,8};
		//final int[] b = {1,0,2,4};
		
		final int[] a = {3,4};
		final int[] b = {5,0,0};
		
		System.out.println(add(a,b));
		
	}
	
	public static final List<Integer> add(int[] a, int[] b) {
		
		final List<Integer> result = new ArrayList<Integer>();
		
		int length = 0;		
		if(a.length > b.length) {
			length = a.length;
		} else {
			length = b.length;
		}
		
		int[] c = Arrays.copyOf(a, length);
		int[] d = Arrays.copyOf(b, length);
		
		for(int i = length-1, diff = 0, sum = 0; i >= 0; i--) {
			sum = c[i] + d[i] + diff;
			diff = 0;
			if(sum > 9 && i > 0) {
				sum -= 10;
				diff = 1;
				result.add(sum);
			} else if(sum > 9 && i == 0) {
				result.add(sum-10);
				result.add(1);
			} else {
				result.add(sum);
			}
		}
		
		Collections.reverse(result);
		
		return result;
		
	}

}
