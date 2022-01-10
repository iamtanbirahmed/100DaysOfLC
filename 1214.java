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
    
    private boolean search(TreeNode root2, int val){
        if(root2 == null) return false;
        if(root2.val > val){
            return this.search(root2.left, val);
        }else if(root2.val < val){
            return this.search(root2.right, val);
        }else{
            return true;
        }
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null) return false;
        if(this.search(root2, target-root1.val) == true) return true;
        return this.twoSumBSTs(root1.left, root2, target) ||
        this.twoSumBSTs(root1.right, root2, target);
    }
}