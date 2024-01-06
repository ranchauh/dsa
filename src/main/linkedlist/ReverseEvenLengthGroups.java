package linkedlist;

public class ReverseEvenLengthGroups {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseEvenLengthGroups(ListNode head) {
            int counter = 2;
            ListNode curr = head.next;
            ListNode prev = head;
            while(curr != null) {
                ListNode localCurr = curr;
                ListNode localPrev = prev;
                int count = 1;
                while(curr != null && count <= counter) {
                    prev = curr;
                    curr = curr.next;
                    count++;
                }
                count = count - 1;
                if(Math.min(count, counter)%2 == 0) {
                    localPrev.next = reverse(localCurr, Math.min(count, counter));
                    prev = localCurr;
                }
                counter++;
            }
            return head;
        }

        ListNode reverse(ListNode head, int count) {
            ListNode prev = null;
            ListNode curr = head;
            ListNode next = null;
            while(curr != null && count > 0) {
                next = curr.next;

                curr.next = prev;

                prev = curr;
                curr = next;

                count--;
            }
            head.next = next;
            return prev;
        }
    }
}
