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
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new LinkedList();
        List<List<Integer>> result = new LinkedList();
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        int depth = -1;
        while(queue.isEmpty() == false){            
            depth++;
            int size = queue.size();
            List<Integer> l1 = new LinkedList();
            for(int i=0;i<size;i++){
                Node node  = queue.poll();
                l1.add(node.val);
                if(node.children !=null){
                    for(Node child: node.children){
                        if(child !=null){
                            queue.offer(child);
                        }
                    }    
                }    
            }
            result.add(l1);            
        }
        return result;
    }
}