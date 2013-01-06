package com.kolich.interview.lists;

public class MyLinkedList<T> {
	
	private static class Node<T> {
		public Node<T> next_;
		public T data_;
	};
	
	private Node<T> head_;

	public MyLinkedList() {
		head_ = null;
	}
	
	public void insert(T t) {
		final Node<T> n = new Node<T>();
		n.data_ = t;
		n.next_ = head_;
		head_ = n;
	}
	
	public T remove(T t) {
		Node<T> prev = null;
		Node<T> at = head_;
		while(at != null) {
			if(at.data_.equals(t)) {
				if(prev == null) {
					head_ = at.next_;
				} else {
					prev.next_ = at.next_;
				}
				return at.data_;
			}
			prev = at;
			at = at.next_;
		}
		return null;
	}
	
	public int size() {
		int count = 0;
		Node<T> node = head_;
		while(node != null) {
			count++;
			node = node.next_;
		}
		return count;
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
	
	public static void main(String[] args) {
		
		final MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.insert("dog");
		list.insert("cat");
		list.insert("fish");
		
		list.remove("cat");
		list.insert("bird");
		
		list.remove("dog");
		
		System.out.println(list.size());
	}
	
}
