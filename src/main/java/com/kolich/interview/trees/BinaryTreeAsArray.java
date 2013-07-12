package com.kolich.interview.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary search tree backed purely by an "array" (no pointers).
 * 
 * Actually, for simplicity this class uses a List instead of a native
 * array.  This has the obvious benefit that we can then avoid things like
 * System.arrayCopy() which is very expensive-- the underlying List
 * just grows naturally as more elements are added to the BST.
 */
public final class BinaryTreeAsArray<T extends Comparable<T>> {

	public final class Node {
		public final T data_;
		public Node(T data) {
			data_ = data;
		}
		@Override
		public String toString() {
			return data_.toString();
		}
	}
	
	private final List<T> tree_;
	
	public BinaryTreeAsArray() {
		tree_ = new ArrayList<T>();
	}
	
	private final T safeGetAndExpand(final int index) {
		final int size = tree_.size();
		if(index < size) {
			return tree_.get(index);
		} else {
			// Grow the "tree" array (pad with nulls) and return null.
			for(int i = size; i <= index; i++) {
				tree_.add(null);
			}
			return null;
		}
	}
	
	private final void add(final int index, final T data) {
		final int compared = data.compareTo(safeGetAndExpand(index));
		if(compared < 0) {
			// Left
			final int left = 2*index + 1;
			if(safeGetAndExpand(left) == null) {
				tree_.set(left, data);
			} else {
				add(left, data);
			}
		} else {
			// Right
			final int right = 2*index + 2;
			if(safeGetAndExpand(right) == null) {
				tree_.set(right, data);
			} else {
				add(right, data);
			}
		}
	}
		
	public final void add(final T data) {
		if(tree_.size() == 0) {
			tree_.add(data);
		} else {
			add(0, data);
		}
	}
	
	public final void addAll(final T[] t) {
		for(final T element : t) {
			add(element);
		}
	}
	
	// Worst case O(log n) ??
	public final T breath(final T t) {
		for(final T e : tree_) {
			//System.out.println(e);
			if(e != null && t.compareTo(e) == 0) {				
				return e; 
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		final BinaryTreeAsArray<Integer> bsta = new BinaryTreeAsArray<Integer>();
		
		bsta.addAll(new Integer[]{8, 3, 10, 6, 1, 7});
		
		System.out.println(bsta.breath(7)); // 7
		System.out.println(bsta.breath(11)); // null

	}

}
