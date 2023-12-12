package linkedlist;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 *
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 */
class ReverseListInKGroups {
    public ListNode reverseKGroup(ListNode A, int B) {
        ListNode prev = null, next = null;
        ListNode curr = A;
        int totalNodes = nodeCount(A); // O(n)
        int countNodes = 0;

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        int i = 0;
        while(i < B && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
            countNodes++;
        }

        if(curr == null) {
            return prev;
        }

        ListNode temp = A;
        A = prev;
        // 3 -> 2 -> 1  4 -> 5 -> 6

        while(curr != null) {
            if((countNodes + B) > totalNodes) {
                temp.next = curr;
                break;
            }
            // 3 -> 2 -> 1 -> 4 -> 5 -> 6
            ListNode temp1 = curr;
            prev = null;
            i = 0;
            while(i < B && curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                i++;
                countNodes++;
            }
            temp.next = prev;
            temp = temp1;
        }
        return A;
    }

    private int nodeCount(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ReverseListInKGroups ob = new ReverseListInKGroups();
        ListNode head = LinkedList.arrayToLinkedList(new int[]{1, 2, 3, 4, 5});
        head = ob.reverseKGroup(head, 3);
        LinkedList.print(head); // 3 -> 2 -> 1 -> 6 -> 4 -> 5
    }
}
