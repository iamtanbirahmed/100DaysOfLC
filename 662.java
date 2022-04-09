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
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList();
        queue.offer(new Pair<TreeNode, Integer>(root, 0));
        int max = Integer.MIN_VALUE;
        while(queue.isEmpty() == false){
            Pair<TreeNode, Integer> head = queue.peek();
            int size = queue.size();
            
            Pair<TreeNode, Integer> elem = null;
            for(int i=0;i<size;i++){
                elem = queue.poll();
                TreeNode node = elem.getKey();
                int index = elem.getValue();
                if(node.left!=null){
                    queue.offer(new Pair<TreeNode, Integer>(node.left, 2*index) );
                }
                if(node.right!=null){
                    queue.offer(new Pair<TreeNode, Integer>(node.right, 2*index+1) );
                }                
            }
            
            max = Math.max(elem.getValue() - head.getValue() +1 , max);
            
        }
        
        return max;
    }
}