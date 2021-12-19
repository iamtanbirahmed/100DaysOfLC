/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<TreeNode> nodes = new ArrayList();
    public void findNodes (TreeNode root){
        if(root == null) return;
        this.findNodes(root.left);
        nodes.add(root);
        this.findNodes(root.right);
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.findNodes(root);
        int index = this.nodes.indexOf(p);
        return (index == this.nodes.size()-1)? null : this.nodes.get(index+1);
    }
}