package tree;

import java.util.LinkedList;
import java.util.Queue;

public class NextPointerBinaryTree {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        TreeLinkNode curr = root;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(curr);
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i=1; i<=n; i++) {
                curr = queue.poll();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                if(i != n) {
                    curr.next = queue.peek();
                }
            }
        }
    }
}
