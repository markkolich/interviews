package com.kolich.interview.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddOneToNumberArray {

	public static void main(String[] args) {
				
		System.out.println(increment(new int[]{9, 9, 9}));
		
		System.out.println(increment(new int[]{1}));
		
		System.out.println(increment(new int[]{2, 0}));
		
		System.out.println(increment(new int[]{4, 8, 9, 9}));
		
		System.out.println(increment(new int[]{1, 7, 0, 9, 9}));
		
	}
	
	public static final List<Integer> increment(int[] a) {
		
		final List<Integer> result = new ArrayList<Integer>();
		
		// Add one to the end of the array.
		a[a.length-1] += 1;
		
		// Magic, iterate over the array and adjust carry.
		for(int i = a.length-1, sum = 0, carry = 0; i >= 0; i--) {
			sum = a[i] + carry;
			carry = 0;
			if(sum > 9 && i > 0) {
				sum -= 10;
				carry = 1;
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
