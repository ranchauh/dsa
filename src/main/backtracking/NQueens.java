package backtracking;

import java.util.ArrayList;

/**
 * Problem Description
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer A, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
 *
 *
 * Problem Constraints
 * 1 <= A <= 10
 *
 *
 *
 * Input Format
 * First argument is an integer n denoting the size of chessboard
 *
 *
 *
 * Output Format
 * Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 4
 * Input 2:
 *
 * A = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Output 1:
 *
 * [
 *  [Q]
 * ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * There exist only two distinct solutions to the 4-queens puzzle:
 * Explanation 1:
 *
 * There exist only one distinct solutions to the 1-queens puzzle:
 */
public class NQueens {
    boolean[] col, diag1, diag2;
    ArrayList<ArrayList<String>> result;
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 2 || n == 3) {
            return result;
        }
        col = new boolean[n];
        diag1 = new boolean[2*n - 1];
        diag2 = new boolean[2*n - 1];
        int[][] mat = new int[n][n];
        nQueens(mat, 0, n);
        return result;
    }

    void nQueens(int[][] mat, int r, int n) {
        if(r == n) {
            copyIntoResult(mat);
            return;
        }
        for(int c = 0; c<n; c++) {
            boolean isSafe = !col[c] && !diag1[r-c+n-1] && !diag2[r+c];
            if(isSafe) {
                col[c] = true;
                diag1[r-c+n-1] = true;
                diag2[r+c] = true;
                mat[r][c] = 1;
                nQueens(mat, r+1, n);
                mat[r][c] = 0;
                col[c] = false;
                diag1[r-c+n-1] = false;
                diag2[r+c] = false;
            }
        }
    }

    void copyIntoResult(int[][] mat) {
        int n = mat.length;
        ArrayList<String> res = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringBuilder str = new StringBuilder();
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 1) {
                    str.append("Q");
                } else {
                    str.append(".");
                }
            }
            res.add(str.toString());
        }
        result.add(res);
    }

    public static void main(String[] args) {
        NQueens ob = new NQueens();
        System.out.println(ob.solveNQueens(1)); //[[Q]]
        System.out.println(ob.solveNQueens(2)); // []
        System.out.println(ob.solveNQueens(3)); // []
        System.out.println(ob.solveNQueens(4)); // [[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]
        /*
        [
            [.Q..,
             ...Q,
             Q...,
             ..Q.],
            [..Q.,
              Q...,
              ...Q,
              .Q..]
          ]
         */
    }
}
