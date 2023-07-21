package linkedlist;

/**
 * You are given A, the head of a LinkedList and two integers B and C. Traverse the linked list and remove some nodes in the following way:<
 * 1. Start with the head as the current node.
 * 2. Keep the first B nodes in the LinkedList.
 * 3. Remove the next C Nodes.
 * Keep repeating steps 2 and 3 until you reach the end of the LinkedList.
 */

public class SkipAndDelete {
    public static ListNode solve(ListNode A, int B, int C) {
        ListNode temp = A;
        ListNode prev = A;
        int skipped = 0;
        int removed = 0;
        while(temp != null) {
            if(skipped == B) {
                while(temp != null && removed != C) {
                    prev.next = temp.next;
                    temp = temp.next;
                    removed++;
                }
                removed = 0;
                skipped = 0;
            } else {
                prev = temp;
                temp = temp.next;
                skipped++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        ListNode head = LinkedList.arrayToLinkedList(new int[]{1,2,3,4,5,6});
        LinkedList.print(head); // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        head = solve(head, 2, 1);
        LinkedList.print(head); // 1 -> 2 -> 4 -> 5

        head = LinkedList.arrayToLinkedList(new int[]{4,3,2,1});
        LinkedList.print(head); // 4 -> 3 -> 2 -> 1
        head = solve(head, 2, 3);
        LinkedList.print(head); // 4 -> 3
    }
}

