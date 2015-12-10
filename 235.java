/*Author:李建锋
*Time：12.10
*Question：二叉树最近的祖先
*Tips:递归求解
*/
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
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==null||q==null)return null;
        if(searchX(root,p)==1&&searchX(root,q)==1){
           TreeNode ancestor=lowestCommonAncestor(root.left,p,q);
           if(ancestor==null)ancestor=lowestCommonAncestor(root.right,p,q);
           if(ancestor==null) return root;
           else return ancestor;
        }else return null;
    }
   public int searchX(TreeNode root,TreeNode X){
       if(X==root||X==root.left||X==root.right)return 1;
        if(root.left!=null){
            if(searchX(root.left,X)>0)return 1;
        }
        if(root.right!=null){
            if(searchX(root.right,X)>0)return 1;
        }return 0;
}
}