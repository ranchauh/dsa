package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).
 *
 * If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
 *
 * Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.
 *
 * If there is no possible path from vertex i to vertex j , B[i][j] = -1
 *
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 200
 * -1 <= A[i][j] <= 1000000
 *
 *
 * Input Format
 * The first and only argument given is the integer matrix A.
 *
 *
 * Output Format
 * Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j
 * If there is no possible path from vertex i to vertex j, B[i][j] = -1.
 *
 *
 * Example Input
 * A = [ [0 , 50 , 39]
 *           [-1 , 0 , 1]
 *           [-1 , 10 , 0] ]
 *
 *
 * Example Output
 * [ [0 , 49 , 39 ]
 *    [-1 , 0 , -1 ]
 *    [-1 , 10 , 0 ] ]
 *
 *
 * Example Explanation
 * Shortest Path from 1 to 2 would be 1 ---> 3 ---> 2 and not directly from 1 to 2,
 * All remaining distances remains same.
 */
public class FloyedWarshall {
    public List<List<Integer>> solve(List<List<Integer>> A) {
        int n = A.size();
        for (List<Integer> integers : A) {
            for (int j = 0; j < n; j++) {
                if (integers.get(j) == -1) {
                    integers.set(j, 100000005);
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (List<Integer> integers : A) {
                for (int j = 0; j < n; j++) {
                    int x = integers.get(k) + A.get(k).get(j);
                    int y = integers.get(j);
                    if (x < y) {
                        integers.set(j, x);
                    }
                }
            }
        }
        for (List<Integer> integers : A) {
            for (int j = 0; j < n; j++) {
                if (integers.get(j) == 100000005) {
                    integers.set(j, -1);
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        FloyedWarshall floyedWarshall = new FloyedWarshall();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(0 , 50 , 39));
        list.add(Arrays.asList(-1 , 0 , 1));
        list.add(Arrays.asList(-1 , 10 , 0));
        System.out.println(floyedWarshall.solve(list)); // [[0, 49, 39], [-1, 0, 1], [-1, 10, 0]]
    }
}
