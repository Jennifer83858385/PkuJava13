/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {  
        height(root);  
        return run(root);  
    }  
      
    public boolean run(TreeNode root) {  
        if (root == null) return true;  
          
        int l = 0, r = 0;  
        if (root.left != null) l = root.left.val;  
        if (root.right != null) r = root.right.val;  
        if (Math.abs(l - r) <= 1 && isBalanced(root.left) && isBalanced(root.right)) return true;  
          
        return false;  
    }  
      
    public int height(TreeNode root) {  
        if (root == null) return 0;  
        root.val = Math.max( height(root.left), height(root.right) ) + 1;   
        return root.val;  
    } 
}