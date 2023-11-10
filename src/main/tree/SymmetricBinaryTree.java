package tree;

/**
 * Problem Description
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First and only argument is the root node of the binary tree.
 *
 *
 *
 * Output Format
 * Return 0 / 1 ( 0 for false, 1 for true ).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * Input 2:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
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
 *  The above binary tree is symmetric.
 * Explanation 2:
 *
 * The above binary tree is not symmetric.
 */
public class SymmetricBinaryTree {
    public int isSymmetric(TreeNode A) {
        return isSymmetric(A.left, A.right);
    }

    int isSymmetric(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) {
            return 1;
        } else if(n1 == null) {
            return 0;
        } else if(n2 == null) {
            return 0;
        } else if(n1.val != n2.val) {
            return 0;
        }
        int r1 = isSymmetric(n1.left, n2.right);
        int r2 = isSymmetric(n1.right, n2.left);
        return r1 & r2;
    }
}
