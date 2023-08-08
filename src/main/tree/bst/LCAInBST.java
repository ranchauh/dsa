package tree.bst;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem Description
 * Given a Binary Search Tree A. Also given are two nodes B and C. Find the lowest common ancestor of the two nodes.
 *
 * Note 1 :- It is guaranteed that the nodes B and C exist.
 *
 * Note 2 :- The LCA of B and C in A is the shared ancestor of B and C that is located farthest from the root.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 105
 *
 * 1 <= B , C <= 105
 *
 *
 *
 * Input Format
 * First argument is a root node of the binary tree, A.
 *
 * Second argument is an integer B.
 *
 * Third argument is an integer C.
 *
 *
 *
 * Output Format
 * Return the LCA of the two nodes
 *
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
 *      B = 8
 *      C = 20
 * Input 2:
 *
 *             8
 *            / \
 *           6  21
 *          / \
 *         1   7
 *
 *      B = 7
 *      C = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  15
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The LCA of node 8 and 20 is the node 15.
 * Explanation 2:
 *
 *  The LCA of node 7 and 1 is the node 6.
 */
public class LCAInBST {
    Map<Integer, Integer> inTimeMap = new HashMap<>();
    Map<Integer, Integer> outTimeMap = new HashMap<>();

    int time;

    public int lcaBST(TreeNode root, int x, int y) {
        TreeNode curr = root;
        while(curr != null) {
            if(x > curr.val && y > curr.val) {
                curr = curr.right;
            } else if(x < curr.val && y < curr.val) {
                curr = curr.left;
            } else {
                return curr.val;
            }
        }
        return -1;
    }

    public int lcaBSTUsingInOutTime(TreeNode root, int x, int y) {
        this.buildInOutMap(root);
        // check if x is ancestor of y
        if(inTimeMap.get(x) < inTimeMap.get(y) && outTimeMap.get(x) > outTimeMap.get(y)) {
            return x;
        }
        // check if y is ancestor of x
        if(inTimeMap.get(y) < inTimeMap.get(x) && outTimeMap.get(y) > outTimeMap.get(x)) {
            return y;
        }
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left != null && inTimeMap.get(x) >= inTimeMap.get(curr.left.val) && outTimeMap.get(x) <= outTimeMap.get(curr.left.val) &&
               inTimeMap.get(y) >= inTimeMap.get(curr.left.val) && outTimeMap.get(y) <= outTimeMap.get(curr.left.val)) {
                // check if left node is ancestor of x and y
                curr = curr.left;
            } else if(curr.right != null && inTimeMap.get(x) >= inTimeMap.get(curr.right.val) && outTimeMap.get(x) <= outTimeMap.get(curr.right.val) &&
                inTimeMap.get(y) >= inTimeMap.get(curr.right.val) && outTimeMap.get(y) <= outTimeMap.get(curr.right.val)) {
                // check if right node is ancestor of x and y
                curr = curr.right;
            } else { // current node is ancestor of x and y
                return curr.val;
            }
        }
        return -1;
    }

    private void buildInOutMap(TreeNode root) {
        if(root == null) {
            return;
        }
        inTimeMap.put(root.val, time);
        time++;
        buildInOutMap(root.left);
        buildInOutMap(root.right);
        outTimeMap.put(root.val, time);
        time++;
    }
}
