/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder encode = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        encode.append(root.val);
        while(queue.isEmpty() == false){
            TreeNode node = queue.poll();
            if(node != null){
                String leftValue = node.left!=null ? String.valueOf(node.left.val) : "null";
                String rightValue = node.right!=null ? String.valueOf(node.right.val) : "null";
                encode.append(",").append(leftValue);
                encode.append(",").append(rightValue);
                queue.add(node.left);
                queue.add(node.right);
            }
            
        }
        return encode.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> encodeQueue = new LinkedList();
        for(String node: nodes){
            TreeNode tmp = node.equals("null") == false ? new TreeNode(Integer.valueOf(node)) : null;
            encodeQueue.add(tmp);
            
        }
        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = encodeQueue.poll();
        queue.add(root);
        
        while(queue.isEmpty() == false && encodeQueue.isEmpty() == false){
            TreeNode node = queue.poll();
            if(node !=null){
                node.left = encodeQueue.poll();
                node.right = encodeQueue.poll();
                queue.add(node.left);
                queue.add(node.right);    
            }            
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));