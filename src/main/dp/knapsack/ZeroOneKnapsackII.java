package dp.knapsack;

import java.util.Arrays;

/**
 * Problem Description
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 *
 * Also given an integer C which represents knapsack capacity.
 *
 * Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 *
 * NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 500
 *
 * 1 <= C, B[i] <= 106
 *
 * 1 <= A[i] <= 50
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N denoting the values on N items.
 *
 * Second argument is an integer array B of size N denoting the weights on N items.
 *
 * Third argument is an integer C denoting the knapsack capacity.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [6, 10, 12]
 *  B = [10, 20, 30]
 *  C = 50
 * Input 2:
 *
 *  A = [1, 3, 2, 4]
 *  B = [12, 13, 15, 19]
 *  C = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  22
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Taking items with weight 20 and 30 will give us the maximum value i.e 10 + 12 = 22
 * Explanation 2:
 *
 *  Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
 */
public class ZeroOneKnapsackII {
    /*
    Since constraints for value k is high (10^6), we will end up creating N*C matrix which will be
    500 * 10^6 => 5 * 10^8 a huge value. To optimize the space complexity,
    we can model this problem in terms of weight such that we calculate the minimum weight required to get a certain value
    using dp, and finally we choose the max value which is <= k.
    */
    public int solve(int[] val, int[] wt, int k) {
        int n = wt.length;
        // model the problem in terms of weight. So instead of taking k as the 2nd dimention of dp array,
        // lets calculate maxValue possible as m to use in dp array
        int m = 0;
        for(int v : val) {
            m += v;
        }
        // dp[i][j] = Min weight required to obtain value j with i items.
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                int include=Integer.MAX_VALUE, exclude;
                if(j == 0) {
                    dp[i][j] = 0;
                } else if(i == 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else {
                    exclude = dp[i-1][j];
                    if((j-val[i-1]) >= 0 && dp[i-1][j-val[i-1]] != Integer.MAX_VALUE) {
                        include = wt[i-1] + dp[i-1][j-val[i-1]];
                    }
                    dp[i][j] = Math.min(exclude, include);
                }
            }
        }
        int ans = 0;
        for(int v=m; v>=0; v--) {
            if(dp[n][v] <= k) {
                ans = v;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ZeroOneKnapsackII ob = new ZeroOneKnapsackII();
        int[] val = {1,4,2,3,5};
        int[] wt  = {6,3,2,4,2};
        int k = 6;
        System.out.println(ob.solve(val, wt, 6)); // 8
    }
}
