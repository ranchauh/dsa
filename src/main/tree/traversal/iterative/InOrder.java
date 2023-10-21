package tree.traversal.iterative;

import tree.TreeBuilder;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class InOrder {
    static class Pair {
        TreeNode node;
        /**
         * 1: Put node's left child to stack
         * 2: Print the data
         * 3: Put node's right child to stack
         * 4: Pop node from the stack
         */
        int task;
        Pair(TreeNode node) {
            this.node = node;
            this.task = 1;
        }
    }

    /**
     * TC: O(n)
     * SC: O(height)
     */
    void inOrder(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root));
        while(!stack.isEmpty()) {
            Pair top = stack.peek();
            TreeNode node = top.node;
            if(top.task == 1) {
                if(node.getLeft() != null) {
                    stack.push(new Pair(node.getLeft()));
                }
                top.task++;
             } else if(top.task == 2) {
                System.out.print(node.getVal() + " ");
                top.task++;
            } else if(top.task == 3) {
                if(node.getRight() != null) {
                    stack.push(new Pair(node.getRight()));
                }
                top.task++;
            } else {
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        TreeBuilder treeBuilder = new TreeBuilder();
        InOrder inOrder = new InOrder();
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(12,4,9,15,5,-1,6,9,10));
        ArrayList<Integer> pre = new ArrayList<>(Arrays.asList(5,12,9,4,15,6,-1,10,9));
        TreeNode root = treeBuilder.buildTreeWithInAndPre(in, pre);
        inOrder.inOrder(root); // 12,4,9,15,5,-1,6,9,10
    }
}
