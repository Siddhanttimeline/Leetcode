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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        Map<Integer,Integer> freq = new TreeMap<>();

        while(list1 != null){
            freq.put(list1.val, freq.getOrDefault(list1.val, 0)+1);
            list1 = list1.next;
        }

        while(list2 != null){
            freq.put(list2.val, freq.getOrDefault(list2.val, 0)+1);
            list2 = list2.next;
        }

        ListNode head = new ListNode(-1);
        ListNode pointer = head;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            while(value-- > 0){
                ListNode node = new ListNode(key);
                pointer.next = node;
                pointer = node;
            }
        }

        return head.next;
    }
}