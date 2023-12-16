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
        int[] arr = {8,2,4,6,5,8};
        LongestIncreasingSubsequence ob = new LongestIncreasingSubsequence();
        System.out.println(ob.lis(arr)); // 4
    }
}
