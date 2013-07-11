package com.kolich.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A Linear Time Majority Vote Algorithm
// Implementation of http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
public class MooresFastMajorityVotingAlgorithm {
	
	// The number "2" appears the majority of the time in this list.
	private static final List<Integer> numbers__ =
		new ArrayList<Integer>(Arrays.asList(new Integer[]{
			1, 1, 1, 2, 2, 3, 3, 2, 2, 2, 3, 2, 3
		}));
	
	private static final int findMajorityLinearTime(final List<Integer> list) {
		int candidate = 0, counter = 0;
		// As we sweep we maintain a pair consisting of a current candidate
		// and a counter. Initially, the current candidate is unknown and
		// the counter is 0.
		for(final Integer e : numbers__) {
			if(counter == 0) {
				// If the counter is 0, we set the current candidate to e
				// and we set the counter to 1.
				candidate = e;
				counter = 1;
			} else {
				// If the counter is not 0, we increment or decrement the
				// counter according to whether e is the current candidate.
				if(e == candidate) {
					counter++;
				} else {
					counter--;
				}
			}
		}
		// When we are done, the current candidate is the majority
		// element, if there is a majority.
		return candidate;
	}

	public static void main(String[] args) {
		
		System.out.println(findMajorityLinearTime(numbers__));

	}

}
