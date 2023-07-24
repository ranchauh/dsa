package linkedlist;

/**
 * Problem Description
 * Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.
 *
 * A palindrome list is a list that reads the same backward and forward.
 *
 * Expected memory complexity : O(1)
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the linked list <= 2000
 *
 * 1 <= Node value <= 100
 *
 *
 *
 * Input Format
 * The only argument given is head pointer of the linked list.
 *
 *
 *
 * Output Format
 * Return the length of the longest palindrome list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  2 -> 3 -> 3 -> 3
 * Input 2:
 *
 *  2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  5
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  3 -> 3 -> 3 is largest palindromic sublist
 * Explanation 2:
 *
 *  2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.
 */
public class LongestPalindromicList {
    public int solve(ListNode A) {
        if(A == null || A.next == null) {
            return 1;
        }
        ListNode prev = null, next = null;
        ListNode curr = A;
        int maxLen = 0;
        while(curr != null) {
            next = curr.next;
            // reverse the curr node to make a reverse LL till this position
            curr.next = prev;
            // calculate odd length palindromic LL
            int oddLen = 2 * count(prev, next) + 1;
            maxLen = Math.max(maxLen, oddLen);

            // calcualte even length palindromic LL
            int evenLen = 2 * count(curr, next);
            maxLen = Math.max(maxLen, evenLen);

            // move pointers
            prev = curr;
            curr = next;
        }
        return maxLen;
    }

    private int count(ListNode left, ListNode right) {
        int count = 0;
        while(left != null && right != null) {
            if(left.val != right.val) {
                break;
            }
            count++;
            left = left.next;
            right = right.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LongestPalindromicList ob = new LongestPalindromicList();
        ListNode head = LinkedList.arrayToLinkedList(new int[]{2, 1, 2, 1, 2, 2, 1, 3, 2, 2});
        System.out.println(ob.solve(head)); // 5
        head = LinkedList.arrayToLinkedList(new int[]{1,2,3,3,2,1});
        System.out.println(ob.solve(head)); // 6
    }
}
