package linkedlist;

/**
 * Problem Description
 * You are given two linked lists, A and B, representing two non-negative numbers.
 *
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 *
 * Add the two numbers and return it as a linked list.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A|, |B| <= 105
 *
 *
 *
 * Input Format
 * The first argument of input contains a pointer to the head of linked list A.
 *
 * The second argument of input contains a pointer to the head of linked list B.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the required linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *  A = [2, 4, 3]
 *  B = [5, 6, 4]
 * Input 2:
 *
 *
 *  A = [9, 9]
 *  B = [1]
 *
 *
 * Example Output
 * Output 1:
 *
 *
 *  [7, 0, 8]
 * Output 2:
 *
 *
 *  [0, 0, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  A = 342 and B = 465. A + B = 807.
 * Explanation 2:
 *
 *  A = 99 and B = 1. A + B = 100.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode n1 = A;
        ListNode n2 = B;
        ListNode head = null, tail = null;
        int carry = 0;
        while(n1 != null && n2 != null) {
            int v1 = n1.val;
            int v2 = n2.val;
            int add = carry + v1 + v2;
            int quo = add % 10;
            carry = add / 10;
            ListNode node = new ListNode(quo);
            if(head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            n1 = n1.next;
            n2 = n2.next;
            LinkedList.print(head);
        }
        while(n1 != null) {
            int v1 = n1.val;
            int add = carry + v1;
            int quo = add % 10;
            carry = add / 10;
            tail.next = new ListNode(quo);
            tail = tail.next;
            n1 = n1.next;
        }
        while(n2 != null) {
            int v2 = n2.val;
            int add = carry + v2;
            int quo = add % 10;
            carry = add / 10;
            tail.next = new ListNode(quo);
            tail = tail.next;
            n2 = n2.next;
        }
        if(carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbers ob = new AddTwoNumbers();
        ListNode list1 = LinkedList.arrayToLinkedList(new int[]{9, 9});
        ListNode list2 = LinkedList.arrayToLinkedList(new int[]{1});
        ListNode list3 = ob.addTwoNumbers(list1, list2);
        LinkedList.print(list3); // 0 -> 0 -> 1
    }
}
