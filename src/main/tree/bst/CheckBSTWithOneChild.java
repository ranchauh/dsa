package tree.bst;

import java.util.ArrayList;

/**
 * Problem Description
 *
 * Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= number of nodes <= 100000
 *
 *
 *
 * Input Format
 *
 * First and only argument is an integer array denoting the preorder traversal of binary tree.
 *
 *
 *
 * Output Format
 *
 * Return a string "YES" if true else "NO".
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A : [4, 10, 5, 8]
 * Input 2:
 *
 *  A : [1, 5, 6, 4]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  "YES"
 * Output 2:
 *
 *  "NO"
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  The possible BST is:
 *             4
 *              \
 *              10
 *              /
 *              5
 *               \
 *               8
 * Explanation 2:
 *
 *  There is no possible BST which have the above preorder traversal.
 */
public class CheckBSTWithOneChild {
    public String solve(int[] A) {
        int n = A.length;
        int l = Integer.MIN_VALUE;
        int r = Integer.MAX_VALUE;
        int root = A[0];
        for(int i=1; i<n; i++) {
            if(A[i] > root) {
                l = root;
            } else {
                r = root;
            }
            if(A[i] < l || A[i] > r) {
                return "NO";
            }
            root = A[i];
        }
        return "YES";
    }

    public String solve(ArrayList<Integer> A) {
        int n = A.size();
        if(n <= 2) {
            return "YES";
        }
        int min = Math.min(A.get(n-1), A.get(n-2));
        int max = Math.max(A.get(n-1), A.get(n-2));
        for(int i=n-3; i>=0; i--) {
            int x = A.get(i);
            if(x > min && x > max) {
                max = x;
            } else if(x < min && x < max) {
                min = x;
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}
