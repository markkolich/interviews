package com.kolich.interview.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumOfAnyTwoNumbers {

	private static final List<Integer> intList__ = Arrays.asList(new Integer[]{
		22, 34, 57, 1, 4, 3, 9, 11, 6, 7, 12, 2
	});
	
	public static void main(String[] args) {
		
		final Integer target = 11;
		
		// Place all of the integers into a hash set
		final Set<Integer> intSet = new HashSet<Integer>();
		for(final Integer i : intList__) {
			intSet.add(i);
		}
		
		for(final Integer i : intSet) {
			// If i is greater than the target, then it couldn't
			// possibly add up to the target.
			if(i <= target) {
				for(int j = target; j >= 0; j--) {
					int diff = target - j;
					if(intSet.contains(diff) && intSet.contains(j)) {
						System.out.println(diff + " + " + j + " = " + target);
					}
				}
			}
		}
		
	}

}
