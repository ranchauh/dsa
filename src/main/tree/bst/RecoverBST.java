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

    int first = -1;
    int second = -1;
    int prev = -1;
    public int[] recoverTreeMorrisInorder(TreeNode A) {
        first = -1;
        second = -1;
        prev = -1;
        TreeNode curr = A;
        TreeNode last;
        while(curr !=  null) {
            if(curr.left == null) {
                if(prev != -1 && prev > curr.val) {
                    if(first == -1) {
                        first = prev;
                        second = curr.val;
                    } else {
                        second = curr.val;
                    }
                }
                prev = curr.val;
                curr = curr.right;
            } else {
                last = curr.left;
                // go to extreme right child
                while(last.right != null && last.right != curr) {
                    last = last.right;
                }
                // if right was already not connected to curr
                if(last.right == null) {
                    // connect last's right with curr to trace back
                    last.right = curr;
                    curr = curr.left;
                } else {
                    if(prev != -1 && prev > curr.val) {
                        if(first == -1) {
                            first = prev;
                            second = curr.val;
                        } else {
                            second = curr.val;
                        }
                    }
                    prev = curr.val;
                    // disconnect last.right and continue with right substree
                    last.right = null;
                    curr = curr.right;
                }
            }
        }
        if(first < second) {
            return new int[]{first, second};
        }
        return new int[]{second, first};
    }
}
