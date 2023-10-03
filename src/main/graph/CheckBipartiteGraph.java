package graph;

import java.util.*;

/**
 * Problem Description
 * Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].
 *
 * Find whether the given graph is bipartite or not.
 *
 * A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B
 *
 * Note:
 *
 * There are no self-loops in the graph.
 *
 * No multiple edges between two pair of vertices.
 *
 * The graph may or may not be connected.
 *
 * Nodes are Numbered from 0 to A-1.
 *
 * Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 100000
 *
 * 1 <= M <= min(A*(A-1)/2,200000)
 *
 * 0 <= B[i][0],B[i][1] < A
 *
 *
 *
 * Input Format
 * The first argument given is an integer A.
 *
 * The second argument given is the matrix B.
 *
 *
 *
 * Output Format
 * Return 1 if the given graph is bipartide else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 2
 * B = [ [0, 1] ]
 * Input 2:
 *
 * A = 3
 * B = [ [0, 1], [0, 2], [1, 2] ]
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Put 0 and 1 into 2 different subsets.
 * Explanation 2:
 *
 *
 * It is impossible to break the graph down to make two different subsets for bipartite matching
 */
public class CheckBipartiteGraph {
    public int solve(int n, int[][] edges) {
        // build graph
        List<Integer>[] graph = buildGraph(n, edges);
        // find start node having some children
        // check bipartite
        int[] color = new int[n];
        Arrays.fill(color, -1);
        // for unconnected graph, lets check for every node if that colored or not.
        for(int i=0; i<n; i++) {
            if(color[i] == -1) {
                color[i] = 0;
                if(isBipartite(i, n, graph, color) == 0) {
                    return 0;
                }
            }

        }
        return 1;
    }

    int isBipartite(int src, int n, List<Integer>[] graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()) {
            int u = queue.poll();
            if(graph[u] == null) {
                continue;
            }
            for(int v : graph[u]) {
                if(color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                } else if(color[v] == color[u]) {
                    return 0;
                }
            }
        }
        return 1;
    }

    List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(graph[u] == null) {
                graph[u] = new ArrayList<>();
            }
            graph[u].add(v);
            if(graph[v] == null) {
                graph[v] = new ArrayList();
            }
            graph[v].add(u);
        }
        return graph;
    }

    public static void main(String[] args) {
        CheckBipartiteGraph ob = new CheckBipartiteGraph();
        System.out.println(ob.solve(2, new int[][]{{0, 1}})); // 1
        System.out.println(ob.solve(3, new int[][]{{0, 1}, {0, 2}, {1, 2}})); // 0
    }
}
