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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode curr = head;
        ArrayList<Integer> nums = new ArrayList();
        while(curr != null){
            nums.add(curr.val);
            curr = curr.next;
        }
        
        int left = 0;
        int right = nums.size()-1;
        while(left<=right && nums.get(left) == nums.get(right)){
            left++;
            right--;
        }
        return nums.get(left) == nums.get(right);
        
    }
}