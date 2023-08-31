package dp;
/**
 * Problem Description
 * Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 *
 *
 * Input Format
 * First and only argument is an integer A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum count.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 6
 * Input 2:
 *
 *  A = 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 *  Minimum count of numbers, sum of whose squares is 6 is 3.
 * Explanation 2:
 *
 *  We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
 */
public class MinimumSquares {
    // DP
    // TC: O(n * sqrt(n))
    // SC: O(n)
    public int countMinSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<n+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=2; i<=n; i++) {
            for(int x = 1; x*x <= i; x++) {
                dp[i] = Math.min(dp[i], dp[i - x*x] + 1);
            };
        }
        return dp[n];
    }

    // Brut force
    public int countMinSquaresBrutForce(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(n < 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++) {
            ans = Math.min(ans, countMinSquares(n - i*i));
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        MinimumSquares ob = new MinimumSquares();
        System.out.println(ob.countMinSquares(12)); //3
    }
}
