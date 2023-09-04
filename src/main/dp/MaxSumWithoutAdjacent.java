package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Problem Description
 * Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
 * However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
 *
 * Return the maximum possible sum.
 *
 * Note: You are allowed to choose more than 2 numbers from the grid.
 *
 *
 * Problem Constraints
 * 1 <= N <= 20000
 * 1 <= A[i] <= 2000
 *
 *
 * Input Format
 * The first and the only argument of input contains a 2d matrix, A.
 *
 *
 * Output Format
 * Return an integer, representing the maximum possible sum.
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *         [1]
 *         [2]
 *      ]
 * Input 2:
 *
 *  A = [
 *         [1, 2, 3, 4]
 *         [2, 3, 4, 5]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  8
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We will choose 2 (From 2nd row 1st column).
 * Explanation 2:
 *
 *  We will choose 3 (From 2nd row 2nd column) and 5 (From 2nd row 4th column).
 */
public class MaxSumWithoutAdjacent {

    public int adjacentTabulative(int[][] arr) {
        int n = arr[0].length;
        int[] maxArr = new int[n];
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            maxArr[i] = Math.max(arr[0][i], arr[1][i]);
        }
        if(n == 1) {
            return maxArr[0];
        }
        int maxSum = 0;
        dp[0] = maxArr[0];
        dp[1] = Math.max(dp[0], maxArr[1]);
        for(int i=2; i<n; i++) {
            int include = maxArr[i] + dp[i-2];
            int exclude = dp[i-1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[n-1];
    }

    public int adjacentRecursive(int[][] arr) {
        int n = arr[0].length;
        int[] maxArr = new int[n];
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            maxArr[i] = Math.max(arr[0][i], arr[1][i]);
            dp[i] = -1;
        }
        return maxSumMemoised(maxArr, n-1, dp);
    }

    int maxSumMemoised(int[] arr, int end, int[] dp) {
        if(end == 0) {
            dp[end] = arr[end];
            return arr[end];
        }
        if(end < 0) {
            return 0;
        }
        if(dp[end] != -1) {
            return dp[end];
        }
        int include = arr[end] + maxSumMemoised(arr, end - 2, dp);
        int exclude = maxSumMemoised(arr, end - 1, dp);
        dp[end] = Math.max(include, exclude);
        return dp[end];
    }

    int maxSumRecursive(int[] arr, int end) {
        if(end == 0) {
            return arr[end];
        }
        if(end < 0) {
            return 0;
        }

        int include = arr[end] + maxSumRecursive(arr, end - 2);
        int exclude = maxSumRecursive(arr, end - 1);
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        MaxSumWithoutAdjacent ob = new MaxSumWithoutAdjacent();
        int[][] arr = {{1, 2, 3, 4}, {2, 3, 4, 5}};
        System.out.println(ob.adjacentTabulative(arr)); // 8
        System.out.println(ob.adjacentRecursive(arr)); // 8
    }
}
