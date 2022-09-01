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
    
    private int findGoodNodes(TreeNode root, int max){
        if(root == null) return 0;
        boolean isCurrentNode = (max <= root.val) ? true : false;
        max  = Math.max(max, root.val);
        int left  = this.findGoodNodes(root.left, max);
        int right  = this.findGoodNodes(root.right, max);
        
        return (isCurrentNode) ? (left+right)+1 : left+right;
    }
    
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return this.findGoodNodes(root, root.val);
    }
}