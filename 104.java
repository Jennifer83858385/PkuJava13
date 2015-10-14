package hello;

public class TreeNode {
	 int val;
	     TreeNode left;
	      TreeNode right;
	     TreeNode(int x) { val = x; }
	     
	     public int maxDepth(TreeNode root) {
	    	       int deep=0;
	    	      if(root!=null){
	    	          int lchilddeep=maxDepth(root.left);
	    	          int rchilddeep=maxDepth(root.right);
	    	          deep=lchilddeep>=rchilddeep?lchilddeep+1:rchilddeep+1;
	    	      }
	    	      return deep;
	     }
	     
	     
	     
	 }

