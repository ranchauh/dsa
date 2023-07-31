package tree;

public class BalancedBinaryTree {
    static class Pair {
        boolean isBalanced;
        int height;
        Pair(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public int isBalanced(TreeNode root) {
        return checkBalanced(root).isBalanced ? 1 : 0 ;
    }

    public Pair checkBalanced(TreeNode root) {
        if(root == null) {
            return new Pair(true, 0);
        }
        Pair lp = checkBalanced(root.left);
        Pair rp = checkBalanced(root.right);
        if(!lp.isBalanced) {
            return new Pair(false, lp.height);
        }
        if(!rp.isBalanced) {
            return new Pair(false, rp.height);
        }
        if(Math.abs(lp.height - rp.height) > 1) {
            return new Pair(false, rp.height);
        }
        return new Pair(true, Math.max(lp.height, rp.height) + 1);
    }
}
