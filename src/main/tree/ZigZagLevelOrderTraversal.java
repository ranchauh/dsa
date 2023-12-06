package tree;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagLevelOrderTraversal {
    /**
     * Definition for binary tree
     * class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) {
     *      val = x;
     *      left=null;
     *      right=null;
     *     }
     * }
     */
    public class Solution {
        public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
            Stack<TreeNode> currLevel =  new Stack<>();
            Stack<TreeNode> nextLevel =  new Stack<>();
            boolean rightToLeft = false;
            currLevel.push(A);
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            while(!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                if(rightToLeft) {
                    if(node.right != null) nextLevel.push(node.right);
                    if(node.left != null) nextLevel.push(node.left);
                } else {
                    if(node.left != null) nextLevel.push(node.left);
                    if(node.right != null) nextLevel.push(node.right);
                }
                list.add(node.val);
                if(currLevel.isEmpty()) {
                    ans.add(list);
                    list = new ArrayList<>();
                    rightToLeft = !rightToLeft;
                    // Swap stacks
                    Stack<TreeNode> temp = currLevel;
                    currLevel = nextLevel;
                    nextLevel = temp;
                }
            }

            return ans;
        }
    }
}
