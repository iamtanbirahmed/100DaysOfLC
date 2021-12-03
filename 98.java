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
    
    public boolean isValidBST(TreeNode node, Long min, Long max){
        if(node == null) return true;
        if(node.val <= min || node.val >= max) return false;
        return this.isValidBST(node.left, min, Long.valueOf(node.val)) && this.isValidBST(node.right,Long.valueOf(node.val), max);
        
    }
    
    public boolean isValidBST(TreeNode root) {
        return this.isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
}