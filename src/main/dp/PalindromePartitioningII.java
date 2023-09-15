package dp;

/**
 * Problem Description
 * Given a string A, partition A such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of A.
 *
 *
 *
 * Problem Constraints
 * 1 <= length(A) <= 501
 *
 *
 *
 * Input Format
 * The first and the only argument contains the string A.
 *
 *
 *
 * Output Format
 * Return an integer, representing the minimum cuts needed.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "aba"
 * Input 2:
 *
 *  A = "aab"
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  "aba" is already a palindrome, so no cuts are needed.
 * Explanation 2:
 *
 *  Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {
    /*
    TC: O(n^2)
    SC: O(n^2)
    */
    public int minCut(String A) {
        int n = A.length();
        boolean[][] pal = fillPalindromeDP(A.toCharArray());
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<n; i++) {
            int ans = Integer.MAX_VALUE;
            if(pal[0][i]) {
                ans = 0;
            } else {
                for(int j=i; j>=0; j--) {
                    if(pal[j][i]) {
                        ans = Math.min(ans, dp[j-1]+1);
                    }
                }
            }
            dp[i] = ans;
        }
        return dp[n-1];
    }

    boolean[][] fillPalindromeDP(char[] arr) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][n];
        // fill the dp array for each subsequence of len 1 to n
        for(int len=1; len<=n; len++) {
            int i = 0;
            int j = len - 1;
            while(j < n) {
                if(len == 1) {
                    dp[i][j] = true;
                } else if(len == 2) {
                    dp[i][j] = arr[i] == arr[j];
                } else {
                    if(arr[i] == arr[j]) {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                i++;
                j++;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        PalindromePartitioningII ob = new PalindromePartitioningII();
        System.out.println(ob.minCut("abcbabaaabaa")); // 2
    }
}
