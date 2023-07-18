package linkedlist;

/**
 * Problem Description
 * Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 106
 *
 * 1 <= A[i], B <= 109
 *
 *
 *
 * Input Format
 * The first argument of input contains a pointer to the head to the given linked list.
 *
 * The second argument of input contains an integer, B.
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
 * A = [1, 4, 3, 2, 5, 2]
 * B = 3
 * Input 2:
 *
 * A = [1, 2, 3, 1, 3]
 * B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 * [1, 2, 2, 4, 3, 5]
 * Output 2:
 *
 * [1, 1, 2, 3, 3]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  [1, 2, 2] are less than B wheread [4, 3, 5] are greater than or equal to B.
 * Explanation 2:
 *
 *  [1, 1] are less than B wheread [2, 3, 3] are greater than or equal to B.
 */
public class PartitionList {
    public ListNode partition(ListNode A, int B) {
        if(A == null) {
            return null;
        }
        ListNode head1 = null, head2 = null, temp1 = null, temp2 = null;
        ListNode curr = A;
        // partition list into two lists
        while(curr != null) {
            if(curr.val < B) {
                if(head1 == null) {
                    head1 = curr;
                    temp1 = head1;
                } else {
                    temp1.next = curr;
                    temp1 = temp1.next;
                }
                curr = curr.next;
                temp1.next = null;
            } else {
                if(head2 == null) {
                    head2 = curr;
                    temp2 = head2;
                } else {
                    temp2.next = curr;
                    temp2 = temp2.next;
                }
                curr = curr.next;
                temp2.next = null;
            }
        }
        // join partitioned lists.
        if(temp1 != null) {
            temp1.next = head2;
            return head1;
        } else {
            return head2;
        }
    }

    public static void main(String[] args) {
        PartitionList ob = new PartitionList();
        int[] A = {1,4,3,2,5,2};
        ListNode head = LinkedList.arrayToLinkedList(A);
        head = ob.partition(head, 3);
        LinkedList.print(head);
    }
}
