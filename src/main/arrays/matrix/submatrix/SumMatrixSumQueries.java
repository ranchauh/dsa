package arrays.matrix.submatrix;

import java.util.Arrays;

public class SumMatrixSumQueries {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int n = B.length;
        long mod = (long) (1e9 + 7); // 1000000007L
        long[][] prefixSum = matrixPrefixSum(A);
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            int b = B[i] - 1; // 1 based index
            int c = C[i] - 1;
            int d = D[i] - 1;
            int e = E[i] - 1;

            if(b == 0 && c == 0) {
                result[i] = (int) (prefixSum[d][e] % mod);
            } else if(b == 0) {
                result[i] = (int) ((prefixSum[d][e] - prefixSum[d][c-1]) % mod);
            } else if(c == 0) {
                result[i] = (int) ((prefixSum[d][e] - prefixSum[b-1][e]) % mod);
            }else {
                result[i] = (int) ((prefixSum[d][e] - prefixSum[b-1][e] - prefixSum[d][c-1] + prefixSum[b-1][c-1] % mod) % mod);
            }
            result[i] = (int) ((result[i] + mod) % mod);
        }
        return result;

    }

    private long[][] matrixPrefixSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        long mod = (long) (1e9 + 7);
        long[][] prefix = new long[n][m];
        // Row wise prefix sum
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(j == 0) {
                    prefix[i][j] = A[i][j] % mod;
                } else {
                    prefix[i][j] = (prefix[i][j-1] % mod + A[i][j] % mod) % mod;
                }
                prefix[i][j] = (prefix[i][j] + mod) % mod;
            }
        }
        // Col wise prefix sum
        for(int j=0; j<m; j++) {
            for(int i=1; i<n; i++) {
                prefix[i][j] = (prefix[i-1][j] % mod + prefix[i][j] % mod) % mod;
                prefix[i][j] = (prefix[i][j] + mod) % mod;
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        SumMatrixSumQueries obj = new SumMatrixSumQueries();
        int[][] A = new int[][]
                {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
                };
        int[] B = new int[] { 1, 2};
        int[] C = new int[] { 1, 2};
        int[] D = new int[] { 2, 3};
        int[] E = new int[] { 2, 3};
        System.out.println(Arrays.toString(obj.solve(A, B, C, D, E)));

    }
}
