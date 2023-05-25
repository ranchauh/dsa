package arrays.matrix.submatrix;

/**
 * Problem Description
 * Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
 * Problem Constraints
 * 1 <= N <=30
 * 0 <= A[i][j] <= 10

 * Input Format
 * Single argument representing a 2-D array A of size N x N.

 * Output Format
 * Return an integer denoting the sum of all possible submatrices in the given matrix.

 * Example Input
 * Input 1:
 * A = [ [1, 1]
 *       [1, 1] ]
 * Input 2:
 * A = [ [1, 2]
 *       [3, 4] ]
 *
 * Example Output
 * Output 1:
 * 16
 * Output 2:
 * 40
 */
public class SumOfAllSubmatrices {
    public static int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // x is the count of submatrices with Top Left (TL) indices < (i, j) where A[i][j] can be part of
                int x = (i+1) * (j+1);
                // y is the count of submatrices with Bottom right (BR) indices > (i, j) where A[i][j] can be part of
                int y = (n-i) * (m - j);
                // The total count will be multiplication  of x and y (not sum of it).
                int count = x * y;
                // A[i][j] will occur 'count' number of times in the overall sum.
                sum = sum + count * A[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1, 1},
                {1, 1}
        };
        System.out.println(solve(A)); // 16
        int[][] B = new int[][]{
                {1, 2},
                {3, 4}
        };
        System.out.println(solve(B)); // 40
    }
}
