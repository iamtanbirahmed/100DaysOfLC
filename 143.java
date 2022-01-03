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
    
    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode l = new ListNode();
        ListNode prev = l;
        while(l1 !=null && l2!=null){
            l.next = l1;
            l1 = l1.next;
            l = l.next;
            l.next = l2;
            l2 = l2.next;
            l = l.next;
        }
        l.next = (l1 == null) ? l2:l1;
        return prev.next;
    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr !=null){
            ListNode tmpNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmpNext;
        }
        return prev;
            
    }
    
    private ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        return slow;
    } 
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode middle = this.findMiddle(head);
        ListNode reverseHead = this.reverseList(middle);
        head = this.mergeList(head, reverseHead);
    }
}