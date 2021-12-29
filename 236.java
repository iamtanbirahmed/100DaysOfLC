/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode result;
    
    public int findAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return 0;
        int mid = 0;
        if(root.val == p.val || root.val == q.val){
            mid = 1;
        }
        int left = this.findAncestor(root.left, p, q);
        int right = this.findAncestor(root.right, p, q);
        if(mid+left+right>1){
            this.result = root;
        }
        return mid | left | right;
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.findAncestor(root, p, q);
        return this.result;
    }
}