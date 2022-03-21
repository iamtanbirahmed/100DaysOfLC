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
        HashMap<Integer, Integer> count = new HashMap();
        ListNode dummy = head; 
        while(dummy!=null){
            count.put(dummy.val, count.getOrDefault(dummy.val,0)+1);
            dummy = dummy.next;
        }
        
        while(head!=null && count.get(head.val)>1){
            head = head.next;
        }
        
        ListNode prev = head;
        ListNode curr = head;
        while(curr!=null){
            if(count.get(curr.val)>1){
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
                prev.next = curr;
                continue;
            }
            prev = curr;
            curr = curr.next;
            
        }
        
        return head;
    }
}