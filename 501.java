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
    
    
    public void dfs(TreeNode root, HashMap<Integer, Integer> count){
        if(root == null)return;
        this.dfs(root.left, count);
        if(count.containsKey(root.val) == false){
            count.put(root.val, 0);
        }
        count.put(root.val, count.get(root.val)+1);
        this.dfs(root.right, count);
    }
    
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> count = new HashMap();
        ArrayList<Integer> result = new ArrayList();
        this.dfs(root, count);
        int max = 0;
        for(int key: count.keySet()){
            if(count.get(key) > max){
                max = count.get(key);
            }
        }
        
        for(int key: count.keySet()){
            if(count.get(key) == max){
                result.add(key);
            }
        }
        
        int[] resultArray = new int[result.size()];
        for(int i=0;i<resultArray.length;i++){
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}