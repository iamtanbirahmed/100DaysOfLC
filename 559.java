/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    private int maxDepth = 0; 
    public void findMaxDepth(Node root, int depth){
        if(root == null) return;
        this.maxDepth = Math.max(maxDepth, depth+1);
        
        for(Node n: root.children){
            this.findMaxDepth(n , depth+1);
        }
    }
    public int maxDepth(Node root) {
        this.findMaxDepth(root, 0);
        return this.maxDepth;
    }
}