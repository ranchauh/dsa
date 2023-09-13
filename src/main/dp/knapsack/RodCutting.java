package dp.knapsack;

import java.util.Arrays;

/**
 * Problem Description
 * Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
 *
 * Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000
 *
 * 0 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 4, 1, 6, 2]
 * Input 2:
 *
 *  A = [1, 5, 2, 5, 6]
 *
 *
 * Example Output
 * Output 1:
 *
 *  15
 * Output 2:
 *
 *  11
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.
 * Explanation 2:
 *
 *  Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.
 */
public class RodCutting {
    /*
    TC: O(n^2)
    SC: O(n)
     */
    public int rodCuttingTabulative(int[] arr) {
        int n = arr.length;
        // dp[i]: max possible sell value for the rod of ith length with the given array.
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<=n; i++) {
            int max = Integer.MIN_VALUE;
            for(int j=1; j<=i; j++) {
                int val = arr[j-1] + dp[i-j];
                max = Math.max(max, val);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public int rodCuttingRec(int[] arr) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return rodCuttingMemoized(arr, arr.length, dp);
    }

    int rodCuttingMemoized(int[] arr, int i, int[] dp) {
        if(i == 0) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int max = Integer.MIN_VALUE;
        for(int j=0; j<i; j++) {
            int val = arr[i-j-1] + rodCuttingMemoized(arr, j, dp);
            max = Math.max(max, val);
        }
        dp[i] = max;
        return max;
    }

    int rodCuttingRecursive(int[] arr, int i) {
        if(i == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int j=0; j<i; j++) {
            int val = arr[i-j-1] + rodCuttingRecursive(arr, j);
            max = Math.max(max, val);
        }
        return max;
    }

    public static void main(String[] args) {
        RodCutting ob = new RodCutting();
        System.out.println(ob.rodCuttingRec(new int[]{3, 4, 1, 6, 2})); // 15
        System.out.println(ob.rodCuttingRec(new int[]{1, 5, 2, 5, 6})); // 11

        System.out.println(ob.rodCuttingTabulative(new int[]{3, 4, 1, 6, 2})); // 15
        System.out.println(ob.rodCuttingTabulative(new int[]{1, 5, 2, 5, 6})); // 11
    }
}

