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
    public int findDepth(TreeNode root, int depth){
        if(root == null) return depth;
        return Math.max(
            this.findDepth(root.left, depth+1 ),
            this.findDepth(root.right, depth+1)
        );
        
    }
    public int maxDepth(TreeNode root) {
        return this.findDepth(root, 0);
    }
}