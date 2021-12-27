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
    private int diameter = 0;
    private int calculateHeight(TreeNode root){
        if(root == null) return 0;
        int left =  this.calculateHeight(root.left);
        int right = this.calculateHeight(root.right);
        this.diameter = Math.max(this.diameter, left+right);
        
        return Math.max(left, right)+1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        this.calculateHeight(root);
        
        return this.diameter;
    }
}