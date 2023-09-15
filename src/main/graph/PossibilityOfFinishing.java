package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem Description
 * There are a total of A courses you have to take, labeled from 1 to A.
 *
 * Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
 *
 * So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 6*104
 *
 * 1 <= length(B) = length(C) <= 105
 *
 * 1 <= B[i], C[i] <= A
 *
 *
 *
 * Input Format
 * The first argument of input contains an integer A, representing the number of courses.
 *
 * The second argument of input contains an integer array, B.
 *
 * The third argument of input contains an integer array, C.
 *
 *
 *
 * Output Format
 * Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3
 *  B = [1, 2]
 *  C = [2, 3]
 * Input 2:
 *
 *  A = 2
 *  B = [1, 2]
 *  C = [2, 1]
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
 *  It is possible to complete the courses in the following order:
 *     1 -> 2 -> 3
 * Explanation 2:
 *
 *  It is not possible to complete all the courses.
 */
public class PossibilityOfFinishing {
    public int solve(int n, int[] B, int[] C) {
        List<Integer>[] graph = new ArrayList[n+1];
        int[] indegree = new int[n+1];
        // construct the graph and fill indegree array for each vertex v
        for(int i=0; i<B.length; i++) {
            int u = B[i];
            int v = C[i];
            if(graph[u] == null) {
                graph[u] = new ArrayList();
            }
            graph[u].add(v);
            indegree[v]++;
        }
        // create a queue and insert all the elements having indegree 0 to start with
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        // continue until queue is empty
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> neibours = graph[curr] ;
            if(neibours != null) {
                //Collections.sort(neibours);
                for(int x : neibours) {
                    indegree[x]--;
                    if(indegree[x] == 0) {
                        queue.add(x);
                    }
                }
            }
        }
        // check if all the element in indegree has become 0;
        for(int x : indegree) {
            if(x != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        PossibilityOfFinishing ob = new PossibilityOfFinishing();
        System.out.println(ob.solve(3, new int[]{1,2}, new int[]{2,3})); // 1
        System.out.println(ob.solve(2, new int[]{1,2}, new int[]{2,1})); // 0
    }
}
