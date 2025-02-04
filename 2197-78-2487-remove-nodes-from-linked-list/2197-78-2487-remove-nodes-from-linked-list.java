/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode reversedLL = reverse(head);

        ListNode dummy = new ListNode(0);
        dummy.next = reversedLL;
        int max = reversedLL.val;

        ListNode prev = reversedLL;
        ListNode current = reversedLL.next;

        while (current != null) {
            if (current.val >= max) {
                max = current.val;
                prev = current;
            } else {
                prev.next = current.next;
            }

            current = current.next;
        }

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}