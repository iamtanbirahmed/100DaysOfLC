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

    private int preIndex = 0;
    
    private StringBuilder preorder(TreeNode root, StringBuilder sb){
        if(root == null) return sb;
        sb.append(root.val).append(",");
        sb = this.preorder(root.left, sb);
        sb = this.preorder(root.right, sb);
        return sb;
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder sb = this.preorder(root, new StringBuilder());
        return sb.toString();
    }
    
    private TreeNode constructTree(String[] preorder, int left, int right){
        if(this.preIndex >= preorder.length) return null;
        int val = Integer.valueOf(preorder[this.preIndex]);
        if(val <= left || val>= right) return null;
        TreeNode node = new TreeNode(val);
        this.preIndex++;
        node.left = this.constructTree(preorder, left, val);
        node.right = this.constructTree(preorder, val, right);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        String[] preorder = data.split(",");
        return this.constructTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;