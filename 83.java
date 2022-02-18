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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode curr = head.next;
        
        while(curr!=null){
            if(curr.val == prev.val){
                ListNode nxt = curr.next;
                prev.next = curr.next;
                curr = nxt;
                continue;
            }
            prev = curr;
            curr = curr.next;            
        }
        return head;
    }
}