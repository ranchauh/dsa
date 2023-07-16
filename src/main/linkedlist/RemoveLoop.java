package linkedlist;

public class RemoveLoop {
    public ListNode solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        // check if loop exists.
        while(fast !=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                break;
            }
        }
        // if fast and slow pointers do not meet, no loop exists.
        if(fast != slow) {
            return A;
        }

        // start from the head and the meeting point of fast and slow pointer
        // when these two meet that is the start of the loop.
        ListNode h1 = A;
        ListNode h2 = fast;
        while(h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }

        // move h2 until h2.next is h1, to find out the tail of the cyclip LL.
        while(h2 != null && h2.next != h1) {
            h2 = h2.next;
        }
        // make tails next null to remove the loop
        if(h2 != null) h2.next = null;
        return A;
    }

    public static void main(String[] args) {
        RemoveLoop ob = new RemoveLoop();
        int[] A = {6,3,3,6,7,8,7,3,7};
        ListNode head = LinkedList.arrayToLinkedList(A);
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        //LinkedList.print(head); // infinite loop
        head = ob.solve(head);
        LinkedList.print(head); // 6 -> 3 -> 3 -> 6 -> 7 -> 8 -> 7 -> 3 -> 7
    }
}
