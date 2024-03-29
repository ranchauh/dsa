package tree.bst;

import java.util.List;

/**
 * Problem Description
 * Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
 *
 * Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of array <= 100000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return a root node of the Binary Search Tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A : [1, 2, 3]
 * Input 2:
 *
 *  A : [1, 2, 3, 5, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *       2
 *     /   \
 *    1     3
 * Output 2:
 *
 *       3
 *     /   \
 *    2     5
 *   /       \
 *  1         10
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  You need to return the root node of the Binary Tree.
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(final List<Integer> A) {
        return buildBST(A, 0, A.size()-1);
    }

    private TreeNode buildBST(List<Integer> A, int s, int e) {
        if(s > e) {
            return null;
        }
        int mid = s + (e-s)/2;
        TreeNode root = new TreeNode(A.get(mid));
        root.left = buildBST(A, s, mid - 1);
        root.right = buildBST(A, mid + 1, e);
        return root;
    }
}
