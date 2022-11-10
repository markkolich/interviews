package com.kolich.interview.other;

/*
 * Program to make a binary tree given the level order traversal
 * The String "#" denotes a null Node in the Tree
 * */

import java.util.*;


public class TreeFromLevelOrder {

	public static void inOrder(TreeNode root) {
		if (root == null)
			System.out.println("Tree is Empty");
		else
			order(root);
	}

	public static void order(TreeNode root) {
		if (root == null)
			return;
		else {
			order(root.left);
			System.out.print(root.v + " ");
			order(root.right);
		}
	}

	public static TreeNode formTree(String[] s) {
		if (s.length == 0 || s[0].equals("#"))
			return null;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(s[0]));
		q.add(root);
		int l = s.length - 1;
		int i = 0;
		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			if (2 * i + 1 <= l && !s[2 * i + 1].equals("#")) {
				t.left = new TreeNode(Integer.parseInt(s[2 * i + 1]));
				q.add(t.left);
			}
			if (2 * i + 2 <= l && !s[2 * i + 2].equals("#")) {
				t.right = new TreeNode(Integer.parseInt(s[2 * i + 2]));
				q.add(t.right);
			}
			i++;
		}
		return root;
	}

	public static void main(String args[]) {
		String s = "1 2 3 4 # 6 7";
		String st[] = s.split(" ");
		TreeNode root = formTree(st);
		inOrder(root);
	}
}
