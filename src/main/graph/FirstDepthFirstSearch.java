package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem Description
 * You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
 *
 * Given 2 towns find whether you can reach the first town from the second without repeating any edge.
 *
 * B C : query to find whether B is reachable from C.
 *
 * Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
 *
 * There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
 *
 * NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 *
 *
 *
 * Input Format
 * First argument is vector A
 *
 * Second argument is integer B
 *
 * Third argument is integer C
 *
 *
 *
 * Output Format
 * Return 1 if reachable, 0 otherwise.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 1, 2]
 *  B = 1
 *  C = 2
 * Input 2:
 *
 *  A = [1, 1, 2]
 *  B = 2
 *  C = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
 * Explanation 2:
 *
 *  Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
 */
public class FirstDepthFirstSearch {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(int[] A, final int B, final int C) {
        int n = A.length;
        int[][] edges = buildEdges(A, n);
        return bfs(n, edges, C, B) ? 1 : 0;
    }

    boolean bfs(int n, int[][] edges, int src, int dest) {
        List<Integer>[] graph = buildGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(src);
        visited[src] = true;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> neighbours = graph[curr];
            if(neighbours != null) {
                for(int x : neighbours) {
                    if(!visited[x]) {
                        queue.add(x);
                        visited[x] = true;
                    }
                }
            }
        }
        return visited[dest];
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

    int[][] buildEdges(int[] arr, int n) {
        int[][] edges = new int[n][2];
        for(int i=1; i<n; i++) {
            edges[i][0] = arr[i];
            edges[i][1] = i+1;
        }
        return edges;
    }

    public static void main(String[] args) {
        FirstDepthFirstSearch ob = new FirstDepthFirstSearch();
        System.out.println(ob.solve(new int[]{1, 1, 2}, 1, 2)); // 0
        System.out.println(ob.solve(new int[]{1, 1, 2}, 2, 1)); // 1
    }
}
