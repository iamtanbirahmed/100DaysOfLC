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
    
    private ListNode reverse(ListNode head){
        ListNode prev= null;
        ListNode curr = head;
        while(curr !=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = this.reverse(l1);
        l2 = this.reverse(l2);
        
        ListNode l = new ListNode();
        ListNode prev = l;
        
        int carry = 0;
        while(l1!=null && l2!=null){
            int val = (l1.val+l2.val+carry)%10;
            carry = (l1.val+l2.val+carry)/10;
            l.next = new ListNode(val);
            
            l1 = l1.next;
            l2 = l2.next;
            l = l.next;
        }
        
        ListNode l3 = (l1 == null )? l2: l1;
        
        while(l3!=null){
            int val = (l3.val+carry)%10;
            carry = (l3.val+carry)/10;
            l.next = new ListNode(val);
            l3 = l3.next;
            l = l.next;
        }
        if(carry>0){
            l.next = new ListNode(carry);
        }
        
        return this.reverse(prev.next);

    }
}