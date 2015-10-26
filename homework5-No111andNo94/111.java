package minimumDepth;
public class Solution {
	public class TreeNode {
	      int val;
	     TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	//递归 找左右子树最小深度
    public int minDepth(TreeNode root) {
    	if(root == null){
        	return 0;
        }
        if(root.left == null && root.right == null){
        	return 1;
        }
        int leftDepth =  -1;
        int rightDepth = -1;
        if(root.left != null){
        	leftDepth = minDepth(root.left);
        }
        if(root.right != null){
        	rightDepth = minDepth(root.right);
        }
        
        if(leftDepth == -1){
        	return rightDepth+1;
        }
        if(rightDepth == -1){
        	return leftDepth+1;
        }
        
        if(leftDepth <= rightDepth){
        	return leftDepth+1;
        }
        else{
        	return rightDepth+1;
        }
        
    }
}
