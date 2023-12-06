package dp;

/**
 * Given a two-dimensional binary matrix of size n * m, find the largest square submatrix with all 1s.
 *
 * Example
 * {
 * "n": 3,
 * "m": 3,
 * "mat": [
 * [1, 0, 0],
 * [0, 1, 1],
 * [0, 1, 1]
 * ]
 * }
 * Output:
 *
 * 2
 * 2x2 submatrix at right-bottom has all 1s. That’s the largest one. Length of its side is 2.
 */
public class MaximumSquareSizeMatrix {
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];
        // fill first row
        for(int i=0; i<m; i++) {
            dp[0][i] = A[0][i];
        }
        // fill first col
        for(int i=0; i<n; i++) {
            dp[i][0] = A[i][0];
        }

        // fill rest of the cells
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(A[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]));
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        // find the max ans
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
