package tree;

import java.util.ArrayList;

public class TreeUtils {

    public static int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * Given the root of a tree A with each node having a certain value, find the count of nodes with more value than all its ancestors.
     * Ancestor means that every node that occurs before the current node in the path from root to the node.
     */
    public static int countNodeLargerThanAncestor(TreeNode root, int maxAncestor) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        if(root.val > maxAncestor) {
            count++;
            maxAncestor = root.val;
        }
        int lc = countNodeLargerThanAncestor(root.left, maxAncestor);
        int rc = countNodeLargerThanAncestor(root.right, maxAncestor);
        return lc + rc + count;
    }

    public static int sumNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return sumNodes(root.left) + sumNodes(root.right) + root.val;
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = 0;

        if(isLeaf(root.left)) {
            sum = root.left.val;
        } else {
            sum  += sumOfLeftLeaves(root.left);
        }

        sum  += sumOfLeftLeaves(root.right);

        return sum;
    }

    public static boolean isLeaf(TreeNode node) {
        if(node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }

    public static int calculateHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        int max = Math.max(leftHeight, rightHeight);
        return max + 1;
    }

    public static void main(String[] args) {
        TreeUtils tt = new TreeUtils();
        
    }

}
