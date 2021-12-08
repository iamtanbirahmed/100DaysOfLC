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
    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode l = new ListNode();
        ListNode prev = l;
        
        while(l1 !=null && l2!=null){
            if(l1.val <= l2.val){
                l.next = l1;
                l1 = l1.next;
            }else if(l1.val>l2.val){
                l.next = l2;
                l2 = l2.next;
            }
            l= l.next;
        }
        l.next = (l1==null)?l2:l1;
        return prev.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedList = null;
        for(int i=0;i<lists.length;i++){
            mergedList = mergeTwoSortedList(lists[i], mergedList);
        }
        return mergedList;
    }
}