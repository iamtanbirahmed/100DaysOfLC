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
    private int preIndex=0;
    private TreeNode constructBST(int min, int max, int[] preorder){
        if(this.preIndex >= preorder.length) return null;
        int val = preorder[this.preIndex];
        if(val <= min || val>=max) return null;
        TreeNode node = new TreeNode(val);
        this.preIndex++;
        node.left = this.constructBST(min, val, preorder);
        node.right = this.constructBST(val, max, preorder);
        return node;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return this.constructBST(Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
    }
}