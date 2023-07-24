package linkedlist;

public class KReverseLinkedList {
    public ListNode reverseList(ListNode A, int B) {
        ListNode prev = null, next = null;
        ListNode curr = A;

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        int i = 0;
        while(i < B && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        if(curr == null) {
            return prev;
        }

        ListNode temp = A;
        A = prev;
        // 3 -> 2 -> 1  4 -> 5 -> 6

        while(curr != null) {
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
            }
            temp.next = prev;
            temp = temp1;
        }
        return A;
    }

    public static void main(String[] args) {
        KReverseLinkedList ob = new KReverseLinkedList();
        ListNode head = LinkedList.arrayToLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8 , 9});
        head = ob.reverseList(head, 3);
        LinkedList.print(head);
    }
}
