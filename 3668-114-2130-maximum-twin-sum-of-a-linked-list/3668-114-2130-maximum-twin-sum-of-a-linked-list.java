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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        int max = Integer.MIN_VALUE;
        ListNode reversed = reverse(slow);

        ListNode original_pointer = head;
        ListNode reversed_pointer = reversed;

        while (reversed_pointer != null) {
            max = Math.max(max, original_pointer.val + reversed_pointer.val);
            original_pointer = original_pointer.next;
            reversed_pointer = reversed_pointer.next;
        }

        return max;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}