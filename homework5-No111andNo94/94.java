package binaryTreeInorderTraversal;
import java.util.ArrayList;
import java.util.List; 
import java.util.Stack;
public class Solution {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
    public List<Integer> inorderTraversal(TreeNode root) {
    	ArrayList inorderTraversalList = new ArrayList();
    	if(root == null){
    		return inorderTraversalList;
    	}
    	
    	Stack<TreeNode> nodeStack = new Stack<TreeNode>();
    	boolean flag = true;
    	for(TreeNode curNode = root; null != curNode || !nodeStack.empty(); flag = true){
    		if(null != curNode){
    			nodeStack.push(curNode);
    			curNode = curNode.left;
    			flag = false;
    		}
    		//int curNodeVal = nodeStack.pop().val;
    		//inorderTraversalList.add(curNodeVal);
    		
    		//curNode = curNode.right;
    		if(flag){
    			curNode = nodeStack.pop();
        		inorderTraversalList.add(curNode.val);
        		curNode = curNode.right;
    		}
    		
    		//nodeStack.push(curNode);
    	}
    	
    	return inorderTraversalList;
        
    }
}
