package com.kolich.interview.other;

public class TreeNode {
	int v;
	TreeNode left,right;
	TreeNode()
	{
		this.left=null;
		this.right=null;
	}
	TreeNode(int v)
	{
		this.v=v;
		this.left=null;
		this.right=null;
	}
	public String toString()
	{
		return this.v+"";
	}
}
