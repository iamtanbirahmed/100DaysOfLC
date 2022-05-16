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
    
    private List<Integer> result = new LinkedList();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return this.result;
        this.result = this.postorderTraversal(root.left);
        this.result = this.postorderTraversal(root.right);
        this.result.add(root.val);
        return this.result;
    }
}