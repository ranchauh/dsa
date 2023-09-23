package graph;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem Description
 * Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 *
 * Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
 *
 * NOTE:
 *
 * The cycle must contain atleast two nodes.
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 *
 *
 * Problem Constraints
 * 2 <= A <= 105
 *
 * 1 <= M <= min(200000,A*(A-1))
 *
 * 1 <= B[i][0], B[i][1] <= A
 *
 *
 *
 * Input Format
 * The first argument given is an integer A representing the number of nodes in the graph.
 *
 * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 *
 *
 *
 * Output Format
 * Return 1 if cycle is present else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 *  B = [  [1, 2]
 *         [4, 1]
 *         [2, 4]
 *         [3, 4]
 *         [5, 2]
 *         [1, 3] ]
 * Input 2:
 *
 *  A = 5
 *  B = [  [1, 2]
 *         [2, 3]
 *         [3, 4]
 *         [4, 5] ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
 * Explanation 2:
 *
 *  The given graph doesn't contain any cycle.
 */
public class CycleInDirectedGraph {
    public int solve(int n, int[][] edges) {
        List<Integer>[] graph = buildGraph(n, edges);
        for(int i=1; i<=n; i++) {
            boolean[] visited = new boolean[n+1];
            int[] recStack = new int[n+1];
            boolean res = dfs(i, graph, visited, recStack);
            if(res) return 1;
        }
        return 0;
    }

    boolean dfs(int n, List<Integer>[] graph, boolean[] visited, int[] recStack) {
        if(visited[n]) {
            return recStack[n] != 0;
        }
        visited[n] = true;
        recStack[n] = n;
        List<Integer> nbr = graph[n];
        if(nbr != null) {
            for(int x : nbr) {
                if(recStack[x] != 0) {
                    return true;
                }
                if(!visited[x]) {
                    boolean res = dfs(x, graph, visited, recStack);
                    if(res) {
                        return true;
                    }
                }
            }
        }
        recStack[n] = 0;
        return false;
    }

    public List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] list = new ArrayList[n+1];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (list[u] == null) {
                list[u] = new ArrayList<>();
            }
            list[u].add(v);
        }
        return list;
    }

    public static void main(String[] args) {
        CycleInDirectedGraph ob = new CycleInDirectedGraph();
        int[][] edges =  {   {1, 2 },
                {1,2 },
                {4,1 },
                {2,4 },
                {3,4 },
                {5,2 },
                {1,3} };
        System.out.println(ob.solve(6, edges)); // 1
    }
}
