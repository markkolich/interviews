package com.kolich.interview.stacks;

import java.util.Stack;

public final class TwoStacksMakesAQueue<T> {

	private final Stack<T> stack_;
	private final Stack<T> temp_;
	
	public TwoStacksMakesAQueue() {
		stack_ = new Stack<T>();
		temp_ = new Stack<T>();
	}
	
	public void push(T t) {
		// Pushing onto the "queue" is straightforward.
		stack_.push(t);
	}
	
	// O(n^2) runtime, O(n) space
	public T pop() {
		while(!stack_.isEmpty()) {
			temp_.push(stack_.pop());
		}
		final T end = temp_.pop();
		while(!temp_.isEmpty()) {
			stack_.push(temp_.pop());
		}
		return end;
	}
	
	public static void main(String[] args) {
		
		final TwoStacksMakesAQueue<String> queue = new TwoStacksMakesAQueue<String>();
		
		queue.push("dog"); // our queue wants to return this one
		queue.push("cat");
		queue.push("bird");
		queue.push("horse"); // top of the dinner plates as far as a stack goes
		
		System.out.println(queue.pop()); // dog!
		
	}

}