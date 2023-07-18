package linkedlist;

/**
 * Problem Description
 * Write a program to find the node at which the intersection of two singly linked lists, A and B, begins. For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * NOTE:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * The custom input to be given is different than the one explained in the examples. Please be careful.
 */
public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        int sizeA = 0, sizeB = 0;
        ListNode temp = a;
        while(temp != null) {
            sizeA++;
            temp = temp.next;
        }

        temp = b;
        while(temp != null) {
            sizeB++;
            temp = temp.next;
        }
        ListNode temp1, temp2;
        if(sizeA > sizeB) {
            temp1 = a;
            temp2 = b;
        } else {
            temp1 = b;
            temp2 = a;
        }
        for(int i = Math.abs(sizeA - sizeB); i>0; i--) {
            temp1 = temp1.next;
        }

        while(temp1 != null && temp2 != null) {
            if(temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;
    }

    public static void main(String[] args) {
        IntersectionOfLinkedList ob = new IntersectionOfLinkedList();
        int[] A = {1,2,3,4};
        int[] B = {5,6,7,8};
        ListNode head1 = LinkedList.arrayToLinkedList(A);
        ListNode head2 = LinkedList.arrayToLinkedList(B);
        int[] C = {7,8,9};
        ListNode head3 = LinkedList.arrayToLinkedList(C);
        LinkedList.insertTail(head1, head3);
        LinkedList.insertTail(head2, head3);
        LinkedList.print(head1);
        LinkedList.print(head2);
        head3 = ob.getIntersectionNode(head1, head2);
        LinkedList.print(head3);
    }
}
