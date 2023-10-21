package tree;

import tree.traversal.iterative.InOrder;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static void main(String[] args) {
        TreeBuilder treeBuilder = new TreeBuilder();
        InOrderTraversal inOrder = new InOrderTraversal();
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(12,4,9,15,5,-1,6,9,10));
        ArrayList<Integer> pre = new ArrayList<>(Arrays.asList(5,12,9,4,15,6,-1,10,9));
        TreeNode root = treeBuilder.buildTreeWithInAndPre(in, pre);
        List<Integer> output = inOrder.inorderIterative(root);
        System.out.println(output); // 12,4,9,15,5,-1,6,9,10
    }
}
