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
    
    private LinkedList<String> result = new LinkedList();
    
    public void findPath(StringBuilder currentPath, TreeNode root){
        if(root ==null) return;
        
        currentPath.append(root.val);
        if(root.left == null && root.right == null){
            String tmp = currentPath.toString();
            result.add(tmp);
        }
        
        this.findPath(currentPath, root.left);
        this.findPath(currentPath, root.right);
        
        currentPath.replace(currentPath.length()-1, currentPath.length(), "");
        
    }
    
    public int sumNumbers(TreeNode root) {
        this.findPath(new StringBuilder(), root);
        int sum = 0;
        for(String num : this.result){
            sum+=Integer.valueOf(num);
        }
        
        return sum;
    }
}