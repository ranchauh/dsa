package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem Description
 * Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
 *
 * Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 * 1 <= B, C <= 109
 *
 *
 *
 * Input Format
 * First argument is head of tree A.
 *
 * Second argument is integer B.
 *
 * Third argument is integer C.
 *
 *
 *
 * Output Format
 * Return the LCA.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *       1
 *      /  \
 *     2    3
 * B = 2
 * C = 3
 * Input 2:
 *
 *       1
 *      /  \
 *     2    3
 *    / \
 *   4   5
 * B = 4
 * C = 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  LCA is 1.
 * Explanation 2:
 *
 *  LCA is 2.
 */
public class LeastCommonAncestor {
    public int lca(TreeNode root, int x, int y) {
        List<Integer> pathtoNodeX = new ArrayList<>();
        rootToNodePath(root, x, pathtoNodeX);
        List<Integer> pathtoNodeY = new ArrayList<>();
        rootToNodePath(root, y, pathtoNodeY);
        if(pathtoNodeX.isEmpty() || pathtoNodeY.isEmpty()) {
            return -1;
        }
        Collections.reverse(pathtoNodeX);
        Collections.reverse(pathtoNodeY);
        // System.out.println(pathtoNodeX);
        // System.out.println(pathtoNodeY);
        int n = Math.min(pathtoNodeX.size(), pathtoNodeY.size());
        for(int i=0; i<n; i++) {
            if(!pathtoNodeX.get(i).equals(pathtoNodeY.get(i))) {
                if(i > 0) {
                    return pathtoNodeX.get(i-1);
                } else {
                    pathtoNodeX.get(0);
                }
            }
        }
        return pathtoNodeX.get(n-1);
    }

    /**
     Finds the path from root to the node containing the given value and populate rootToNodePath with the node values
     */
    boolean rootToNodePath(TreeNode root, int k, List<Integer> pathtoNode) {
        if(root == null) {
            return false;
        }
        if(root.val == k) {
            pathtoNode.add(root.val);
            return true;
        }
        if(rootToNodePath(root.left, k, pathtoNode)) {
            pathtoNode.add(root.val);
            return true;
        }
        if(rootToNodePath(root.right, k, pathtoNode)) {
            pathtoNode.add(root.val);
            return true;
        }
        return false;
    }
}
