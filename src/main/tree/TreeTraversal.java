package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
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
public class TreeTraversal {
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

    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * Given the root of a tree A with each node having a certain value, find the count of nodes with more value than all its ancestors.
     * Ancestor means that every node that occurs before the current node in the path from root to the node.
     */
    public int countNodeLargerThanAncestor(TreeNode root, int maxAncestor) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        if(root.val > maxAncestor) {
            count++;
            maxAncestor = root.val;
        }
        int lc = countNodeLargerThanAncestor(root.left, maxAncestor);
        int rc = countNodeLargerThanAncestor(root.right, maxAncestor);
        return lc + rc + count;
    }

    public int sumNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return sumNodes(root.left) + sumNodes(root.right) + root.val;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = 0;

        if(isLeaf(root.left)) {
            sum = root.left.val;
        } else {
            sum  += sumOfLeftLeaves(root.left);
        }

        sum  += sumOfLeftLeaves(root.right);

        return sum;
    }

    public boolean isLeaf(TreeNode node) {
        if(node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }

    public int calculateHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        int max = Math.max(leftHeight, rightHeight);
        return max + 1;
    }

    public static void main(String[] args) {
        TreeTraversal tt = new TreeTraversal();

    }

}
