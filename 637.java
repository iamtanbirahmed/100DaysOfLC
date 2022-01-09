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
    
    private HashMap<Integer, Double> sum = new HashMap();
    private HashMap<Integer, Integer> count = new HashMap();
    
    private void findValues(TreeNode root, int depth){
        if(root == null){
            return ;
        }
        if(sum.containsKey(depth) == false){
            sum.put(depth, 0.0);
            count.put(depth, 0);
        }
        sum.put(depth, sum.get(depth)+root.val);
        count.put(depth, count.get(depth)+1);
        this.findValues(root.left, depth+1);
        this.findValues(root.right, depth+1);
        
    } 
    
    public List<Double> averageOfLevels(TreeNode root) {
        this.findValues(root, 0);
        ArrayList<Double> result = new ArrayList();
        for(Integer key: this.count.keySet()){
            result.add(key, Double.valueOf(this.sum.get(key)/this.count.get(key)));
        }
        return result;
    }
}