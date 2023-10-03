package graph;
import java.util.*;

/**
 *Problem Description
 * A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.
 *
 * Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country, u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.
 *
 * Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.
 *
 * NOTE: All cities can be visited from any city.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 * 1 <= B[i][0], B[i][1] <= N
 *
 *
 *
 * Input Format
 * First argument is an integer A denoting the number of cities, N.
 *
 * Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum number of roads king can construct.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3
 *  B = [
 *        [1, 2]
 *        [1, 3]
 *      ]
 * Input 2:
 *
 *  A = 5
 *  B = [
 *        [1, 3]
 *        [1, 4]
 *        [3, 2]
 *        [3, 5]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can't construct any new roads such that the country remains bipartite.
 * Explanation 2:
 *
 *  We can add two roads between cities (4, 2) and (4, 5).
 */
public class ConstructRoads {
    public int solve(int n, int[][] edges) {
        // build graph
        List<Integer>[] graph = buildGraph(n, edges);
        // find start node having some children
        // check bipartite
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
        color[1] = 0;
        int res = isBipartite(1, n, graph, color);
        if(res == 0) {
            return 0;
        }
        return maxRoads(n, color);
    }

    int maxRoads(int n, int[] color) {
        long mod = 1000000007;
        long c1 = 0, c2 = 0;
        for(int i=1; i<color.length; i++) {
            if(color[i] == 0) {
                c1++;
            } else {
                c2++;
            }
        }
        c1 %= mod;
        c2 %= mod;
        return (int) ((c1 * c2) % mod) - (n - 1);
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
        List<Integer>[] graph = new ArrayList[n+1];
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
        ConstructRoads ob = new ConstructRoads();
        System.out.println(ob.solve(2, new int[][]{{2, 1}})); // 0
    }
}
