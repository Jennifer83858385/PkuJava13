package hello;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class TreeNode {
	 int val;
	     TreeNode left;
	      TreeNode right;
	     TreeNode(int x) { val = x; }
	     

	     
	     public List<Integer> postorderTraversal(TreeNode root) {
	         ArrayList<Integer> list=new ArrayList<Integer>();
	         if (root==null) {
				return list;
			}
	         Stack<TreeNode> stack=new Stack<TreeNode>();
	         stack.push(root);
	         TreeNode pre=null;
	         while(!stack.empty()){
	        	 TreeNode cur=stack.pop();
	        	 stack.push(cur);
	        	
	             if((cur.left==null&&cur.right==null)||
	                (pre!=null&&(pre==cur.left||pre==cur.right)))
	             {
	            	 list.add(cur.val);;  //如果当前结点没有孩子结点或者孩子节点都已被访问过 
	                   stack.pop();
	                 pre=cur; 
	             }
	             else
	             {
	                 if(cur.right!=null)
	                     stack.push(cur.right);
	                 if(cur.left!=null)    
	                     stack.push(cur.left);
	             }
	             }
	         
	         return list;
	     }
	     
	       
	 }

