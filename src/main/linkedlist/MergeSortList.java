package linkedlist;

public class MergeSortList {

    public ListNode sortList(ListNode A) {
        if(A == null) {
            return null;
        } else if(A.next == null) {
            return A;
        }
        return mergeSort(A);
    }

    private ListNode mergeSort(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode mid = LinkedList.findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode t1 = mergeSort(head);
        ListNode t2 = mergeSort(head2);
        return mergeTwoLists(t1, t2);
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode h1 = A;
        ListNode h2 = B;
        if(h1 == null) {
            return h2;
        } else if(h2 == null) {
            return h1;
        }
        ListNode head = null;
        if(h1.val < h2.val) {
            head = h1;
            h1 = h1.next;
        } else {
            head = h2;
            h2 = h2.next;
        }
        ListNode tail = head;
        while(h1 != null && h2 != null) {
            if(h1.val < h2.val) {
                tail.next = h1;
                h1 = h1.next;
            } else {
                tail.next = h2;
                h2 = h2.next;
            }
            tail = tail.next;
        }
        if(h1 == null) {
            tail.next = h2;
        }
        if(h2 == null) {
            tail.next = h1;
        }
        return head;
    }

    public static void main(String[] args) {
        MergeSortList ob = new MergeSortList();
        LinkedList list = new LinkedList();
        int[] A = {6,3,3,6,7,8,7,3,7};
        ListNode head = list.arrayToLinkedList(A);
        head = ob.sortList(head);
        list.print(head); // [3, 3, 3, 6, 6, 7, 7, 7, 8
    }
}
