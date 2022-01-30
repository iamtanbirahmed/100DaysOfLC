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
    private HashMap<Integer, Integer> indexMap = new HashMap();
    private int preIndex = 0;
    
    private TreeNode constructTree(int left, int right, int[] preorder){
        if(this.preIndex >= preorder.length || left > right) return null;
        int val = preorder[this.preIndex];
        TreeNode node = new TreeNode(val);
        int inIndex = this.indexMap.get(val);
        this.preIndex++;
        node.left = this.constructTree(left, inIndex-1, preorder);
        node.right = this.constructTree(inIndex+1, right, preorder);
        
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            this.indexMap.put(inorder[i], i);
        }
        
        return this.constructTree(0, inorder.length-1, preorder);
    }
}