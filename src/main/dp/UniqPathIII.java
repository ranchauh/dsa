package dp;

/**
 * Q4. Unique Paths III
 * Solved
 * feature icon
 * Using hints is now penalty free
 * Use Hint
 * Problem Description
 * Given a matrix of integers A of size N x M . There are 4 types of squares in it:
 *
 * 1. 1 represents the starting square.  There is exactly one starting square.
 * 2. 2 represents the ending square.  There is exactly one ending square.
 * 3. 0 represents empty squares we can walk over.
 * 4. -1 represents obstacles that we cannot walk over.
 * Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 * 2 <= N * M <= 20
 * -1 <= A[i] <= 2
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [   [1, 0, 0, 0]
 *         [0, 0, 0, 0]
 *         [0, 0, 2, -1]   ]
 * Input 2:
 *
 * A = [   [0, 1]
 *         [2, 0]    ]
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Explanation 1:
 *
 * There are no such paths.
 */
public class UniqPathIII {
    int ans = 0;
    public int solve(int[][] A) {
        ans = 0;
        int n = A.length;
        int m = A[0].length;
        boolean[][] visited = new boolean[n][m];
        int i = -1,j = -1, count = 0;
        for(int x=0; x<n; x++) {
            for(int y=0; y<m; y++) {
                if(i == -1 && A[x][y] == 1) {
                    i = x;
                    j = y;
                }
                if(A[x][y] == 0 || A[x][y] == 1) {
                    count++;
                }
            }
        }
        uniqPath(A, visited, i, j, count);
        return ans;
    }

    void uniqPath(int[][] arr, boolean[][] visited, int i, int j, int count) {
        int n = arr.length - 1;
        int m = arr[0].length - 1;
        if(i < 0 || j < 0 || i > n || j > m || arr[i][j] == -1 || visited[i][j]) {
            return;
        }
        if(arr[i][j] == 2) {
            if(count == 0) {
                ans++;
            }
            return;
        }
        // mark visited
        visited[i][j] = true;
        // right
        uniqPath(arr, visited, i, j+1, count-1);
        // left
        uniqPath(arr, visited, i, j-1, count-1);
        // up
        uniqPath(arr, visited, i-1, j, count-1);
        // down
        uniqPath(arr, visited, i+1, j, count-1);

        // restore
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        UniqPathIII ob = new UniqPathIII();
        int[][] arr = {{1, 0, 0, 0},{0, 0, 0, 0},{0, 0, 2, -1}};
        System.out.println(ob.solve(arr)); // 2
        int[][] arr1 = {{0,1},{2,0}};
        System.out.println(ob.solve(arr1)); //0
    }
}
