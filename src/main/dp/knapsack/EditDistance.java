package dp.knapsack;

/**
 * Problem Description
 * Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Problem Constraints
 * 1 <= length(A), length(B) <= 450
 *
 *
 *
 * Input Format
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 *
 *
 *
 * Output Format
 * Return an integer, representing the minimum number of steps required.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abad"
 *  B = "abac"
 * Input 2:
 *
 *  A = "Anshuman"
 *  B = "Antihuman
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Exlanation 1:
 *
 *  A = "abad" and B = "abac"
 *  After applying operation: Replace d with c. We get A = B.
 *
 * Explanation 2:
 *
 *  A = "Anshuman" and B = "Antihuman"
 *  After applying operations: Replace s with t and insert i before h. We get A = B.
 */
public class EditDistance {
    public int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();
        // dp[i][j]: min number of steps required to convert string a of len i to string b of length j
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(i==0 && j==0) {
                    dp[i][j] = 0;
                } else if(i == 0) {
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else {
                    if(A.charAt(i-1) == B.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        int insert = dp[i][j-1];
                        int delete = dp[i-1][j];
                        int replace = dp[i-1][j-1];
                        dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                    }
                }
            }
        }
        return dp[n][m];
    }

    public int minDistanceRec(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                dp[i][j] = -1;
            }
        }
        return minDistanceMemoized(A, B, n, m, dp);
    }

    int minDistanceMemoized(String a, String b, int n, int m, int[][] dp) {
        if(n == 0 && m == 0) {
            return 0;
        }
        if(n == 0) {
            return m;
        }
        if(m == 0) {
            return n;
        }
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        if(a.charAt(n-1) == b.charAt(m-1)) {
            dp[n][m] = minDistanceMemoized(a, b, n-1, m-1, dp);
        } else {
            int insert = minDistanceMemoized(a, b, n, m-1, dp);
            int delete = minDistanceMemoized(a, b, n-1, m, dp);
            int replace = minDistanceMemoized(a, b, n-1, m-1, dp);
            dp[n][m] = 1 + Math.min(insert, Math.min(delete, replace));
        }
        return dp[n][m];
    }

    int minDistanceRecursive(String a, String b, int n, int m) {
        if(n == 0 && m == 0) {
            return 0;
        }
        if(n == 0) {
            return m;
        }
        if(m == 0) {
            return n;
        }
        if(a.charAt(n-1) == b.charAt(m-1)) {
            return  minDistanceRecursive(a, b, n-1, m-1);
        } else {
            int insert = minDistanceRecursive(a, b, n, m-1);
            int delete = minDistanceRecursive(a, b, n-1, m);
            int replace = minDistanceRecursive(a, b, n-1, m-1);
            return Math.min(insert, Math.min(delete, replace)) + 1;
        }
    }

    public static void main(String[] args) {
        EditDistance ob = new EditDistance();
        System.out.println(ob.minDistance("Anshuman", "Antihuman"));  //2
        System.out.println(ob.minDistanceRec("Anshuman", "Antihuman"));  //2
    }
}
