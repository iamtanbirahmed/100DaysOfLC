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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<TreeNode, Pair<Integer, Integer>> map = new HashMap();
        Map<Integer, List<TreeNode>> verticalMap = new TreeMap();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        map.put(root, new Pair(0,0));        
        List<TreeNode> tmp = new LinkedList();
        tmp.add(root);
        verticalMap.put(0, tmp);
        
        while(queue.isEmpty() == false){
            TreeNode node = queue.poll();
            Pair<Integer, Integer> cor = map.get(node);
            int x = cor.getKey();
            int y = cor.getValue();
            if(node.left != null){
                map.put(node.left, new Pair(x-1, y+1));
                if(verticalMap.containsKey(x-1) == false){
                    verticalMap.put(x-1, new LinkedList<TreeNode>());
                }
                verticalMap.get(x-1).add(node.left);
                queue.offer(node.left);
            }
            if(node.right !=null){
                map.put(node.right, new Pair(x+1, y+1));
                if(verticalMap.containsKey(x+1) == false){
                    verticalMap.put(x+1, new LinkedList<TreeNode>());
                }
                verticalMap.get(x+1).add(node.right);
                queue.offer(node.right);
            }
        }
        List<List<Integer>> result = new LinkedList();
        for(int key: verticalMap.keySet()){
            List<TreeNode> l1 = verticalMap.get(key);
            Collections.sort(l1, (n1, n2)->{
                int x1 = map.get(n1).getKey();
                int x2 = map.get(n2).getKey();
                int y1 = map.get(n1).getValue();
                int y2 = map.get(n2).getValue();
                if(x1 == x2){
                    if(y1 == y2) return n1.val - n2.val;
                    else return y1 - y2;
                }else{
                    return x1 - x2;
                }
                
            });
            List<Integer> l2 = new LinkedList();
            for(TreeNode node: l1){
                l2.add(node.val);
            }
            result.add(l2);
        }
        
        return result;
    }
}