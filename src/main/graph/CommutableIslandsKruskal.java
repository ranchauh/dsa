package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Problem Description
 * There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
 *
 * We need to find bridges with minimal cost such that all islands are connected.
 *
 * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
 *
 *
 *
 * Problem Constraints
 * 1 <= A, M <= 6*104
 *
 * 1 <= B[i][0], B[i][1] <= A
 *
 * 1 <= B[i][2] <= 103
 *
 *
 *
 * Input Format
 * The first argument contains an integer, A, representing the number of islands.
 *
 * The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
 *
 *
 *
 * Output Format
 * Return an integer representing the minimal cost required.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 4
 *  B = [  [1, 2, 1]
 *         [2, 3, 4]
 *         [1, 4, 3]
 *         [4, 3, 2]
 *         [1, 3, 10]  ]
 * Input 2:
 *
 *  A = 4
 *  B = [  [1, 2, 1]
 *         [2, 3, 2]
 *         [3, 4, 4]
 *         [1, 4, 3]   ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
 * Explanation 2:
 *
 *  We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
 */
public class CommutableIslandsKruskal {
    static class Pair {
        int n;
        int w;
        Pair(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    public int solve(int n, int[][] edges) {
        // build graph
        List<Pair>[] graph = new ArrayList[n+1];
        int[] parent = new int[n+1];
        for(int i=0; i<=n; i++) {
            parent[i] = i;
        }
        // sort edges based on their weight
        sortEdges(edges);
        int ans = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int rootU = getRoot(u, parent);
            int rootV = getRoot(v, parent);
            if (rootU != rootV) {
                union(u, v, parent);
                if (graph[u] == null) {
                    graph[u] = new ArrayList<>();
                }
                graph[u].add(new Pair(v, w));
                if (graph[v] == null) {
                    graph[v] = new ArrayList<>();
                }
                graph[v].add(new Pair(u, w));
                ans += w;
            }
        }
        return ans;
    }

    void sortEdges(int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
    }

    void union(int u, int v, int[] parent) {
        int rootU = getRoot(u, parent);
        int rootV = getRoot(v, parent);
        if(rootU == rootV) {
            return;
        }
        if(rootU < rootV) {
            parent[rootV] = rootU;
        } else {
            parent[rootU] = rootV;
        }
    }

    int getRoot(int x, int[] parent) {
        if(x == parent[x]) {
            return x;
        }
        int r = getRoot(parent[x], parent);
        parent[x] = r;
        return r;
    }

    List<Pair>[] buildGraph(int n, int[][] edges) {
        List<Pair>[] graph = new ArrayList[n+1];
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            if(graph[u] == null) {
                graph[u] = new ArrayList<>();
            }
            graph[u].add(new Pair(v, w));
            if(graph[v] == null) {
                graph[v] = new ArrayList<>();
            }
            graph[v].add(new Pair(u, w));
        }
        return graph;
    }

    public static void main(String[] args) {
        CommutableIslandsKruskal ob = new CommutableIslandsKruskal();
        int A = 4;
        int[][] B = {{1, 2, 1},
                {2, 3, 4},
                {1, 4, 3},
                {4, 3, 2},
                {1, 3, 10}};
        System.out.println(ob.solve(A, B)); // 6
    }
}
