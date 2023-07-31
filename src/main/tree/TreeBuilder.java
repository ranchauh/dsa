package tree;

import java.util.ArrayList;

public class TreeBuilder {

    public TreeNode buildTreeWithInAndPost(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size() != B.size()) {
            return null;
        }
        return buildTreeWithInAndPost(B, A, 0, B.size()-1, 0, A.size()-1);
    }

    private TreeNode buildTreeWithInAndPost(ArrayList<Integer> postorder, ArrayList<Integer> inorder, int ps, int pe, int is, int ie) {
        if(is > ie || ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(postorder.get(pe));
        int rootIdx = search(inorder, is, ie, root.val);
        int elInLst = rootIdx - is;
        // build left subtree
        root.left = buildTreeWithInAndPost(postorder, inorder, ps, ps + elInLst - 1 , is, rootIdx-1);

        // build right subtree
        root.right = buildTreeWithInAndPost(postorder, inorder, ps + elInLst , pe - 1, rootIdx+1, ie);

        return root;
    }

    public TreeNode buildTreeWithInAndPre(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size() != B.size()) {
            return null;
        }
        return buildTreeWithInAndPre(A, B, 0, A.size()-1, 0, B.size()-1);
    }

    private TreeNode buildTreeWithInAndPre(ArrayList<Integer> preorder, ArrayList<Integer> inorder, int ps, int pe, int is, int ie) {
        if(is > ie || ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(preorder.get(ps));
        int rootIdx = search(inorder, is, ie, root.val);
        int elInLst = rootIdx - is;
        // build left subtree
        root.left = buildTreeWithInAndPre(preorder, inorder, ps+1, ps + elInLst, is, rootIdx-1);

        // build right subtree
        root.right = buildTreeWithInAndPre(preorder, inorder, ps+elInLst+1, pe, rootIdx+1, ie);

        return root;
    }

    private int search(ArrayList<Integer> inorder, int s, int e, int val) {
        for(int i=s; i<=e; i++) {
            if(inorder.get(i) == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
