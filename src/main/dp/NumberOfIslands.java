package dp;

/**
 * Given a matrix of integers with 1 or 0 in each cell where 1 -> land and  0 -> water.
 * A set of connected 1's form an island. Find the number of islands in the matrix.
 */
public class NumberOfIslands {

    // 8 directions: left-up, up, up-right, right, left, right-down, down, left-down
    int[] dr = {-1, -1, -1, 0,  0, 1, 1, 1};
    int[] dc = {-1,  0,  1, 1, -1, 1, 0, -1};

    int r, c;

    /**
     * TC: O(N*M)
     * SC: O(N*M) -> stack space
     */
    int numberOfIslands(int[][] matrix) {
        this.r = matrix.length;
        this.c = matrix[0].length;
        boolean[][] visited = new boolean[r][c];
        int ans = 0;
        // apply DFS. If the cell is not visited and contains 1, increase ans and run DFS to find out connected
        // 1's in all 8 directions.
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(!visited[i][j] && matrix[i][j] == 1) {
                    ans++;
                    dfs(matrix, i, j, visited);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for(int k=0; k<dr.length; k++) {
            int x = i + dr[k];
            int y = j + dc[k];
            if(isValidIndex(x,y) && !visited[x][y] && matrix[x][y] == 1) {
                dfs(matrix, x, y, visited);
            }
        }
    }

    private boolean isValidIndex(int x, int y) {
        return x >=0 && x < this.r && y >= 0 && y < this.c;
    }

    public static void main(String[] args) {
        NumberOfIslands ob = new NumberOfIslands();
        int[][] matrix = {
                {1,1,0,0,0},
                {0,1,0,1,0},
                {1,0,0,1,1},
                {0,0,0,0,0},
                {1,0,1,1,1}
        };
        System.out.println(ob.numberOfIslands(matrix)); // 4
    }
}
