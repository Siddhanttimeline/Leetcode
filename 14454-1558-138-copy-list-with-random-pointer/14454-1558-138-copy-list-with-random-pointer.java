class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);

        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            oldToCopy.put(current, copy);
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node copy = oldToCopy.get(current);
            copy.next = oldToCopy.get(current.next);
            copy.random = oldToCopy.get(current.random);
            current = current.next;
        }

        return oldToCopy.get(head);
    }
}