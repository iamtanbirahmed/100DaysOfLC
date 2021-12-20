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
    
    public void findPath(TreeNode node, int currentSum, int target){
        if(node == null) return;
        
        if(currentSum+node.val == target){
            this.count++;
        }
        
        this.findPath(node.left, currentSum+node.val, target);
        this.findPath(node.right, currentSum+node.val, target);        
    }
    
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(queue.isEmpty() == false){
            TreeNode node = queue.poll();
            this.findPath(node, 0, targetSum);
            if(node.left != null){
                queue.add(node.left);
            }
            
            if(node.right !=null){
                queue.add(node.right);
            }
        }
        
        return this.count;
    }
}