package arrays.matrix;

public class MaximumSubmatrixSum {
    public long solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        long[][] prefixSum = matrixPrefixSum(A);
        long maxSum = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // In the submatrix with maximum sum the BR corner will always be
                // the last cell (n-1, m-1) because the matrix is sorted row-wise and col-wise
                long sum = calculateSubmatrixSum(prefixSum, i, j, n-1, m-1);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    /**
     (a, b) : Top left corner
     (c, d) : Bottom right corner
     */
    private long calculateSubmatrixSum(long[][] prefixSum, int a, int b, int c, int d) {
        long sum = 0;
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

    private long[][] matrixPrefixSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        long[][] prefixSum = new long[n][m];

        // Row wise prefixSum
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(j == 0) {
                    prefixSum[i][j] = A[i][j];
                } else {
                    prefixSum[i][j] = A[i][j] + prefixSum[i][j-1];
                }
            }
        }

        // Col wise sum
        for(int j=0; j<m; j++) {
            // The first (0th) row remains the same in col wise sum
            for(int i=1; i<n; i++) {
                prefixSum[i][j] = prefixSum[i][j] + prefixSum[i-1][j];
            }
        }
        return prefixSum;
    }

    public static void main(String[] args) {
        MaximumSubmatrixSum obj = new MaximumSubmatrixSum();
        int[][] M = new int[][] {
                {8, 8},
                {11, 97}
        };
        System.out.println(obj.solve(M)); // 124
    }
}
