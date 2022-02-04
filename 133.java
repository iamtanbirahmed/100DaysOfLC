/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> map = new HashMap();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(this.map.containsKey(node) == true) return this.map.get(node);
        Node clone = new Node(node.val);
        this.map.put(node, clone);
        for(Node child: node.neighbors){
            clone.neighbors.add(this.cloneGraph(child));
        }
        return clone;
    }
}