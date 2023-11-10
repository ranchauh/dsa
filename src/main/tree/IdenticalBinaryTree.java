package tree;

/**
 * Problem Description
 * Given two binary trees, check if they are equal or not.
 *
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * The first argument is a root node of the first tree, A.
 *
 * The second argument is a root node of the second tree, B.
 *
 *
 *
 * Output Format
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *    1       1
 *   / \     / \
 *  2   3   2   3
 * Input 2:
 *
 *    1       1
 *   / \     / \
 *  2   3   3   3
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Both trees are structurally identical and the nodes have the same value.
 * Explanation 2:
 *
 *  Values of the left child of the root node of the trees are different.
 */
public class IdenticalBinaryTree {
    public int isSameTree(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) {
            return 1;
        } else if(n1 == null && n2 != null) {
            return 0;
        } else if(n1 != null && n2 == null) {
            return 0;
        } else if(n1.val != n2.val) {
            return 0;
        }
        int r1 = isSameTree(n1.left, n2.left);
        int r2 = isSameTree(n1.right, n2.right);
        return r1 & r2;
    }
}
