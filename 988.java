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
    private List<String> result = new LinkedList();
    
    public void findPath(StringBuilder currentPath, TreeNode root){
        if(root == null) return;
        
        char ch =(char) (root.val+97);
        currentPath.append(ch);    
        
        if(root.left == null && root.right == null){
            String tmp = new StringBuilder(currentPath.toString()).reverse().toString();
            result.add(tmp);
        }
        this.findPath(currentPath, root.left);
        this.findPath(currentPath, root.right);
        
        currentPath = currentPath.replace(currentPath.length()-1, currentPath.length(), "");
        
    }
    public String smallestFromLeaf(TreeNode root) {
        
        this.findPath(new StringBuilder(), root);
        
        String[] resultArray = this.result.toArray(new String[this.result.size()]);
        Arrays.sort(resultArray);
        
        return resultArray[0];
    }
}