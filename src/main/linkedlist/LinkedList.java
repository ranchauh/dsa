package linkedlist;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 */

public class LinkedList {
    /**
     * You are given A which is the head of a linked list. Print the linked list in space separated manner.
     * Note : The last node value must also be succeeded by a space and after printing the entire list you should print a new line
     */
    public void print(ListNode A) {
        ListNode hc = A;
        while(hc != null) {
            System.out.print(hc.val);
            hc = hc.next;
            if(hc != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    /**
     * You are given A which is the head of a linked list. Also given is the value B and position C.
     * Complete the function that should insert a new node with the said value at the given position.
     * Notes:
     * In case the position is more than length of linked list, simply insert the new node at the tail only.
     * In case the pos is 0, simply insert the new node at head only.
     * Follow 0-based indexing for the node numbering.
     */
    public ListNode insert(ListNode A, int B, int C) {
        // Create a new node
        ListNode newNode = new ListNode(B);

        if(A == null) {
            A = newNode;
            return A;
        }

        ListNode hc = A;
        int i = 0;
        // Iterate and reach the desired position.
        while(i < C-1 && hc.next != null) {
            hc = hc.next;
            i++;
        }
        // Preserve the current next
        ListNode temp = hc.next;
        // Link the newNode as new next
        hc.next = newNode;
        // Link newNode.next to previous next
        newNode.next = temp;

        return A;
    }

    /**
     * You are given the head of a linked list A and an integer B. You need to find the B-th element of the linked list.
     * Note : Follow 0-based indexing for the node numbering.
     */
    public int findKThElement(ListNode A, int B) {
        ListNode hc = A;
        for(int i=0; i<B; i++) {
            hc = hc.next;
        }
        return hc.val;
    }

    private ListNode arrayToLinkedList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        for(int i=1; i<arr.length; i++) {
            insert(head, arr[i], i);
        }
        return head;
    }

    /**
     * Given heads of two linked lists A and B, check if they are identical i.e. each of their corresponding nodes should contain the same data.
     * The two given linked lists may or may not be of the same length.
     */
    public boolean compare(ListNode A, ListNode B) {
        ListNode hc1 = A;
        ListNode hc2 = B;
        while(hc1 != null && hc2 != null) {
            if(hc1.val != hc2.val) {
                return false;
            }
            hc1 = hc1.next;
            hc2 = hc2.next;
        }
        return hc1 == hc2;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] A = {6,3,3,6,7,8,7,3,7};
        ListNode head = list.arrayToLinkedList(A); // 6 -> 3 -> 3 -> 6 -> 7 -> 8 -> 7 -> 3 -> 7
        list.print(head);
        list.insert(head, 3, 5); // 6 -> 3 -> 3 -> 6 -> 7 -> 3 -> 8 -> 7 -> 3 -> 7
        list.print(head);
        // find kth element
        System.out.println(list.findKThElement(head, 3)); // 6
        // compare two linked list
        LinkedList list2 = new LinkedList();
        int[] B = {6,3,3,6,7,8,7,3,7};
        ListNode head2 = list2.arrayToLinkedList(B);
        System.out.println(list.compare(head,head2));
    }

}
