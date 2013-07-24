package com.kolich.interview.stacks;

import java.util.Stack;

public final class PrimativeSortTwoStacks {
	
	private static final Stack<Integer> sort(final Stack<Integer> s) {
		final Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			final int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}

	public static void main(String[] args) {
		
		final Stack<Integer> unsorted = new Stack<Integer>();
		
		unsorted.push(2);
		unsorted.push(10);
		unsorted.push(7);
		unsorted.push(3);
		
		System.out.println(unsorted.toString()); // Unsorted [2, 10, 7, 3]
		
		System.out.println(sort(unsorted)); // Sorted [2, 3, 7, 10]

	}

}