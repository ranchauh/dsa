package tree.bst;

/**
 * Problem Description
 * Given a Binary Search Tree(BST) A. If there is a node with value B present in the tree delete it and return the tree.
 *
 * Note - If there are multiple options, always replace a node by its in-order predecessor
 *
 *
 * Problem Constraints
 * 2 <= No. of nodes in BST <= 105
 * 1 <= value of nodes <= 109
 * Each node has a unique value
 *
 *
 * Input Format
 * The first argument is the root node of a Binary Search Tree A.
 * The second argument is the value B.
 *
 *
 * Output Format
 * Delete the given node if found and return the root of the BST.
 *
 *
 * Example Input
 * Input 1:
 *
 *             15
 *           /    \
 *         12      20
 *         / \    /  \
 *        10  14  16  27
 *       /
 *      8
 *
 *      B = 10
 *
 * Input 2:
 *
 *             8
 *            / \
 *           6  21
 *          / \
 *         1   7
 *
 *      B = 6
 *
 *
 *
 * Example Output
 * Output 1:
 *
 *             15
 *           /    \
 *         12      20
 *         / \    /  \
 *        8  14  16  27
 *
 * Output 2:
 *
 *             8
 *            / \
 *           1  21
 *            \
 *             7
 *
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Node with value 10 is deleted
 * Explanation 2:
 *
 * Node with value 6 is deleted
 */
public class DeleteFromBST {
    public TreeNode delete(TreeNode root, int k) {
        if(root == null) {
            return root;
        }
        if(root.val > k) {
            root.left = delete(root.left, k);
        } else if(root.val < k) {
            root.right = delete(root.right, k);
        } else {
            if(root.right == null && root.left == null) {
                return null;
            } else if(root.right == null) {
                return root.left;
            } else if(root.left == null) {
                return root.right;
            } else {
                int max = findMaxInBST(root.left);
                root.val = max;
                root.left = delete(root.left, max);
                return root;
            }
        }
        return root;
    }

    private int findMaxInBST(TreeNode root) {
        if(root.right == null) {
            return root.val;
        }
        return findMaxInBST(root.right);
    }
}
