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
class BSTIterator {
    
    private List<Integer> nodes;
    private int counter;

    public BSTIterator(TreeNode root) {
        this.nodes = new ArrayList();
        this.counter = 0;
        this.inorderTraverse(root);
    }
    
    private void inorderTraverse(TreeNode root){
        if(root == null) return;
        this.inorderTraverse(root.left);
        this.nodes.add(root.val);
        this.inorderTraverse(root.right);
    }
    
    public int next() {
        return this.nodes.get(this.counter++);        
    }
    
    public boolean hasNext() {
        return this.counter < this.nodes.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */