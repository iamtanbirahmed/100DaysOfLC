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
    private List<List<Integer>> result;
    
    private boolean isLeaf(TreeNode node){
        if(node.left == null && node.right == null) return true;
        return false;
    }
    
    private void findPath(TreeNode node, LinkedList<Integer> currentPath, int currentSum, int target){
        if(node == null) return;
        if(this.isLeaf(node) && (currentSum+node.val == target) ){
            LinkedList newList = new LinkedList(currentPath);
            newList.add(node.val);
            this.result.add(new LinkedList(newList));
            return;
        }
        if(this.isLeaf(node) && (currentSum+node.val) != target){
            return;
        }
        
        currentPath.addLast(node.val);
        this.findPath(node.left, currentPath, currentSum+node.val, target);
        this.findPath(node.right, currentPath, currentSum+node.val, target);
        currentPath.removeLast();
        return;
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new LinkedList();
        this.findPath(root, new LinkedList<Integer>(), 0, targetSum);
        return result;
        
    }
}