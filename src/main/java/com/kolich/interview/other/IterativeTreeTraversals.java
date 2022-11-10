package com.kolich.interview.other;



import java.util.*;

public class IterativeTreeTraversals {
	public static TreeNode makeTree(String s) {
		if (s.length() == 0 || s.charAt(0) == '#')
			return null;
		else {
			String[] ip = s.split(" ");
			TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
			int len = ip.length;
			int i = 0;
			while (!q.isEmpty()) {
				TreeNode t = q.poll();
				int next = 2 * i;
				if (next + 1 < len && ip[next + 1] != "#") {
					t.left = new TreeNode(Integer.parseInt(ip[next + 1]));
					q.add(t.left);
				}
				if (next + 2 < len && ip[next + 2] != "#") {
					t.right = new TreeNode(Integer.parseInt(ip[next + 2]));
					q.add(t.right);
				}
				i++;
			}
			return root;
		}
	}

	public static void inOrder(TreeNode root) {
		if (root == null)
			System.out.println("The given tree is Empty");
		else {
			Stack<TreeNode> st = new Stack<TreeNode>();
			TreeNode t = root;
			while (true) {
				if (t != null) {
					st.push(t);
					t = t.left;
				} else {
					if (!st.isEmpty()) {
						t = st.pop();
						System.out.print(t.v + " ");
						t = t.right;
					} else
						break;
				}
			}
			System.out.println();
		}
	}

	public static void preOrder(TreeNode root) {
		if (root == null)
			System.out.println("Tree is Empty");
		else {
			Stack<TreeNode> st = new Stack<TreeNode>();
			TreeNode t = root;
			while (true) {
				if (t != null) {
					System.out.print(t.v + " ");
					st.push(t);
					t = t.left;
				} else {
					if (st.isEmpty())
						break;
					else {
						t = st.pop();
						t = t.right;
					}
				}
			}
			System.out.println();
		}

	}

	public static void postOrder(TreeNode root) {
		if (root == null)
			System.out.println("Tree is Empty");
		else {
			Stack<TreeNode> st = new Stack<TreeNode>();
			TreeNode t = root;
			st.push(root);
			while (!st.isEmpty()) {
				TreeNode next = st.peek();
				boolean subTreeExists = (next.right == t || next.left == t);
				boolean isLeaf = (next.left == null && next.right == null);
				if (subTreeExists || isLeaf) {
					st.pop();
					System.out.print(next.v + " ");
					t = next;
				} else {
					if (next.right != null)
						st.push(next.right);
					if (next.left != null)
						st.push(next.left);
				}

			}
			System.out.println();
		}
	}
	
	public static void postOrderRec(TreeNode t)
	{
		if(t==null)
			return;
		else
		{
			postOrderRec(t.left);
			postOrderRec(t.right);
			System.out.print(t.v+" ");
		}
	}
	public static void main(String args[]) {
		String s = "1 2 3 4 5 6 7";
		TreeNode root = makeTree(s);
		inOrder(root);
		preOrder(root);
		postOrder(root);
	}

}
