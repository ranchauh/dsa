package linkedlist;

/**
 * Problem Description
 * You are given a linked list A
 * Each node in the linked list contains two pointers: a next pointer and a random pointer
 * The next pointer points to the next node in the list
 * The random pointer can point to any node in the list, or it can be NULL
 * Your task is to create a deep copy of the linked list A
 * The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
 * You should create a new linked list B, where each node in B has the same value as the corresponding node in A
 * The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)
 *
 *
 * Problem Constraints
 * 0 <= |A| <= 106
 *
 *
 *
 * Input Format
 * The first argument of input contains a pointer to the head of linked list A.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the required linked list.
 *
 *
 *
 * Example Input
 * Given list
 *    1 -> 2 -> 3
 * with random pointers going from
 *   1 -> 3
 *   2 -> 1
 *   3 -> 1
 *
 *
 *
 * Example Output
 *    1 -> 2 -> 3
 * with random pointers going from
 *   1 -> 3
 *   2 -> 1
 *   3 -> 1
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class DeepCopyList {

    public RandomListNode arrayToLinkedList(int[] arr, int[] random) {
        RandomListNode head = new RandomListNode(arr[0]);
        RandomListNode tail = head;
        for(int i=1; i<arr.length; i++) {
            tail.next = new RandomListNode(arr[i]);
            tail = tail.next;
        }
        tail = head;
        for (int j : random) {
            if (j == -1) {
                tail.random = null;
            } else {
                tail.random = findKThElement(head, j);
            }
            tail = tail.next;
        }
        return head;
    }

    public RandomListNode findKThElement(RandomListNode A, int B) {
        RandomListNode hc = A;
        for(int i=1; i<B; i++) {
            hc = hc.next;
        }
        return hc;
    }

    private void printRandomList(RandomListNode head) {
        RandomListNode hc = head;
        while(hc != null) {
            int random = hc.random == null ? -1 : hc.random.label;
            System.out.print("[" + hc.label + ", " + random + "]");
            hc = hc.next;
            if(hc != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode temp = head;

        // create deep copy of the list and place the new nodes in the original list adjacently.
        while(temp != null) {
            RandomListNode node = new RandomListNode(temp.label);
            node.next = temp.next;
            temp.next = node;

            temp = temp.next.next;
        }

        // create random pointers in the newly created nodes
        temp = head;
        while(temp != null && temp.next != null) {
            if(temp.random == null) {
                temp.next.random = null;
            } else {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // make two lists out of a single one
        RandomListNode temp1 = head;
        RandomListNode head1 = temp1.next;
        RandomListNode temp2 = head1;
        while(temp2.next != null) {
            RandomListNode tmp = temp2.next;
            temp1.next = temp2.next;
            temp2.next = tmp.next;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp1.next = null;
        return head1;
    }

    public static void main(String[] args) {
        DeepCopyList ob = new DeepCopyList();
        int[] arr =    {1, 2, 3, 4, 5};
        int[] random = {3, 5, -1, 2, 1};
        RandomListNode head = ob.arrayToLinkedList(arr, random);
        ob.printRandomList(head);
        RandomListNode copy = ob.copyRandomList(head);
        ob.printRandomList(copy);
    }

}
