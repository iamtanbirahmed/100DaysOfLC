/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        
        while(queue.isEmpty() == false){
            int size = queue.size();
            Node prev = null;
            for(int i=0;i<size;i++){
                Node node = queue.poll();
                node.next = prev;
                prev = node;
                if(node.right!=null)
                    queue.offer(node.right);
                if(node.left !=null)
                    queue.offer(node.left);
            }
        }
        
        return root;
    }
}