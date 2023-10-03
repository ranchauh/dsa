package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 *
 * Each cell can have three values:
 *
 * The value 0 representing an empty cell.
 *
 * The value 1 representing a fresh orange.
 *
 * The value 2 representing a rotten orange.
 *
 * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
 *
 * Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 1000
 *
 * 0 <= A[i][j] <= 2
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 *
 * If this is impossible, return -1 instead.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [   [2, 1, 1]
 *         [1, 1, 0]
 *         [0, 1, 1]   ]
 * Input 2:
 *
 *
 * A = [   [2, 1, 1]
 *         [0, 1, 1]
 *         [1, 0, 1]   ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Minute 0: [ [2, 1, 1]
 *             [1, 1, 0]
 *             [0, 1, 1] ]
 * Minute 1: [ [2, 2, 1]
 *             [2, 1, 0]
 *             [0, 1, 1] ]
 * Minute 2: [ [2, 2, 2]
 *             [2, 2, 0]
 *             [0, 1, 1] ]
 * Minute 3: [ [2, 2, 2]
 *             [2, 2, 0]
 *             [0, 2, 1] ]
 * Minute 4: [ [2, 2, 2]
 *             [2, 2, 0]
 *             [0, 2, 2] ]
 * At Minute 4, all the oranges are rotten.
 * Explanation 2:
 *
 * The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.
 */
public class RottenOranges {
    static class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int solve(int[][] A) {
        int[] row = {0,-1,0,1};
        int[] col = {-1,0,1,0};
        int r = A.length;
        int c = A[0].length;
        int days = 0;
        int ones = 0;
        Queue<Pair> queue = new LinkedList<>();
        // Add 2's to the queue and count 1's
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(A[i][j] == 2) {
                    queue.add(new Pair(i, j));
                } else if(A[i][j] == 1) {
                    ones++;
                }
            }
        }
        while(!queue.isEmpty()) {
            int n = queue.size();
            // iterate through all the 2's
            while(n > 0) {
                Pair p = queue.poll();
                assert p != null;
                int i = p.i;
                int j = p.j;
                // check left, top, right, bottom celss for 1
                for(int k=0; k<4; k++) {
                    int ni = i + row[k];
                    int nj = j + col[k];
                    if(ni < 0 || nj < 0 || ni >= r || nj >= c) {
                        continue;
                    }
                    if(A[ni][nj] == 1) {
                        queue.add(new Pair(ni, nj));
                        A[ni][nj] = 2;
                        ones--;
                    }
                }
                n--;
            }
            // if there were 1's found, they need another day to rotten
            if(!queue.isEmpty()) {
                days++;
            }
        }
        // if all 1's are over, return ans else it's not possible
        return ones == 0 ? days : -1;
    }

    public static void main(String[] args) {
        RottenOranges ob = new RottenOranges();
        int[][] A = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(ob.solve(A)); // 4
        int[][] B = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
        System.out.println(ob.solve(B)); // -1
    }
}
