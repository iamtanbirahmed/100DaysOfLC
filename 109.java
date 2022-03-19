/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    
    private ListNode findMiddle(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        return slow;
    }
    
    private TreeNode constructTree(ListNode head){
        if(head == null) return null;
        ListNode middle = this.findMiddle(head);
        
        if(middle == head){
            return new TreeNode(middle.val);
        }
        
        TreeNode root = new TreeNode(middle.val);
        root.left = this.constructTree(head);
        root.right = this.constructTree(middle.next);
        
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return this.constructTree(head);
    }
}