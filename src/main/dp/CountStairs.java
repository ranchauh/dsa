package dp;

/**
 * Problem Description
 * You are climbing a staircase and it takes A steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Return the number of distinct ways modulo 1000000007
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 *
 *
 * Input Format
 * The first and the only argument contains an integer A, the number of steps.
 *
 *
 *
 * Output Format
 * Return an integer, representing the number of ways to reach the top.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 * Input 2:
 *
 *  A = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Distinct ways to reach top: [1, 1], [2].
 * Explanation 2:
 *
 *  Distinct ways to reach top: [1 1 1], [1 2], [2 1].
 */
public class CountStairs {
    // Brut force
    public int climbStairsBrutForce(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        long x1 = climbStairsDPTabular(n-1);
        long x2 = climbStairsDPTabular(n-2);
        return (int) ((x1 + x2) % 1000000007);
    }


    long[] dp;
    long mod = 1000000007;
    public int climbStairsDPRecursive(int n) {
        dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<n+1; i++) {
            dp[i] = -1;
        }
        return (int) climbStairsDPMemoised(n);
    }

    // DB - memoised (iterative)
    long climbStairsDPTabular(int n) {
        dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }
        return (int) dp[n];
    }

    // DP - memoised (recursive)
    long climbStairsDPMemoised(int n) {
        if(dp[n] != -1) {
            return dp[n];
        }
        if(n == 0 || n == 1) {
            return 1;
        }
        long x1 = climbStairsDPMemoised(n-1);
        long x2 = climbStairsDPMemoised(n-2);
        dp[n] = ((x1 + x2) % mod);
        return dp[n];
    }

    long climbStairsSCO1(int n) {
        long a = 1;
        long b = 1;
        long c = a + b;
        for(int i=2; i<=n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        CountStairs ob = new CountStairs();
        System.out.println(ob.climbStairsBrutForce(4)); // 5
        System.out.println(ob.climbStairsDPTabular(4)); // 5
        System.out.println(ob.climbStairsDPRecursive(4)); // 5
        System.out.println(ob.climbStairsSCO1(4)); // 5
    }
}
