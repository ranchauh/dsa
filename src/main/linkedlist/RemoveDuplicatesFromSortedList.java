package linkedlist;

/**
 * Problem Description
 * Given a sorted linked list, delete all duplicates such that each element appears only once.
 *
 *
 *
 * Problem Constraints
 * 0 <= length of linked list <= 106
 *
 *
 *
 * Input Format
 * First argument is the head pointer of the linked list.
 *
 *
 *
 * Output Format
 * Return the head pointer of the linked list after removing all duplicates.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  1->1->2
 * Input 2:
 *
 *  1->1->2->3->3
 *
 *
 * Example Output
 * Output 1:
 *
 *  1->2
 * Output 2:
 *
 *  1->2->3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Each element appear only once in 1->2.
 */
public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode A) {
        if(A == null || A.next == null) {
            return A;
        }
        ListNode prev = A;
        ListNode curr = A.next;
        while(curr != null) {
            if(prev.val != curr.val) {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = curr;
        return A;
    }

    public static void main(String[] args) {
        ListNode head = deleteDuplicates(LinkedList.arrayToLinkedList(new int[]{1,1,1,2,2,2,3,3,3}));
        LinkedList.print(head); // 1 -> 2 -> 3
    }
}
