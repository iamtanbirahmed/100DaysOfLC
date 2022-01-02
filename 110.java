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
    public int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(this.height(root.left), this.height(root.right))+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        if(Math.abs(this.height(root.left)- this.height(root.right)) >1) return false;
        
        return this.isBalanced(root.left) && this.isBalanced(root.right);
    }
}