package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem Description
 *
 * A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.
 *
 * Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.
 *
 * All students who know each other are placed in one batch.
 *
 * Strength of a batch is equal to sum of the strength of all the students in it.
 *
 * Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.
 *
 * Find the number of batches selected.
 *
 * NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 105
 *
 * 1 <= M <= 2*105
 *
 * 1 <= B[i] <= 104
 *
 * 1 <= C[i][0], C[i][1] <= A
 *
 * 1 <= D <= 109
 *
 *
 *
 * Input Format
 *
 * The first argument given is an integer A.
 * The second argument given is an integer array B.
 * The third argument given is a matrix C.
 * The fourth argument given is an integer D.
 *
 *
 *
 * Output Format
 *
 * Return the number of batches selected in IB.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 7
 *  B = [1, 6, 7, 2, 9, 4, 5]
 *  C = [  [1, 2]
 *         [2, 3]
 *        `[5, 6]
 *         [5, 7]  ]
 *  D = 12
 * Input 2:
 *
 *  A = 5
 *  B = [1, 2, 3, 4, 5]
 *  C = [  [1, 5]
 *         [2, 3]  ]
 *  D = 6
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Initial Batches :
 *     Batch 1 = {1, 2, 3} Batch Strength = 1 + 6 + 7 = 14
 *     Batch 2 = {4} Batch Strength = 2
 *     Batch 3 = {5, 6, 7} Batch Strength = 9 + 4 + 5 = 18
 *     Selected Batches are Batch 1 and Batch 2.
 * Explanation 2:
 *
 *  Initial Batches :
 *     Batch 1 = {1, 5} Batch Strength = 1 + 5  = 6
 *     Batch 2 = {2, 3} Batch Strength = 5
 *     Batch 3 = {4} Batch Strength = 4
 *     Selected Batch is only Batch 1.
 */
public class SelectBatches {
    public int solve(int n, int[] B, int[][] C, int D) {
        List<Integer>[] graph = buildGraph(n, C);
        boolean[] visited = new boolean[n+1];
        int count = 0;
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                int totalStrength = bfs(i, graph, visited, B);
                if(totalStrength >= D) {
                    count++;
                }
            }
        }
        return count;
    }

    int bfs(int n, List<Integer>[] graph, boolean[] visited, int[] strengths) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        int totalStrength = strengths[n-1];
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> nbrs = graph[cur];
            if(nbrs != null) {
                for(int v : nbrs) {
                    if(!visited[v]) {
                        queue.add(v);
                        visited[v] = true;
                        totalStrength += strengths[v-1];
                    }
                }
            }
        }
        return totalStrength;
    }

    List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(graph[u] == null) {
                graph[u] = new ArrayList();
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
        SelectBatches ob = new SelectBatches();
        int[] B = {1, 6, 7, 2, 9, 4, 5};
        int[][] C = {   {1, 2},
                        {2, 3},
                        {5, 6},
                        {5, 7},  };
        System.out.println(ob.solve(7, B, C, 12)); // 2

        int[] BB = {1, 2, 3, 4, 5};
        int[][] CC = {   {1, 5},
                {2, 3} };
        System.out.println(ob.solve(5, BB, CC, 6)); // 1
    }
}
