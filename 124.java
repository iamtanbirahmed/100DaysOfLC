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
    
    private int max = Integer.MIN_VALUE;
    
    private int maxGain(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, this.maxGain(root.left));
        int right = Math.max(0, this.maxGain(root.right));
        
        this.max = Math.max(this.max, left+right+root.val);
        
        return Math.max(left, right)+root.val;
    }
    
    public int maxPathSum(TreeNode root) {
        this.maxGain(root);
        
        return this.max;
    }
}