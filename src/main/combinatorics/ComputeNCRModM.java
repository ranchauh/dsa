package combinatorics;

/**
 * Problem Description
 * Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
 *
 * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 *
 *
 *
 * Problem Constraints
 * 1 <= A * B <= 106
 *
 * 1 <= B <= A
 *
 * 1 <= C <= 106
 *
 *
 *
 * Input Format
 * The first argument given is integer A ( = n).
 * The second argument given is integer B ( = r).
 * The third argument given is integer C ( = m).
 *
 *
 * Output Format
 * Return the value of nCr % m.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 *  B = 2
 *  C = 13
 * Input 2:
 *
 *  A = 6
 *  B = 2
 *  C = 13
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The value of 5C2 % 11 is 10.
 * Explanation 2:
 *
 *  The value of 6C2 % 13 is 2.
 */
public class ComputeNCRModM {
    /**
     * Hint:
     * Suppose we calculate nCr by calculating the factorial of each number and then doing n! / (r! * (n-r)!) % m. This will not work as the factorial can be very large and will cause overflow.
     * As we know nCr = n-1Cr-1 + n-1Cr.
     * So we will use the Dynamic Programming approach and calculate the value of nCr.
     */
    public int solve(int A, int B, int C) {
        long[][] dp = new long[A+1][B+1];
        for(int i=0; i<=A; i++) {
            dp[i][0] = 1;
        }
        long result = ncrModPDP(A, B, C, dp);
        return (int) result % C;
    }

    long ncrModPDP(int n, int r, int p, long[][] dp) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=Math.min(i, r); j++) {
                if(i+j == 2) { //1c1
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % p;
                }
            }
        }
        return dp[n][r] % p;
    }

    private void printDP(long[][] dp) {
        int m = dp[0].length;
        for (long[] longs : dp) {
            for (int j = 0; j <m; j++) {
                System.out.print(longs[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ComputeNCRModM ob = new ComputeNCRModM();
        System.out.println(ob.solve(5, 2, 13)); //10
    }
}
