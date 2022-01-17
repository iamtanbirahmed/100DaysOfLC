/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        if(root == null) return null;
        Node clone = new Node(root.val, new ArrayList<Node>());
        for(Node child: root.children){
            clone.children.add(this.cloneTree(child));
        }
        return clone;
    }
}