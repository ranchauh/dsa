package tree;

import java.util.LinkedList;
import java.util.Queue;

public class AwesomeBinaryTree {
    public int solve(TreeNode A) {
        TreeNode curr = A;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        boolean wasLastLevelFull;
        queue.add(curr);
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i=0; i<n; i++) {
                curr = queue.poll();
                if(curr.right != null && curr.left == null) {
                    return 0;
                }
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            wasLastLevelFull = (n == (1 << level));
            if(!queue.isEmpty() && !wasLastLevelFull) {
                return 0;
            }
            level++;
        }

        return 1;
    }

    public int solveForOnlyLastLevel(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while(!queue.isEmpty()) {
            int n = queue.size();
            boolean isEmptyNodeFound = false;
            for(int i=0; i<n; i++) {
                TreeNode curr = queue.poll();
                if(isEmptyNodeFound && (curr.right != null || curr.left != null)) {
                    return 0;
                }
                if(curr.left != null) {
                    queue.add(curr.left);
                } else {
                    isEmptyNodeFound = true;
                }
                if(isEmptyNodeFound && curr.right != null) {
                    return 0;
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                } else {
                    isEmptyNodeFound = true;
                }
            }
        }
        return 1;
    }
}
