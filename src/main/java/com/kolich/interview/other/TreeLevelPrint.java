package com.kolich.interview.other;

// Program to perform BFS on a tree. Can be used for level order printing and doing any level based tree operations. 

import java.util.*;


public class TreeLevelPrint {
	/*
	 * 		1
	 * 	  2	  3
	 *   4 5 6 7
	 * This is the current tree. 
	 * */
	
	
	public static void main(String args[])
	{
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		TreeNode temp=root.left;
		temp.left=new TreeNode(4);
		temp.right=new TreeNode(5);
		temp=root.right;
		temp.left=new TreeNode(6);
		temp.right=new TreeNode(7);
		
		levelPrint(root);
	}
	
	public static void levelPrint(TreeNode root)
	{
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.add(root);
		int cur=1;
		int next=0;
		while(!q.isEmpty())
		{
			TreeNode t=q.poll();
			cur--;//Simple logic just reduce cur if there is anything removed from the queue and increment next if anything is added to the queue to keep a track of levels
			System.out.print(t.v+"  ");
			if(t.left!=null)
			{
				q.add(t.left);
				next++;
			}
			if(t.right!=null)
			{
				q.add(t.right);
				next++;
			}
			if(cur==0)
			{
				System.out.println();
				cur=next;
				next=0;
			}
			
			
			
		}
	}
}
