package com.kolich.interview.stack;

// LIFO - element at the "head" of the stack gets popped
public class MarksCustomLIFOStack<T> {
	
	private static class Node<T> {
		public T data_;
		public Node<T> next_;
	}
	
	private Node<T> head_; // set to null
	
	public MarksCustomLIFOStack() {
		head_ = null;
	}
	
	public synchronized void push(T t) {
		Node<T> n = new Node<T>();
		n.data_ = t;
		if(head_ == null) {
			// If there is no head, then the new Node<T> n becomes
			// the head, and we're done.
			head_ = n;
		} else {
			// The "next" of our new node is the current head
			n.next_ = head_;
			// The head becomes our new node. Yay.
			head_ = n;
		}
	}
	
	public synchronized T pop() {
		T t = null;
		if(head_ != null) {
			t = head_.data_;
			head_ = head_.next_;
		}
		return t;
	}
	
	public synchronized int size() {
		int size = 0;
		Node<T> current = head_;
		while(current != null) {
			current = current.next_;
			size++;
		}
		return size;
	}
	
	public synchronized void reverse() {
		// <HEAD> ---> <n1> ----> <n2> -----> <n3> ---> null
		Node<T> current = head_;
		head_ = null;
		while(current != null) {
			Node<T> save = current;
	        current = current.next_;
	        save.next_ = head_;
	        head_ = save;
		}
	}
	
	@Override
	public synchronized String toString() {
		final StringBuilder sb = new StringBuilder(); // not thread safe, but OK here
		sb.append("[");
		Node<T> head = head_;
		while(head != null) {
			sb.append(head.data_.toString());
			head = head.next_;
			if(head != null) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {

		final MarksCustomLIFOStack<String> stack = new MarksCustomLIFOStack<String>();
		
		stack.push("dog");
		stack.push("cat");
		stack.push("fish");
		stack.push("bird");
		
		System.out.println(stack); // Normally would use a logger here
		
		stack.reverse();
		
		System.out.println(stack); // Normally would use a logger here
		
		System.out.println(stack.pop());
		
		System.out.println(stack); // Normally would use a logger here
		
	}

}
