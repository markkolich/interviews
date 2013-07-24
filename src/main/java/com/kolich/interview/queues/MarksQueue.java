package com.kolich.interview.queues;

// FIFO -- element at the "tail" of the stack gets popped
public class MarksQueue<T> {

	private static class Node<T> {
		public T data_;
		public Node<T> next_;
	};
	
	private Node<T> head_;
	
	public MarksQueue() {
		head_ = null;
	}
	
	// Push elements into the head of the list.
	public synchronized void push(T t) {
		final Node<T> node = new Node<T>();
		node.data_ = t;
		if(head_ != null) {
			node.next_ = head_;
		}
		head_ = node;
	}
	
	// Pop elements from the tail.
	public synchronized T pop() {
		if(head_ == null) {
			// Empty stack, immeaditely return null.
			return null;
		}
		Node<T> previous = head_;
		for(Node<T> current = head_; current != null; current = current.next_) {
			// Only bother to update the pointer to the "previous"
			// node if we know the next node is non-null.
			if(current.next_ != null) {
				previous = current;
			}
		}
		T t = null;
		if(previous.next_ != null) {
			t = previous.next_.data_;
			previous.next_ = null;
		} else {
			t = previous.data_;
			head_ = null;
		}		
		return t;
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
		
		final MarksQueue<String> queue = new MarksQueue<String>();
		
		queue.push("dog");
		queue.push("cat");
		queue.push("fish");
		
		System.out.println(queue);
		
		System.out.println("popped: " + queue.pop());
		System.out.println("popped: " + queue.pop());
		System.out.println("popped: " + queue.pop());
		
		// Null
		System.out.println("popped: " + queue.pop());
		
	}

}
