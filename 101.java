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
    private boolean checkSymmetry(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return this.checkSymmetry(left.right , right.left) &&
            this.checkSymmetry(left.left , right.right); 
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root ==null) return true;
        return checkSymmetry(root.left, root.right);
    }
}