package com.kolich.interview.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 *        1
        /  \
       2    3
     /  \     \
    4    5     8 
              /  \
             6    7
 */
public class AllPathsRootToLeaf{


    public static void main(String args[]){
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        binaryTreePaths(root);
    }

    public static void binaryTreePaths(TreeNode root) {
        if(root == null) return ;

        List<String> list = new ArrayList<String>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode curr = root;
	      
        do {
            while(curr != null) {
                stack.push(curr);
              	curr = curr.left;
             }
          
          	while(curr == null && !stack.empty()) {
                curr = stack.peek();
                if(curr.left == null && curr.right == null) {
                    Iterator<TreeNode> iter = stack.iterator();
                    StringBuffer sb = new StringBuffer();
                        
                        String prefix = "";
                        while (iter.hasNext()){
                            sb.append(prefix);
                            prefix = "->";
                            sb.append(iter.next().val);
                        }
                    list.add(sb.toString());
                }
                
                if(curr.right == null || curr.right == prev) {
                    stack.pop();
                  	prev = curr;
                    curr = null;
                } else {
                    curr = curr.right;	
                }
            }
        } while(!stack.empty());	

       System.out.println(list);
    }

    public static class TreeNode {
        public int val;
        public TreeNode left,right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
        public String toString(){
            return this.val +" ";
        }
    }

}
