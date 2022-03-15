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
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode l = new ListNode();
        ListNode prev = l;
        while(l1!=null && l2!=null){
            if(l1.val <=l2.val){
                l.next = l1;
                l1 = l1.next;
            }else{
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        if(l1 == null){
            l.next = l2;
        }else{
            l.next = l1;
        }
        
        return prev.next;
    }
    
    
    private ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast !=null && fast.next !=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        return slow;
    }
    
    private ListNode mergeSortList(ListNode head){
        if(head == null || head.next == null) return head; 
        ListNode middle = this.findMiddle(head);
        ListNode l1 = this.mergeSortList(head);
        ListNode l2 = this.mergeSortList(middle);
        return this.merge(l1,l2);
    }
    
    public ListNode sortList(ListNode head) {
        return this.mergeSortList(head);
    }
}