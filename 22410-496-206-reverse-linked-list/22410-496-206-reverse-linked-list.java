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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next; // saving the next node
            curr.next = prev; // changing the association
            prev = curr; // moving prev pointer forward
            curr = next; // moving curr pointer forward
        }
        
        return prev; // prev pointer will become the new head 
    }
}