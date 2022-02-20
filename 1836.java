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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if(head ==null || head.next == null) return head;
        HashMap<Integer, Integer> count = new HashMap();
        ListNode curr = head;
        
        while(curr!=null){
            count.put(curr.val, count.getOrDefault(curr.val, 0)+1);
            curr = curr.next;
        }
        
        while(head!=null && count.get(head.val)>1){
            head = head.next;
        }
        
        curr = head;
        ListNode prev = head;
        while(curr!=null){
            if(count.get(curr.val)>1){
                ListNode next = curr.next;
                prev.next = next;
                curr = next;
                continue;
            }
            prev = curr;
            curr = curr.next;
        }
        
        return head;
            
    }
}