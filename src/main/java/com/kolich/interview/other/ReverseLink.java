package com.kolich.interview.other;

/*
 * A program to reverse a Singly Linked List recursively and Iteratively
 * */
public class ReverseLink {
	public static Link insert(int a[]) {
		if (a.length == 0)
			return null;
		Link root = new Link(a[0]);
		Link t = root;
		for (int i = 1; i < a.length; i++) {
			t.next = new Link(a[i]);
			t = t.next;
		}
		return root;
	}

	public static void print(Link root) {
		if (root == null)
			System.out.println("Link List is Empty");
		else {
			Link t = root;
			while (t != null) {
				System.out.print(t.v + " ");
				t = t.next;
			}
			System.out.println();
		}
	}

	public static Link rev(Link root) {//Iterative
		Link prev = null;
		while (root != null) {
			Link t = root.next;
			root.next = prev;
			prev = root;
			root = t;
		}
		return prev;
	}

	public static Link revRec(Link root) {//recursive
		if (root == null || root.next == null)
			return root;
		Link rest = revRec(root.next);
		Link t = rest;
		while (t.next != null)
			t = t.next;
		t.next = root;
		root.next = null;
		return rest;
	}

	public static void main(String args[]) {
		int a[] = { 1, 2, 3, 4, 5 };
		Link root;
		root = insert(a);
		print(root);
		root = rev(root);//Iterative reverse
		print(root);
		root = revRec(root);//Recursive reverse
		print(root);
	}

}
