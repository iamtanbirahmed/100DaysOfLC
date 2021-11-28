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
    
    private List<List<Integer>> leaves;
    
    private boolean isLeaf(TreeNode node){
        if(node.left == null && node.right == null) return true;
        return false;
    }
    
    public void find(TreeNode node){
        if(node == null) return;
        List<Integer> levelLeaves = new LinkedList();
        if(this.isLeaf(node)){
            levelLeaves.add(node.val);
            this.leaves.add(levelLeaves);
            return;
        }
        
        List<TreeNode> queue = new LinkedList();
        queue.add(node);
        
        while(queue.isEmpty() == false){
            TreeNode root = queue.remove(0);
            TreeNode left = root.left;
            TreeNode right = root.right;
            if(left != null && this.isLeaf(left)){
                levelLeaves.add(left.val);
                root.left = null;
            }else if(left!= null){
                queue.add(left);
            }
            
            
            if(right != null && this.isLeaf(right)){
                levelLeaves.add(right.val);
                root.right = null;
            }else if(right != null){
                queue.add(right);
                
            }
            
        }
        this.leaves.add(levelLeaves);
        find(node);
        
        
        
    }    
        
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null) return new LinkedList();
        this.leaves = new LinkedList();
        find(root);
        
        return this.leaves;
        
        
    }
}