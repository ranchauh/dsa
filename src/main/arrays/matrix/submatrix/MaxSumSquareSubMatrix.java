package arrays.matrix.submatrix;

/**
 * Problem Description
 * Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1, such that the sum of all the elements in the submatrix is maximum.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 103.
 *
 * 1 <= B <= N
 *
 * -102 <= A[i][j] <= 102.
 *
 *
 *
 * Input Format
 * First arguement is an 2D integer matrix A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the maximum sum of submatrix of size B x B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *         [1, 1, 1, 1, 1]
 *         [2, 2, 2, 2, 2]
 *         [3, 8, 6, 7, 3]
 *         [4, 4, 4, 4, 4]
 *         [5, 5, 5, 5, 5]
 *      ]
 *  B = 3
 * Input 2:
 *
 *  A = [
 *         [2, 2]
 *         [2, 2]
 *     ]
 *  B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  48
 * Output 2:
 *
 *  8
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *     Maximum sum 3 x 3 matrix is
 *     8 6 7
 *     4 4 4
 *     5 5 5
 *     Sum = 48
 * Explanation 2:
 *
 *  Maximum sum 2 x 2 matrix is
 *   2 2
 *   2 2
 *   Sum = 8
 */
public class MaxSumSquareSubMatrix {
    public int solve(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        int maxSum = Integer.MIN_VALUE;
        int[][] prefixSum = matrixPrefixSum(A);
        for(int a=0; a<=n-B; a++) {
            for(int b=0; b<=m-B; b++) {
                int c = a + B - 1;
                int d = b + B - 1;
                int sum = subMatrixSum(prefixSum, a, b, c, d);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    private int subMatrixSum(int[][] prefixSum, int a, int b, int c, int d) {
        int sum = 0;
        if(a+b == 0) { // TL corner is the first index of matrix
            sum = prefixSum[c][d];
        } else if(a == 0) { // TL corner is in the first row
            sum = prefixSum[c][d] - prefixSum[c][b-1];
        } else if(b == 0) { // TL corner is in the first col
            sum = prefixSum[c][d] - prefixSum[a-1][d];
        } else {
            sum = prefixSum[c][d] - prefixSum[c][b-1] - prefixSum[a-1][d] + prefixSum[a-1][b-1];
        }
        return sum;
    }

    private int[][] matrixPrefixSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] prefix = new int[n][m];
        // Row wise sum
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(j == 0) {
                    prefix[i][j] = A[i][j];
                } else {
                    prefix[i][j] = prefix[i][j-1] + A[i][j];
                }
            }
        }

        // Col wise sum
        for(int j=0; j<m; j++) {
            for(int i=1; i<n; i++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j];
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        MaxSumSquareSubMatrix ob = new MaxSumSquareSubMatrix();
        int[][] arr = {
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5},
        };
        System.out.println(ob.solve(arr, 3)); // 48

        arr = new int[][]{
                {-50, 73, -34, -56, -41, -8, -61, -47, -76, 54, 10, 45, -51, 86, 13, -26, -78, 68, -82, 87},
                {5, 58, 91, -98, -75, -23, -86, 14, -76, 34, -26, 72, 59, -67, -30, -13, -3, 18, 77, 73},
                {-30, 63, -32, 92, 85, 2, -20, -87, -73, -98, -1, 27, -75, 43, 24, -77, 72, -39, 81, -97},
                {-68, 5, 93, 25, -69, -8, 42, -78, -14, -36, 0, 87, 60, -87, 74, -30, 70, -65, -67, 11},
                {60, -4, -33, -15, 50, 40, -6, -5, -76, -81, 25, 76, -6, -42, 2, 71, -34, -22, 93, -49},
                {-16, -82, -36, 19, 52, -100, -13, -40, 26, -90, 57, 70, 15, 76, -73, -57, 58, 64, 9, -18},
                {-14, 65, -13, 77, -26, -75, -73, -71, 28, -77, 20, 2, 62, 23, 96, 37, -39, 95, 25, -36},
                {-40, -98, 16, -70, 26, -89, 71, -89, 47, 53, 20, 90, 24, 88, 63, 40, -49, -38, -71, 0},
                {13, 58, 78, 65, -93, -23, -100, -42, -61, 3, 60, 57, 24, -23, 8, 13, -13, -99, -50, -40},
                {-72, 93, 84, -95, 40, 11, 4, -65, 56, -28, 50, -77, -15, 56, -84, -74, 57, 26, 57, 37},
                {-29, -31, 61, -4, -78, -83, 12, 17, -4, 85, -59, -77, 29, -71, 65, 59, 32, -4, -45, -47},
                {62, 84, 34, -46, 72, -43, 69, 32, 63, -93, -17, 11, -65, -33, -52, -25, 38, -77, 42, 54},
                {11, 41, 75, -41, -75, -79, -30, -74, 34, -95, 83, -50, 98, -21, 1, 93, 34, -63, 34, 56},
                {93, 76, 5, 62, 48, -19, 0, -87, -59, -45, -45, 42, -38, -89, -23, -76, -22, 52, -57, -4},
                {-27, -60, 13, -25, -28, -82, -90, -83, 32, 12, -5, 69, -69, -60, -12, -15, -10, -3, 89, 90},
                {45, 53, 14, -49, 40, -56, -42, 35, 59, 92, -95, -36, 81, 3, -71, 75, -92, -8, 97, 49},
                {56, 61, -73, -33, 41, 29, -60, -87, 74, -99, -23, -85, -17, -87, 92, -76, -99, 92, 59, -30},
                {-72, -73, -16, -25, 86, -2, 70, -13, -53, -96, 3, -79, -37, 6, 63, -90, 71, -11, -60, 64},
                {42, -81, 13, 91, 4, -82, -68, 50, -95, 75, 39, 3, -78, -2, -53, 84, -52, 71, -36, 13},
                {-25, 45, 12, 46, -22, 69, -38, 19, 85, -11, 44, -35, 40, -55, 8, 18, -30, -99, 23, 32}
        };
        System.out.println(ob.solve(arr, 13)); //-27
    }
}
