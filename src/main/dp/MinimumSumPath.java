package dp;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 */
public class MinimumSumPath {

    public int minPathSumTabulation(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if(i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if(j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[n-1][m-1];
    }

    public int minPathSumMemoization(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minPathSum(grid, n, m, 0, 0, dp);
    }

    int minPathSum(int[][] grid, int n, int m, int r, int c, int[][] dp) {
        if(r == n-1 && c == m-1) {
            return grid[r][c];
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        int res = grid[r][c];
        if(r == n-1) {
            res  += minPathSum(grid, n, m, r, c+1, dp);
        } else if(c == m-1) {
            res += minPathSum(grid, n, m, r+1, c, dp);
        } else {
            int down = minPathSum(grid, n, m, r+1, c, dp);
            int right = minPathSum(grid, n, m, r, c+1, dp);
            res += Math.min(down, right);
        }
        dp[r][c] = res;
        return res;
    }
}
