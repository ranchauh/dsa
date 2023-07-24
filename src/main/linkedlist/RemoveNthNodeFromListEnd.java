package linkedlist;

/**
 * Problem Description
 * Given a linked list A, remove the B-th node from the end of the list and return its head. For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5. NOTE: If B is greater than the size of the list, remove the first node of the list. NOTE: Try doing it using constant additional space.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 106
 *
 *
 * Input Format
 * The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.
 *
 *
 * Output Format
 * Return the head of the linked list after deleting the B-th element from the end.
 *
 *
 * Example Input
 * Input 1:
 * A = 1->2->3->4->5
 * B = 2
 * Input 2:
 * A = 1
 * B = 1
 *
 *
 * Example Output
 * Output 1:
 * 1->2->3->5
 * Output 2:
 *
 *
 *
 * Example Explanation
 * Explanation 1:
 * In the first example, 4 is the second last element.
 * Explanation 2:
 * In the second example, 1 is the first and the last element.
 */
public class RemoveNthNodeFromListEnd {
    public static ListNode removeNthFromEnd(ListNode A, int B) {
        if(B <= 0) {
            return A;
        }
        int size = 0;
        ListNode curr = A;
        while(curr != null) {
            size++;
            curr = curr.next;
        }
        curr = A;
        if(B >= size) {
            // remove the first node
            curr = curr.next;
            return curr;
        }

        ListNode prev = null;
        int count = size;
        while(count != B) {
            prev = curr;
            curr = curr.next;
            count--;
        }
        prev.next = curr.next;
        return A;
    }

    public static void main(String[] args) {
        ListNode head = LinkedList.arrayToLinkedList(new int[] {1, 2, 3, 4, 5, 6});
        head = removeNthFromEnd(head, 2);
        LinkedList.print(head); // 1 -> 2 -> 3 -> 4 -> 6
        head = removeNthFromEnd(head, 0);
        LinkedList.print(head); // 1 -> 2 -> 3 -> 4 -> 6
        head = removeNthFromEnd(head, 6);
        LinkedList.print(head); // 2 -> 3 -> 4 -> 6
        head = removeNthFromEnd(head, 4);
        LinkedList.print(head); // 3 -> 4 -> 6
        head = removeNthFromEnd(head, 1);
        LinkedList.print(head); // 3 -> 4
    }
}
