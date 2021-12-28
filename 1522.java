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
    
    protected int diameter = 0;
    
    private int findHeight(Node root){
        if(root == null) return 0;
        if(root.children == null || root.children.size() == 0) return 1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((h1, h2)->{
            return Integer.compare(h1,h2);
        });
        
        for(Node child: root.children){
            int currentHeight = this.findHeight(child);
            pq.offer(currentHeight);
            if(pq.size() > 2){
                pq.poll();
            }
        }
        int highest = Integer.MIN_VALUE;
        int sum = 0;
        while(pq.isEmpty() == false){
            int currentHeight = pq.poll();
            sum+=currentHeight;
            highest = Math.max(currentHeight, highest);
        }
        
        this.diameter = Math.max(this.diameter, sum);        
        return highest+1;
        
    }
    
    public int diameter(Node root) {
        this.findHeight(root);
        return this.diameter;
    }
}