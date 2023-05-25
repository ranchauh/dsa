package arrays.matrix.submatrix;

import java.math.BigDecimal;
import java.util.Arrays;

public class SumMatrixSumQueriesBigDecimal {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int n = B.length;
        BigDecimal mod = BigDecimal.valueOf(1e9 + 7);
        BigDecimal[][] prefixSum = matrixPrefixSum(A);
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            int b = B[i] - 1; // 1 based index
            int c = C[i] - 1;
            int d = D[i] - 1;
            int e = E[i] - 1;

            if(b == 0 && c == 0) {
                result[i] = prefixSum[d][e].remainder(mod).intValue();
            } else if(b == 0) {
                result[i] = prefixSum[d][e].subtract(prefixSum[d][c-1]).remainder(mod).intValue();
            } else if(c == 0) {
                result[i] = prefixSum[d][e].subtract(prefixSum[b-1][e]).remainder(mod).intValue();
            }else {
                result[i] = prefixSum[d][e].subtract(prefixSum[b-1][e]).subtract(prefixSum[d][c-1]).add(prefixSum[b-1][c-1]).remainder(mod).intValue();
            }
        }
        return result;

    }

    private BigDecimal[][] matrixPrefixSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        BigDecimal mod = BigDecimal.valueOf(1e9 + 7);
        BigDecimal[][] prefix = new BigDecimal[n][m];
        // Row wise prefix sum
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                BigDecimal val = BigDecimal.valueOf(A[i][j]);
                if(j == 0) {
                    prefix[i][j] = val.remainder(mod);
                } else {
                    prefix[i][j] = prefix[i][j-1].remainder(mod).add(val.remainder(mod));
                }
            }
        }
        // Col wise prefix sum
        for(int j=0; j<m; j++) {
            for(int i=1; i<n; i++) {
                prefix[i][j] = prefix[i-1][j].remainder(mod).add(prefix[i][j].remainder(mod));
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        SumMatrixSumQueriesBigDecimal obj = new SumMatrixSumQueriesBigDecimal();
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
