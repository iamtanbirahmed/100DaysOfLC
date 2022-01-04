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
    private boolean isPresent(TreeNode root, int k, Set<Integer> nodes){
        if(root == null) return false;
        int key = k - root.val;
        if(nodes.contains(key) == true) return true;
        nodes.add(root.val);
        return this.isPresent(root.left, k, nodes) || this.isPresent(root.right, k, nodes);
    }
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> nodes = new HashSet();  
        return this.isPresent(root, k, nodes) ;
    }
}