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
    
    private LinkedList<String> result = new LinkedList<>();
    
    private StringBuilder removeLastNode(StringBuilder sb){
        int lastIndex = sb.lastIndexOf(">");
        if(lastIndex >=0){
            sb = sb.replace(lastIndex-1, sb.length(), "");    
        }
        return sb;
    }
    
    public void findPath(StringBuilder currentPath, TreeNode root){
        if(root == null) return;
        if(currentPath.length()>0)
            currentPath.append("->");
        currentPath.append(root.val);
        if(root.left == null && root.right == null){
            String tmp = currentPath.toString();
            result.add(tmp);
        }
        this.findPath(currentPath, root.left);
        this.findPath(currentPath, root.right);
        
        currentPath = this.removeLastNode(currentPath);
        
        
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        this.findPath(new StringBuilder(), root);
        
        return this.result;
        
        
    }
}