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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode prev = l;
        int carry = 0;
        while(l1!=null && l2!=null){
            int val = (l1.val+l2.val + carry)%10;
            carry = (l1.val+l2.val + carry)/10;
            l.next = new ListNode(val);
            l=l.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode l3 = (l1 == null) ? l2 : l1;
        
        while(l3!=null){
            int val = (l3.val + carry)%10;
            carry = (l3.val + carry)/10;
            l.next = new ListNode(val);
            l=l.next;
            l3 = l3.next;
        }
        
        if(carry>0){
            l.next = new ListNode(carry);
            l = l.next;
        }
        
        return prev.next;
    }
}