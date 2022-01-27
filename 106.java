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
    
    private int postIndex; 
    private HashMap<Integer, Integer> inIndex = new HashMap();
    private TreeNode constructTree(int left, int right, int[] postorder){
        if(postIndex < 0 || left == right)return null;
        int val = postorder[postIndex];
        int index = this.inIndex.get(val);
        TreeNode node = new TreeNode(val);
        this.postIndex--;
        node.right = this.constructTree(index+1, right, postorder);
        node.left = this.constructTree(left, index, postorder);
        return node;
        
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postIndex = postorder.length-1;
        for(int i=0;i<inorder.length; i++){
            this.inIndex.put(inorder[i],i);
        }
        return this.constructTree(0, inorder.length, postorder);
    }
}