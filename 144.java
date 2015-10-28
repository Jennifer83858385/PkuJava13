package hello;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class TreeNode {
	 int val;
	     TreeNode left;
	      TreeNode right;
	     TreeNode(int x) { val = x; }
	     
	   	     
	     public List<Integer> preorderTraversal(TreeNode root) {
	    	 List<Integer> list=new ArrayList<Integer>();
	    	 //Stack<TreeNode> s=null;
	    	 
	    	 if(root==null){
	    		 return list;
	    	 }
	    	 Stack<TreeNode> s = new Stack<TreeNode>();
	    	 s.push(root);
			
	    	 
	    	 while(!s.empty()){
	    		 TreeNode temp=s.pop();
	    		 list.add(temp.val);	
	    		if (temp.right!=null) {
	    			s.push(temp.right);
				} 
	    		if (temp.left!=null) {
	    			s.push(temp.left);
				}
	    	
	    		  
	    	 }
	    	 
	         return list;
	     }
	     
	   	 }

