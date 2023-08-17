package tree.bst;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem Description
 * Two elements of a Binary Search Tree (BST), represented by root A are swapped by mistake. Tell us the 2 values, when swapped, will restore the Binary Search Tree (BST).
 *
 * A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
 *
 * Note: The 2 values must be returned in ascending order
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is the head of the tree,A
 *
 *
 *
 * Output Format
 * Return the 2 elements which need to be swapped.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *          1
 *         / \
 *        2   3
 * Input 2:
 *
 *
 *          2
 *         / \
 *        3   1
 *
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 1]
 * Output 2:
 *
 *  [3, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Swapping 1 and 2 will change the BST to be
 *          2
 *         / \
 *        1   3
 * which is a valid BST
 * Explanation 2:
 *
 * Swapping 1 and 3 will change the BST to be
 *          2
 *         / \
 *        1   3
 * which is a valid BST
 */
public class RecoverBST {
    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> inorder = inorder(A);
        int first = -1;
        int second = -1;
        for(int i=1; i<inorder.size(); i++) {
            if(inorder.get(i) < inorder.get(i-1)) {
                if(first == -1) {
                    first = inorder.get(i-1);
                    second = inorder.get(i);
                } else {
                    second = inorder.get(i);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if(first < second) {
            result.add(first);
            result.add(second);
        } else {
            result.add(second);
            result.add(first);
        }
        return result;
    }

    ArrayList<Integer> inorder(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode root = A;
        stack.push(root);
        while(!stack.isEmpty()) {
            while(root != null && root.left != null) {
                root = root.left;
                stack.push(root);
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
            if(root != null) {
                stack.push(root);
            }
        }
        return list;
    }
}
