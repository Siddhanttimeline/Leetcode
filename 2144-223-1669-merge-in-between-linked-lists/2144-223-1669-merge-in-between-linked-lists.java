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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;

        ListNode secondListTail = list2;
        while(secondListTail.next != null){
            secondListTail = secondListTail.next;
        }

        ListNode left = null;
        ListNode current = list1;

        for(int i=0; i<a; i++){
            left = current;
            current = current.next;
        }

        ListNode right = list1;
        for(int j=0; j<b; j++){
            right = right.next;
        }


        left.next = list2;
        secondListTail.next = right.next;

        return dummy.next;        
    }
}