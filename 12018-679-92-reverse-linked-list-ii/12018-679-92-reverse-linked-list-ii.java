class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftPrev = dummy;
        ListNode current = head;

        for (int i = 0; i < left - 1; i++) {
            current = current.next;
            leftPrev = leftPrev.next;
        }

        ListNode sublistLeft = current;
        ListNode sublistRight = current;
        for (int i = 0; i < right - left; i++) {
            sublistRight = sublistRight.next;
        }

        ListNode nextNode = sublistRight.next;

        sublistRight.next = null;

        leftPrev.next = reverse(sublistLeft);
        sublistLeft.next = nextNode;

        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
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