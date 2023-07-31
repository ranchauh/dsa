package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    static class Pair {
        /**
         * TreeNode
         */
        TreeNode node;
        /**
         Task Definition:
         1: insert left child to stack.
         2: insert right child to stack.
         3: insert node value to result
         4: pop from the stack
         */
        int task;
        Pair(TreeNode node, int task) {
            this.node = node;
            this.task = task;
        }
    }
    public void postorder(TreeNode root, ArrayList<Integer> output) {
        if(root == null) {
            return;
        }

        postorder(root.left, output);

        postorder(root.right, output);

        output.add(root.val);
    }

    public List<Integer> postorderIterativeWithPair(TreeNode A) {
        Stack<Pair> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        Pair pair = new Pair(A, 1);
        stack.push(pair);
        while(!stack.isEmpty()) {
            pair = stack.peek();
            TreeNode node = pair.node;
            if(pair.task == 1) {
                if(node.left != null) {
                    stack.push(new Pair(node.left, 1));
                }
                pair.task++;
            } else if(pair.task == 2) {
                if(node.right != null) {
                    stack.push(new Pair(node.right, 1));
                }
                pair.task++;
            } else if(pair.task == 3) {
                result.add(node.val);
                pair.task++;
            } else {
                stack.pop();
            }
        }
        return result;
    }

    public List<Integer> postorderIterativeWith(TreeNode A) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(A);
        while(!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left != null) {
                stack1.push(node.left);
            }
            if(node.right != null) {
                stack1.push(node.right);
            }
        }

        while(!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }
}
