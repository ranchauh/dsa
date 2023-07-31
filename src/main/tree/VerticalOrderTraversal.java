package tree;
import java.util.*;

/**
 * Problem Description
 * Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
 *
 *
 * NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
 *
 *
 *
 * Problem Constraints
 * 0 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First and only arument is a pointer to the root node of binary tree, A.
 *
 *
 *
 * Output Format
 * Return a 2D array denoting the vertical order traversal of tree as shown.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *       6
 *     /   \
 *    3     7
 *   / \     \
 *  2   5     9
 * Input 2:
 *
 *       1
 *     /   \
 *    3     7
 *   /       \
 *  2         9
 *
 *
 * Example Output
 * Output 1:
 *
 *  [
 *     [2],
 *     [3],
 *     [6, 5],
 *     [7],
 *     [9]
 *  ]
 * Output 2:
 *
 *  [
 *     [2],
 *     [3],
 *     [1],
 *     [7],
 *     [9]
 *  ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  First row represent the verical line 1 and so on.
 */
public class VerticalOrderTraversal {
    class Pair {
        TreeNode node;
        int level;
        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        return verticalOrderTraversal(A, 1);
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode node, int level) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, level));
        int maxLevel = Integer.MIN_VALUE, minLevel = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            node = pair.node;
            level = pair.level;
            maxLevel = Math.max(maxLevel, level);
            minLevel = Math.min(minLevel, level);
            if(map.containsKey(level)) {
                ArrayList<Integer> lst = map.get(level);
                lst.add(node.val);
                map.put(level, lst);
            } else {
                ArrayList<Integer> lst = new ArrayList<>();
                lst.add(node.val);
                map.put(level, lst);
            }
            if(node.left != null) {
                queue.add(new Pair(node.left, level - 1));
            }
            if(node.right != null) {
                queue.add(new Pair(node.right, level + 1));
            }
        }

        for(int i=minLevel; i<=maxLevel; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
