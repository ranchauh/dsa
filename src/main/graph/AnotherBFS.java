package graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem Description
 *
 * Given a weighted undirected graph having A nodes, a source node C and destination node D.
 *
 * Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.
 *
 * You are expected to do it in Time Complexity of O(A + M).
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
 *
 * 1 <= A <= 105
 *
 * 0 <= B[i][0], B[i][1] < A
 *
 * 1 <= B[i][2] <= 2
 *
 * 0 <= C < A
 *
 * 0 <= D < A
 *
 *
 *
 * Input Format
 *
 * The first argument given is an integer A, representing the number of nodes.
 *
 * The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].
 *
 * The third argument given is an integer C, representing the source node.
 *
 * The fourth argument is an integer D, representing the destination node.
 *
 * Note: B[i][2] will be either 1 or 2.
 *
 *
 *
 * Output Format
 *
 * Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *
 * A = 6
 * B = [   [2, 5, 1]
 *         [1, 3, 1]
 *         [0, 5, 2]
 *         [0, 2, 2]
 *         [1, 4, 1]
 *         [0, 1, 1] ]
 * C = 3
 * D = 2
 * Input 2:
 *
 * A = 2
 * B = [   [0, 1, 1]
 *     ]
 * C = 0
 * D = 1
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * The path to be followed will be:
 *     3 -> 1 (Edge weight : 1)
 *     1 -> 0 (Edge weight : 1)
 *     0 -> 2 (Edge weight : 2)
 * Total length of path = 1 + 1 + 2 = 4.
 * Explanation 2:
 *
 *  Path will be 0-> 1.
 */
public class AnotherBFS {
    static class Pair {
        int n;
        int l;
        Pair(int n, int l) {
            this.n = n;
            this.l = l;
        }
    }
    public int solve(int n, int[][] edges, int x, int y) {
        int totalNodes = calculateTotalNodes(n, edges);
        List<Integer>[] graph = buildGraph(n, totalNodes, edges);
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[totalNodes+1];
        queue.add(new Pair(x, 0));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            if(pair.n == y) {
                return pair.l;
            }
            visited[pair.n] = true;
            if(graph[pair.n] != null) {
                for(int c : graph[pair.n]) {
                    if(!visited[c]) {
                        queue.add(new Pair(c, pair.l+1));
                        visited[c] = true;
                    }
                }
            }
        }
        return -1;
    }

    int calculateTotalNodes(int n, int[][] edges) {
        for (int[] edge : edges) {
            if (edge[2] == 2) {
                n++;
            }
        }
        return n;
    }

    List<Integer>[] buildGraph(int n, int k, int[][] edges) {
        List<Integer>[] graph = new ArrayList[k+1];
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            if(graph[u] == null) {
                graph[u] = new ArrayList<>();
            }
            if(graph[v] == null) {
                graph[v] = new ArrayList<>();
            }
            if(w == 1) {
                graph[u].add(v);
                graph[v].add(u);
            } else {
                n++;
                graph[n] = new ArrayList<>();
                graph[u].add(n);
                graph[v].add(n);
                graph[n].add(u);
                graph[n].add(v);
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        AnotherBFS ob = new AnotherBFS();
        int[][] edges = {
                {2,5,1},
                {1,3,1},
                {0,5,2},
                {0,2,2},
                {1,4,1},
                {0,1,1}
        };
        System.out.println(ob.solve(6, edges, 3, 2)); // 4
    }
}
