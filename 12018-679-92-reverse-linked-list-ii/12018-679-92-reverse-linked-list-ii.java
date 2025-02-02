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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode leftPrev = dummy;
        ListNode current = head;

        for(int i=0; i<left-1; i++){
            leftPrev = current;
            current = current.next;
        }

        ListNode prev = null;
        for(int j=0; j < right - left + 1; j++){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        leftPrev.next.next = current;
        leftPrev.next = prev;


        return dummy.next;
    }
}