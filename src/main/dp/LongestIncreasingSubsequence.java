package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lis(final int[] A) {
        int n = A.length;
        // dp[i]: longest increasing subsequence from (0-i) ending with element i
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1; i<n; i++) {
            // for the single elemnt LIS is alwasy 1;
            dp[i] = 1;
            // compare ith number with all the previous elements and if its greater, add 1 to dp[j]
            for(int j=0; j<i; j++) {
                if(A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // max of dp is the answer.
        int max = dp[0];
        for(int i=1; i<n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {69,54,19,51,16,54,64,89,72,40,31,43,1,11,82,65,75,67,25,98,31,77,55,88,85,76,35,101,44,74,29,94,72,39,20,24,23,66,16,95,5,17,54,89,93,10,7,88,68,10,11,22,25,50,18,59,79,87,7,49,26,96,27,19,67,35,50,10,6,48,38,28,66,94,60,27,76,4,43,66,14,8,78,72,21,56,34,90,89};
        LongestIncreasingSubsequence ob = new LongestIncreasingSubsequence();
        System.out.println(ob.lis(arr)); // 15
    }
}
