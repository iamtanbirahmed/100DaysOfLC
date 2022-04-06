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
    public int deepestLeavesSum(TreeNode root) {
        HashMap<TreeNode, Integer> depth = new HashMap();
        HashMap<Integer, Integer> depthSum = new HashMap();
        
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        depth.put(root, 0);
        depthSum.put(0, root.val);
        
        while(queue.isEmpty() == false){
            TreeNode node = queue.poll();
            int level = depth.get(node);
            
            if(node.left !=null){
                depth.put(node.left, level+1);
                depthSum.put(level+1, depthSum.getOrDefault(level+1,0)+node.left.val);
                queue.offer(node.left);
            }
            
            if(node.right !=null){
                depth.put(node.right, level+1);
                depthSum.put(level+1, depthSum.getOrDefault(level+1,0)+node.right.val);
                queue.offer(node.right);
            }            
        }
        
        int maxDepth = Collections.max(depthSum.keySet());
        
        return depthSum.get(maxDepth);
        
    }
}