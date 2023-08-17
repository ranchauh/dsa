package tree;

public class FlattenBinaryTree {
    static class Pair {
        TreeNode head;
        TreeNode tail;
        Pair(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public TreeNode flatten(TreeNode a) {
        return flattenBT(a).head;
    }

    Pair flattenBT(TreeNode root) {
        if(root == null) {
            return new Pair(null, null);
        }
        // flatten left and right subtrees recursively
        Pair left = flattenBT(root.left);
        Pair right = flattenBT(root.right);

        // if left and right child are null
        if(left.head == null && right.head == null) {
            return new Pair(root, root);
        }
        // if root's left child is null
        if(left.head == null) {
            root.left = null;
            root.right = right.head;
            return new Pair(root, right.tail);
        }
        // if root's right child is null
        if(right.head == null) {
            root.left = null;
            root.right = left.head;
            return new Pair(root, left.tail);
        }
        root.left = null;
        root.right = left.head;
        left.tail.right = right.head;
        return new Pair(root, right.tail);
    }
}
