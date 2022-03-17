/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    private HashMap<Node, Node> cloneMap = new HashMap();
    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(this.cloneMap.containsKey(head)){
            return this.cloneMap.get(head);
        }
        Node clone = new Node(head.val);
        this.cloneMap.put(head, clone);
        clone.next = this.copyRandomList(head.next);
        clone.random = this.copyRandomList(head.random);
        
        return clone;
    }
}