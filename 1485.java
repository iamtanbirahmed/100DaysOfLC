/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    private HashMap<Node, NodeCopy> cloneMap = new HashMap();
    
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null) return null;
        if(this.cloneMap.containsKey(root)){
            return this.cloneMap.get(root);
        }
        
        NodeCopy clone = new NodeCopy(root.val);
        this.cloneMap.put(root, clone);
        
        clone.left = this.copyRandomBinaryTree(root.left);
        clone.right = this.copyRandomBinaryTree(root.right);
        clone.random = this.copyRandomBinaryTree(root.random);
        
        return clone;
    }
}