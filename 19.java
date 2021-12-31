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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;
        
        while(curr!=null){
            length++;
            curr = curr.next;
        }
        if(length == n){
            head = head.next;
            return head;
        }
        int k = 1;
        ListNode prev = curr;
        curr = head;
        while(curr!=null && (k < length-n + 1)){
            prev = curr;
            curr = curr.next;
            k++;            
        }
        
        prev.next = (curr != null) ? curr.next : null;
        curr = null;
        return head;
        
    }
}