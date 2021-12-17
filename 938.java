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
    
    public void calculateSum(TreeNode root, int low, int high){
        if(root == null) return;
        if(root.val >=low && root.val<=high){
            this.sum+=root.val;
            this.calculateSum(root.left, low, high);
            this.calculateSum(root.right, low, high);
        }else if(root.val < low){
            this.calculateSum(root.right, low, high);
        }else if(root.val>high){
            this.calculateSum(root.left, low, high);
        }
        
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.calculateSum(root, low, high);
        return this.sum;
    }
}