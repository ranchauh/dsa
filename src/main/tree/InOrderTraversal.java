package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public void inorder(TreeNode root, ArrayList<Integer> output) {
        if(root == null) {
            return;
        }
        inorder(root.left, output);

        output.add(root.val);

        inorder(root.right, output);
    }

    public List<Integer> inorderIterative(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
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
