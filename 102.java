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
    
    public void traverse(TreeNode root, ArrayList<List<Integer>> result, int level){
        if(root == null) return;
        
        if(result.size() == level){
            result.add(level, new LinkedList());
        }
        result.get(level).add(root.val);
        
        this.traverse(root.left, result, level+1);
        this.traverse(root.right, result, level+1);
        
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new LinkedList();
        ArrayList<List<Integer>> result = new ArrayList();
        this.traverse(root, result, 0);
        return result;
    }
}