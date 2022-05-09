/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private TreeNode sentinel = new TreeNode();
    
    private void inorderTraverse(TreeNode root){
        if(root == null) return ;
        this.inorderTraverse(root.left);
        this.sentinel.right = new TreeNode(root.val);
        this.sentinel = this.sentinel.right;
        this.inorderTraverse(root.right);
    }
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode prev = this.sentinel;
        this.inorderTraverse(root);        
        return prev.right;
        
    }
}