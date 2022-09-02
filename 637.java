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
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return new LinkedList<>();
        List<Double> result = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        while(queue.isEmpty() == false){
            double sum = 0;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            result.add(sum/size);
        }
        
        return result; 
    }
}