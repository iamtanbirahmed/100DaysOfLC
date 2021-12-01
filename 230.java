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
    
    private Stack<Integer> inOrderTravarse(TreeNode root, Stack<Integer> maxStack, int k){
        
        if(root == null) return maxStack;
        maxStack = this.inOrderTravarse(root.left, maxStack,k);
        maxStack.push(root.val);
        if(maxStack.size()>k)
            maxStack.pop();
        maxStack = this.inOrderTravarse(root.right, maxStack, k);
        return maxStack;
        
    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> maxStack = new Stack(); 
        maxStack = this.inOrderTravarse(root, maxStack, k);
        return maxStack.peek();
        
    }
}