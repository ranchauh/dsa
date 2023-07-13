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
     * You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.
     * Note : Follow 0-based indexing for the node numbering.
     */
    public ListNode delete(ListNode A, int B) {
        if(B == 0) {
            A = A.next;
            return A;
        }
        ListNode head = A;
        for(int i=1; i<= B-1; i++) {
            if(head == null) {
                return A;
            }
            head = head.next;
        }
        head.next = head.next.next;
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

    /**
     * You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
     * NOTE: You have to do it in-place and in one-pass.
     */
    public ListNode reverse(ListNode A) {
        ListNode prev = null;
        ListNode curr = A;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
     */
    public int isPalindrome(ListNode A) {
        // 1. Calculate the size of the LL
        int size = 0;
        ListNode head = A;
        while(head != null) {
            size++;
            head = head.next;
        }
        // 2. Traverse till (size-1)/2 to divide the LL in two parts.
        int mid = (size-1)/2;
        ListNode head1 = A;
        for(int i=0; i<mid; i++) {
            head1 = head1.next;
        }
        // 3. Reverse part2
        head1 = reverse(head1);
        head  = A;
        // 4. Compare and check palindrome
        ListNode curr1 = head;
        ListNode curr2 = head1;
        int isPalindrome = 1;
        while(curr1 != null && curr2 != null) {
            if(curr1.val != curr2.val) {
                isPalindrome = 0;
                break;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        // 5. Restore the LL by reversing the LL back.
        head1 = reverse(head1);

        // 6. Return result;
        return isPalindrome;
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
        int[] B = {6,3,3,6,7,3,8,7,3,7};
        ListNode head2 = list2.arrayToLinkedList(B);
        System.out.println(list.compare(head,head2)); // true

        // delete 2nd idx value from list
        head = list.delete(head, 2);
        int[] C = {6,3,6,7,3,8,7,3,7};
        ListNode head3 = list2.arrayToLinkedList(C);
        System.out.println(list.compare(head,head3)); // true

        head = list.reverse(head);
        int[] R = {7,3,7,8,3,7,6,3,6};
        ListNode headR = list2.arrayToLinkedList(R);
        System.out.println(list.compare(head,headR)); // true


        System.out.println(list2.isPalindrome(headR)); // 0

        int[] P = {1,2,3,4,3,2,1};
        ListNode pList = list2.arrayToLinkedList(P);
        System.out.println(list2.isPalindrome(pList)); // 1

        P = new int[]{1,2,3,4,2,1};
        pList = list2.arrayToLinkedList(P);
        System.out.println(list2.isPalindrome(pList)); // 0

    }

}
