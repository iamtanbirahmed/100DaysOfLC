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
    public boolean findPath(int currentSum, TreeNode root, int target){
        if(root == null) return false;
        if(root.left == null && root.right == null && currentSum+root.val == target){
            return true;
        }
        return this.findPath(currentSum+root.val, root.left, target) 
            || this.findPath(currentSum+root.val, root.right, target) ;
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return this.findPath(0, root, targetSum);
    }
}