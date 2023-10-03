package dp.knapsack;

/**
 * Problem Description
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 *
 * Also given an integer C which represents knapsack capacity.
 *
 * Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 *
 * NOTE:
 *
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 *
 *
 * Problem Constraints
 * 1 <= N <= 103
 *
 * 1 <= C <= 103
 *
 * 1 <= A[i], B[i] <= 103
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
 *  A = [60, 100, 120]
 *  B = [10, 20, 30]
 *  C = 50
 * Input 2:
 *
 *  A = [10, 20, 30, 40]
 *  B = [12, 13, 15, 19]
 *  C = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  220
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
 * Explanation 2:
 *
 *  Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
 */
public class ZeroOneKnapsack {
    /*
    TC: O(n*k)
    SC: O(n*k)
     */
    public int solve(int[] val, int[] wt, int k) {
        int n = wt.length;
        int[][] dp = new int[n+1][k+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=k; j++) {
                int include=0, exclude=0;
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    exclude = dp[i-1][j];
                    if((j-wt[i-1]) >= 0) {
                        include = dp[i-1][j-wt[i-1]] + val[i-1];
                    }
                    dp[i][j] = Math.max(exclude, include);
                }
            }
        }
        //return ZeroOneKnapsackMemoized(wt, val, k, n-1, dp);
        return dp[n][k];
    }

    public int solveSpaceOptimized(int[] val, int[] wt, int k) {
        int n = wt.length;
        int[] prev = new int[k+1];
        for(int i=1; i<=n; i++) {
            int[] curr = new int[k+1];
            for(int j=1; j<=k; j++) {
                int ex = 0, in = 0;
                ex = prev[j];
                if((j-wt[i-1]) >= 0) {
                    in = prev[j-wt[i-1]] + val[i-1];
                }
                curr[j] = Math.max(ex, in);
            }
            prev = curr;
        }
        return prev[k];
    }

    int ZeroOneKnapsackMemoized(int[] wt, int[] val, int k, int end, int[][] dp) {
        if(end == 0) {
            if(wt[end] <= k) {
                return val[end];
            }
            return 0;
        }
        if(dp[end][k] != -1) {
            return dp[end][k];
        }
        // include item at end th index
        int include = -1;
        if(k-wt[end] >= 0) {
            include = ZeroOneKnapsackMemoized(wt, val, k-wt[end], end-1, dp) + val[end];
        }
        // exclude itesm at end the index
        int exclude = ZeroOneKnapsackMemoized(wt, val, k, end-1, dp);
        dp[end][k] = Math.max(include, exclude);
        return dp[end][k];
    }

    int ZeroOneKnapsackRecursive(int[] wt, int[] val, int k, int end) {
        if(end == 0) {
            if(wt[end] <= k) {
                return val[end];
            }
            return 0;
        }
        // include item at end th index
        int include = ZeroOneKnapsackRecursive(wt, val, k-wt[end], end-1) + val[end];
        // exclude itesm at end the index
        int exclude = ZeroOneKnapsackRecursive(wt, val, k, end-1);
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        ZeroOneKnapsack ob = new ZeroOneKnapsack();
        System.out.println(ob.solve(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50)); // 220
        System.out.println(ob.solve(new int[]{10, 20, 30, 40}, new int[]{12, 13, 15, 19}, 50)); // 90
        System.out.println(ob.solveSpaceOptimized(new int[]{5,12,8,1}, new int[]{4,8,5,3}, 10)); // 13
    }
}
