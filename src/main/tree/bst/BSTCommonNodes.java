package tree.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem Description
 * Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .
 *
 * In case there is no common node, return 0.
 *
 * NOTE:
 *
 * Try to do it one pass through the trees.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in the tree A and B <= 105
 *
 * 1 <= Node values <= 106
 *
 *
 *
 * Input Format
 * First argument represents the root of BST A.
 *
 * Second argument represents the root of BST B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .
 */
public class BSTCommonNodes {

    public static long common(TreeNode root1, TreeNode root2) {
        int mod = 1000000007;
        long sum = 0;
        Stack < TreeNode > s1 = new Stack < TreeNode > ();
        Stack < TreeNode > s2 = new Stack < TreeNode > ();

        while (true) {
            // push the Nodes of first tree in stack s1
            if (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }

            // push the Nodes of second tree in stack s2
            else if (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            }

            // Both root1 and root2 are NULL here
            else if (!s1.isEmpty() && !s2.isEmpty()) {
                root1 = s1.peek();
                root2 = s2.peek();

                // If current keys in two trees are same
                if (root1.val == root2.val) {
                    long temp = (long) root1.val;
                    sum = ((sum % mod) + (temp % mod)) % mod;
                    s1.pop();
                    s2.pop();

                    // move to the inorder successor
                    root1 = root1.right;
                    root2 = root2.right;
                } else if (root1.val < root2.val) {
                    // If Node of first tree is smaller, than that of
                    // second tree, then its obvious that the inorder
                    // successors of current Node can have same value
                    // as that of the second tree Node. Thus, we pop
                    // from s2
                    s1.pop();
                    root1 = root1.right;

                    // root2 is set to NULL, because we need
                    // new Nodes of tree 1
                    root2 = null;
                } else if (root1.val > root2.val) {
                    s2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            }

            // Both roots and both stacks are empty
            else
                break;
        }
        return sum;
    }

    class Pair {
        TreeNode node;
        int task;
        Pair(TreeNode n) {
            this.node = n;
            this.task = 1;
        }
    }
    public int solve(TreeNode A, TreeNode B) {
        List<Integer> inorderA = inorder(A);
        List<Integer> inorderB = inorder(B);
        int n = inorderA.size();
        int m = inorderB.size();
        int i=0;
        int j=0;
        long sum = 0l;
        long mod = 1000000007l;
        while(i<n && j<m) {
            if(inorderA.get(i) < inorderB.get(j)) {
                i++;
            } else if(inorderA.get(i) > inorderB.get(j)) {
                j++;
            } else {
                sum += (long) inorderA.get(i);
                sum %= mod;
                i++;
            }
        }
        return (int) sum;
    }

    List<Integer> inorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root));
        while(!stack.isEmpty()) {
            Pair p = stack.peek();
            TreeNode node = p.node;
            int task = p.task;
            if(task == 1) {
                if(node.left != null) stack.push(new Pair(node.left));
                p.task++;
            } else if(task == 2) {
                inorder.add(node.val);
                p.task++;
            } else if(task == 3) {
                if(node.right != null) stack.push(new Pair(node.right));
                p.task++;
            } else {
                stack.pop();
            }
        }
        return inorder;
    }
}
