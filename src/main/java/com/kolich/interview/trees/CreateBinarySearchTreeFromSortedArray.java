package com.kolich.interview.trees;

/**
 * Create a binary search tree from a sorted array.
 */
public final class CreateBinarySearchTreeFromSortedArray {

	public static class Node {
		public final int data_;
		public Node left_, right_;
		public Node(int data) {
			data_ = data;
			left_ = right_ = null;
		}
	}
	
	public static final Node createBinaryTreeFromSortedArray(final int[] array,
		final int start, final int end) {
		if(end < start) {
			return null;
		}
		final int mid = (start + end) / 2;
		final Node n = new Node(array[mid]);
		n.left_ = createBinaryTreeFromSortedArray(array, start, mid - 1);
		n.right_ = createBinaryTreeFromSortedArray(array, mid + 1, end);
		return n;
	}
	
	public static void main(String[] args) {
		
		final int[] sample = new int[]{2, 4, 5, 8, 9, 11, 15};
				
		createBinaryTreeFromSortedArray(sample, 0, sample.length - 1);		
		
	}

}