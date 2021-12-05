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
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public void traverse(TreeNode root, int level){
        if(root == null) return;
        if(result.size() == level){
            result.add(level, new LinkedList()); 
        }
        result.get(level).add(root.val);
        
        this.traverse(root.left, level+1);
        this.traverse(root.right, level+1);
        
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        this.traverse(root, 0);
        Collections.reverse(this.result);
        return this.result;
    }
}