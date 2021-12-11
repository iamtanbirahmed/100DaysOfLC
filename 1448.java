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
    private int count = 0;
    private Stack<Integer> maxStack = new Stack();
    
    public void countNodes(TreeNode root){
        if(root == null) return;
        if(maxStack.size() == 0 || root.val >= maxStack.peek()){
            maxStack.push(root.val);
            count++;
        }
        
        this.countNodes(root.left);
        this.countNodes(root.right);
        if(maxStack.peek() == root.val)
            maxStack.pop();
    }
    
    public int goodNodes(TreeNode root) {
        this.countNodes(root);
        return count;
    }
}