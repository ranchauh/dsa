package tree.bst;

import java.util.Stack;

/**
 * Problem Description
 * Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
 *
 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 * First argument is the head of the tree A.
 *
 * Second argument is the integer B.
 *
 *
 *
 * Output Format
 * Return 1 if such a pair can be found, 0 otherwise.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *          10
 *          / \
 *         9   20
 *
 * B = 19
 * Input 2:
 *
 *
 *           10
 *          / \
 *         9   20
 *
 * B = 40
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
 *  10 + 9 = 19. Hence 1 is returned.
 * Explanation 2:
 *
 *  No such pair exists.
 */
public class TwoSumBST {
    public int t2Sum(TreeNode A, int B) {
        // Navigate in BST to find the min element node and set ptr1 on it
        // fill elements in forward stack
        Stack<TreeNode> forwardStack = new Stack<>();
        TreeNode ptr1 = A;
        forwardStack.push(ptr1);
        while(ptr1.left != null) {
            ptr1 = ptr1.left;
            forwardStack.push(ptr1);
        }
        // Navigate in BST to find the max element node and set ptr2 on it
        // fill elements in backward stack
        Stack<TreeNode> backwardStack = new Stack<>();
        TreeNode ptr2 = A;
        backwardStack.push(ptr2);
        while(ptr2.right != null) {
            ptr2 = ptr2.right;
            backwardStack.push(ptr2);
        }
        while(!forwardStack.isEmpty() && !backwardStack.isEmpty()) {
            ptr1 = forwardStack.peek();
            ptr2 = backwardStack.peek();
            if(ptr1 != ptr2 && (ptr1.val + ptr2.val) == B) {
                return 1;
            }
            // if sum is greater than B, move ptr2 backward
            if((ptr1.val + ptr2.val) > B) {
                TreeNode node = backwardStack.pop();
                // if it has left child, push it to stack so that we don't miss any value
                if(node.left != null) {
                    backwardStack.push(node.left);
                    node = node.left;
                    // push the whole RST
                    while(node.right != null) {
                        node = node.right;
                        backwardStack.push(node);
                    }
                }
            } else {
                // if sum is smaller than B, move ptr1 backward
                TreeNode node = forwardStack.pop();
                // if top has right child, push it to stack so that we don't miss any value
                if(node.right != null) {
                    forwardStack.push(node.right);
                    node = node.right;
                    while(node.left != null) {
                        node = node.left;
                        forwardStack.push(node);
                    }
                }
            }
        }
        return 0;
    }
}
