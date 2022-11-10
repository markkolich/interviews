package com.kolich.interview.other;

//Recursive Method to Mirror a Binary Tree and print it level by level
import java.util.*;

public class MirrorTree {

	public static void print(TreeNode root)
	{
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.add(root);
		int cur=1;
		int next=0;
		while(!q.isEmpty())
		{
			TreeNode t=q.poll();
			cur--;
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
	
	public static void swap(TreeNode root)
	{
		if(root!=null)
		{
			TreeNode t=root.left;
			root.left=root.right;
			root.right=t;
			
			swap(root.left);
			swap(root.right);
		}
	}
	public static void main(String args[])
	{
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		TreeNode temp=root.right;
		temp.left=new TreeNode(4);
		temp.right=new TreeNode(5);
		
		print(root);
		System.out.println();
		swap(root);
		print(root);
		System.out.println();
		
		
		
		
	}
	
}
