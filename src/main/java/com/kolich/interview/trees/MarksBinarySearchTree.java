package com.kolich.interview.trees;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public final class MarksBinarySearchTree<T extends Comparable<T>> {

	public final class Node {
		public final T data_;
		public Node parent_, left_, right_;
		public Node(Node parent, T t) {
			parent_ = parent;
			data_ = t;
			left_ = right_ = null;
		}
		public Node(T t) {
			this(null, t);
		}
		@Override
		public String toString() {
			return data_.toString();
		}
	}
	
	private Node root_;
	
	public MarksBinarySearchTree() {
		root_ = null;
	}
	
	private final void add(final Node n, final T t) {
		final int compared = t.compareTo(n.data_);
		if(compared < 0) {
			// Must be inserted on the left
			if(n.left_ == null) {				
				n.left_ = new Node(n, t);
			} else {
				add(n.left_, t);
			}
		} else {
			// Must be inserted on the right
			if(n.right_ == null) {
				n.right_ = new Node(n, t);
			} else {
				add(n.right_, t);
			}
		}
	}
	
	public final void add(final T t) {
		if(t == null) {
			throw new IllegalArgumentException("Cannot add 'null' to BST.");
		}
		if(root_ == null) {
			root_ = new Node(t);
		} else {
			add(root_, t);
		}
	}
	
	public final void addAll(final T[] t) {
		for(final T element : t) {
			add(element);
		}
	}
	
	// Breadth first search, uses a queue.
	// O(log n) average, O(n) worst
	public final Node breadth(final T t) {
		final Queue<Node> queue = new LinkedList<Node>();
		if(root_ == null) {
			return null;
		}
		queue.add(root_);
		while(!queue.isEmpty()) {
			final Node n = queue.remove();
			//System.out.println(n.data_);
			if(t.compareTo(n.data_) == 0) {
				return n;
			} else {
				if(n.left_ != null) queue.add(n.left_);
				if(n.right_ != null) queue.add(n.right_);
			}
		}
		return null;
	}
	
	// Depth first search, uses a stack.
	// O(log n) average, O(n) worst
	public final Node depth(final T t) {
		final Stack<Node> stack = new Stack<Node>();
		if(root_ == null) {
			return null;
		}
		stack.add(root_);
		while(!stack.isEmpty()) {
			final Node n = stack.pop();
			//System.out.println(n.data_);
			if(t.compareTo(n.data_) == 0) {
				return n;
			} else {
				if(n.right_ != null) stack.push(n.right_);
				if(n.left_ != null) stack.push(n.left_);
			}
		}
		return null;
	}
	
	private final Set<T> inOrderTraversal(final Node root, final Set<T> set) {
		if(root.left_ != null) {
			set.addAll(inOrderTraversal(root.left_, set));
		}
		set.add(root.data_);
		if(root.right_ != null) {
			set.addAll(inOrderTraversal(root.right_, set));
		}
		return set;
	}
	
	public final boolean isBST() {
		final Set<T> nodes = new LinkedHashSet<T>(); // retains insertion order
		inOrderTraversal(root_, nodes);
		// Iterate over the set to discover if we have a sorted sequence.
		T previous = null;
		final Iterator<T> it = nodes.iterator();
		while(it.hasNext()) {
			final T current = it.next();
			if(previous != null && previous.compareTo(current) >= 0) {
				return false;
			}
			previous = current;
		}
		return true;
	}
	
	public static void main(String[] args) {

		final MarksBinarySearchTree<Integer> bst = new MarksBinarySearchTree<Integer>();
		
		bst.addAll(new Integer[]{8, 3, 10, 6, 1, 7});
		
		/*
		 *                 (8)
		 *                /   \ 
		 *              (3)   (10)
		 *              /  \
		 *            (1)  (6)
		 *                   \
		 *                   (7)
		 */
		
		System.out.println(bst.isBST());
		
		bst.depth(11); // Visits in order: 8, 3, 1, 6, 7, 10
		
		bst.breadth(11); // Visits in order: 8, 3, 10, 1, 6, 7
		
	}

}
