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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        HashMap<Integer, List<Integer>> columnMap = new HashMap();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList();
        queue.add(new Pair(root, 0));
        int minColumn = Integer.MAX_VALUE;
        int maxColumn = Integer.MIN_VALUE;
        while(queue.isEmpty() == false){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();
            if(columnMap.containsKey(column) == false){
                columnMap.put(column, new ArrayList());                
            }
            columnMap.get(column).add(node.val);
            
            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);
            
            if(node.left != null){
                queue.add(new Pair(node.left, column-1));
            }
            if(node.right !=null){
                queue.add(new Pair(node.right, column+1));
            }
        }
        
        ArrayList<List<Integer>> result = new ArrayList();
        for(int i=minColumn;i<=maxColumn;i++){
            result.add(columnMap.get(i));
        }
        return result;
    }
}