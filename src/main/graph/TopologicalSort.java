package graph;

import java.util.*;

/**
 * Problem Description
 * Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 *
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 *
 * Return the topological ordering of the graph and if it doesn't exist then return an empty array.
 *
 * If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
 *
 * Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
 *
 * NOTE:
 *
 * There are no self-loops in the graph.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 *
 *
 * Problem Constraints
 * 2 <= A <= 104
 *
 * 1 <= M <= min(100000,A*(A-1))
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
 * Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 6
 *  B = [  [6, 3]
 *         [6, 1]
 *         [5, 1]
 *         [5, 2]
 *         [3, 4]
 *         [4, 2] ]
 * Input 2:
 *
 *  A = 3
 *  B = [  [1, 2]
 *         [2, 3]
 *         [3, 1] ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [5, 6, 1, 3, 4, 2]
 * Output 2:
 *
 *  []
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
 * Explanation 2:
 *
 *  The given graph contain cycle so topological ordering not possible we will return empty array.
 */
public class TopologicalSort {
    /*
     TC: O(n+e)
     SC: O(n)
    */
    public int[] solve(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n+1];
        int[] indegree = new int[n+1];
        // construct the graph and fill indegree array for each vertex v
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(graph[u] == null) {
                graph[u] = new ArrayList();
            }
            graph[u].add(v);
            indegree[v]++;
        }
        // create a queue and insert all the elements having indegree 0 to start with
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=1; i<=n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        // continue until queue is empty and fill the result array
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            list.add(curr);
            List<Integer> neighbours = graph[curr] ;
            if(neighbours != null) {
                for(int x : neighbours) {
                    indegree[x]--;
                    if(indegree[x] == 0) {
                        queue.add(x);
                    }
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TopologicalSort ob = new TopologicalSort();
        int[][] edges = {  {6, 3},
                {6, 1},
                {5, 1},
                {5, 2},
                {3, 4},
                {4, 2}, };
        System.out.println(Arrays.toString(ob.solve(6, edges))); // [5, 6, 1, 3, 4, 2]
        edges = new int[][] {  {1,2},
                {2,3},
                {3,1}};
       System.out.println(Arrays.toString(ob.solve(3, edges))); // []
        edges = new int[][] {{1,4},
                {1,2},
                {4,2},
                {4,3},
                {3,2},
                {5,2},
                {3,5},
                {8,2},
                {8,6}};
        System.out.println(Arrays.toString(ob.solve(8, edges))); // 1 4 3 5 7 8 2 6
    }
}
