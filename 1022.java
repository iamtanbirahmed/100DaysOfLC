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
    
    private int sum = 0;
    
    private void findSum(TreeNode root, int currentSum){
        if(root == null) return;
        currentSum = (currentSum<<1)|root.val;
        if(root.left ==null && root.right == null){
            this.sum+=currentSum;
        }
        
        this.findSum(root.left, currentSum);
        this.findSum(root.right, currentSum);
        currentSum = currentSum>>1;
    }
    
    public int sumRootToLeaf(TreeNode root) {
        this.findSum(root, 0);
        return this.sum;
    }
}