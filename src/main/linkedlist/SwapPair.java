package linkedlist;

/**
 * Given a linked list A, swap every two adjacent nodes and return its head.
 * NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.
 */
public class SwapPair {
    public ListNode swapPairs(ListNode A) {
        if (A == null)
            return null;
        A = rec(A);
        return A;
    }

    public ListNode rec(ListNode node) {
        ListNode nextNode;
        ListNode firstNode = node;
        ListNode prevNode = null;
        if (node.next != null)
            firstNode = node.next;
        while (!(node == null || node.next == null)) {
            // swap the two adjacent nodes
            nextNode = node.next;
            node.next = nextNode.next;
            nextNode.next = node;
            if (prevNode != null)
                prevNode.next = nextNode;
            prevNode = node;
            node = node.next;
        }
        return firstNode;
    }

    public static void main(String[] args) {
        SwapPair ob = new SwapPair();
        int[] A = {1,2,3,4,5,6};
        ListNode head = LinkedList.arrayToLinkedList(A);
        head = ob.swapPairs(head);
        LinkedList.print(head);
    }
}


// A -> B -> C -> D -> E -> F