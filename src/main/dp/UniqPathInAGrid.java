package dp;

/**
 * Problem Description
 * Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
 * At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
 *
 * Now consider if some obstacles are added to the grids.
 * Return the total number unique paths from (1, 1) to (n, m).
 *
 * Note: An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
 *
 *
 * Problem Constraints
 * 1 <= n, m <= 100
 * A[i][j] = 0 or 1
 *
 *
 * Input Format
 * Firts and only argument A is a 2D array of size n * m.
 *
 *
 * Output Format
 * Return an integer denoting the number of unique paths from (1, 1) to (n, m).
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *         [0, 0, 0]
 *         [0, 1, 0]
 *         [0, 0, 0]
 *      ]
 * Input 2:
 *
 *  A = [
 *         [0, 0, 0]
 *         [1, 1, 1]
 *         [0, 0, 0]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}
 *  So, the total number of unique paths is 2.
 * Explanation 2:
 *
 *  It is not possible to reach (n, m) from (1, 1). So, ans is 0.
 */
public class UniqPathInAGrid {
    int ans = 0;
    public int uniquePathsWithObstacles(int[][] arr) {
        ans = 0;
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] dp = new boolean[n][m];
        countUniqPath(arr, dp, 0, 0, n, m);
        return ans;
    }

    void countUniqPath(int[][] arr, boolean[][] dp, int i, int j, int n, int m) {
        // reached n, m? increase count;
        if(i == n-1 && j == m-1 && arr[i][j] != 1) {
            ans++;
            return;
        }
        // if outside bounds, return
        if(i >= n || j >= m) {
            return;
        }

        if(arr[i][j] != 1 && !dp[i][j]) {
            // mark current cell visited
            dp[i][j] = true;
            // check right path
            countUniqPath(arr, dp, i, j+1, n, m);
            // check down path
            countUniqPath(arr, dp, i+1, j, n, m);
            // restore dp[i][j]
            dp[i][j] = false;
        }
    }

    public static void main(String[] args) {
        UniqPathInAGrid ob = new UniqPathInAGrid();
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(ob.uniquePathsWithObstacles(arr)); // 2
        arr = new int[][]{
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
        };
        System.out.println(ob.uniquePathsWithObstacles(arr)); // 0
    }
}
