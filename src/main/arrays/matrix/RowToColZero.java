package arrays.matrix;

/**
 * Problem Description
 * You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.
 *
 *
 *
 * Problem Constraints
 * 1 <= A.size() <= 103
 *
 * 1 <= A[i].size() <= 103
 *
 * 0 <= A[i][j] <= 103
 *
 *
 *
 * Input Format
 * First argument is a vector of vector of integers.(2D matrix).
 *
 *
 *
 * Output Format
 * Return a vector of vector after doing required operations.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * [1,2,3,4]
 * [5,6,7,0]
 * [9,2,0,4]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1,2,0,0]
 * [0,0,0,0]
 * [0,0,0,0]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
 */
public class RowToColZero {
    public int[][] solve(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        int[][] C = new int[n][m];
        // As the values in the input array are positive number, we can initialize the output matrix with -1
        // so that we can avoid overriding values when set a col/row with zero.
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                C[i][j] = -1;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(A[i][j] == 0) {
                    int lastCol=j;
                    for(int k=0; k<m; k++) {
                        // make row zero until another 0 is found on the same row.
                        if(k > j && A[i][k] == 0) {
                            // save the col-1 num where 0 found, so that j loop can process after it.
                            lastCol = k-1;
                            break;
                        }
                        lastCol++;
                        C[i][k] = 0;
                    }
                    for(int k=0; k<n; k++) {
                        // make column zero until another 0 is found on the same col.
                        if(k > i && A[k][j] == 0) {
                            break;
                        }
                        C[k][j] = 0;
                    }
                    // If there is only one 0 in the row, lastCol will have larger value than m to cause the j loop terminate.
                    // But if there are multiple 0's in the row, lastCol will point to a col before the next 0. This will help
                    // j loop process the next 0's in the rows.
                    j = lastCol;
                } else if(C[i][j] == -1) {
                    C[i][j] = A[i][j];
                }
            }
        }
        return C;
    }
}
