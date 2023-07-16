package linkedlist;

/**
 * Problem Description
 * Given a singly linked list A
 *
 *  A: A0 → A1 → … → An-1 → An
 * reorder it to:
 *
 *  A0 → An → A1 → An-1 → A2 → An-2 → …
 * You must do this in-place without altering the nodes' values.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 106
 *
 *
 *
 * Input Format
 * The first and the only argument of input contains a pointer to the head of the linked list A.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the modified linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [1, 2, 3, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 5, 2, 4, 3]
 * Output 2:
 *
 *  [1, 4, 2, 3]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The array will be arranged to [A0, An, A1, An-1, A2].
 * Explanation 2:
 *
 *  The array will be arranged to [A0, An, A1, An-1, A2].
 */
public class ReorderList {
    public static ListNode reorderList(ListNode A) {
        ListNode mid = LinkedList.findMid(A);
        ListNode head1 = A;
        ListNode head2 = mid.next;
        mid.next = null;

        head2 = LinkedList.reverse(head2);
        while(head1 != null && head2 != null) {
            ListNode temp = head1.next;
            head1.next = head2;
            head2 = head2.next;
            head1.next.next = temp;
            head1 = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        ListNode head = LinkedList.arrayToLinkedList(A);
        head = reorderList(head);
        LinkedList.print(head);
    }
}
