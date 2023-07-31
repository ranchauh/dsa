package tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
    public void preorder(TreeNode root, ArrayList<Integer> output) {
        if(root == null) {
            return;
        }

        output.add(root.val);

        preorder(root.left, output);

        preorder(root.right, output);
    }
    public ArrayList<Integer> preorderIterative(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode root = A;
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if(root.right != null) {
                stack.push(root.right);
            }
            if(root.left != null) {
                stack.push(root.left);
            }
        }
        return result;
    }
}
