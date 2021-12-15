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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int minDepth = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        HashMap<TreeNode, Integer> depth = new HashMap();
        depth.put(root, 1);
        while(queue.isEmpty() == false){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if(left!=null){
                depth.put(left, depth.get(node)+1);
                queue.add(left);
                if(left.left == null && left.right == null){
                    minDepth = Math.min(minDepth, depth.get(left));
                }
            }
            if(right!=null){
                depth.put(right, depth.get(node)+1);
                queue.add(right);
                if(right.left == null && right.right == null){
                    minDepth = Math.min(minDepth, depth.get(right));
                }
            }
            
        }
        return minDepth;
    }
}