package dp;

/**
 * Problem Description
 * Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
 *
 * You need to return the length of such longest common subsequence.
 *
 *
 *
 * Problem Constraints
 * 1 <= Length of A, B <= 1005
 *
 *
 *
 * Input Format
 * First argument is a string A.
 * Second argument is a string B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the length of the longest common subsequence.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abbcdgf"
 *  B = "bbadcgf"
 * Input 2:
 *
 *  A = "aaaaaa"
 *  B = "ababab"
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The longest common subsequence is "bbcgf", which has a length of 5.
 * Explanation 2:
 *
 *  The longest common subsequence is "aaa", which has a length of 3.
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequenceTabulative(String A, String B) {
        int n = A.length();
        int m = B.length();
        // dp[i][j]: length of longest common subsequence for string A of length i and B of length j
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else {
                    if(A.charAt(i-1) == B.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }
        }
        return dp[n][m];
    }

    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                dp[i][j] = -1;
            }
        }
        return longestCommonSubsequenceMemoized(A.toCharArray(), B.toCharArray(),n, m, dp);
    }

    int longestCommonSubsequenceMemoized(char[] a, char[] b, int n, int m, int dp[][]) {
        if(n == 0 || m == 0) {
            return 0;
        }
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        if(a[n-1] == b[m-1]) {
            dp[n][m] = 1 + longestCommonSubsequenceMemoized(a, b, n-1, m-1, dp);
        } else {
            int pos1 = longestCommonSubsequenceMemoized(a, b, n, m-1, dp);
            int pos2 = longestCommonSubsequenceMemoized(a, b, n-1, m, dp);
            dp[n][m] = Math.max(pos1, pos2);
        }
        return dp[n][m];
    }

    int longestCommonSubsequenceRecursive(char[] a, char[] b, int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }
        if(a[n-1] == b[m-1]) {
            return 1 + longestCommonSubsequenceRecursive(a, b, n-1, m-1);
        } else {
            int pos1 = longestCommonSubsequenceRecursive(a, b, n, m-1);
            int pos2 = longestCommonSubsequenceRecursive(a, b, n-1, m);
            return Math.max(pos1, pos2);
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequence ob = new LongestCommonSubsequence();
        System.out.println(ob.solve("abbcdgf","bbadcgf")); //5
        System.out.println(ob.longestCommonSubsequenceTabulative("abbcdgf","bbadcgf")); //5
    }
}
