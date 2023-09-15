package dp;

/**
 * Given a string A consisting of lowercase English alphabets. Your task is to find how many substrings of A are palindrome.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even if they consist of same characters.
 *
 * Return the count of palindromic substrings.
 *
 * Note: A string is palindrome if it reads the same from backward and forward.
 *
 *
 * Input Format
 *
 * The only argument given is string A.
 * Output Format
 *
 * Return the count of palindromic substrings.
 * Constraints
 *
 * 1 <= length of the array <= 1000
 * For Example
 *
 * Input 1:
 *     A = "abab"
 * Output 1:
 *     6
 * Explanation 1:
 *     6 palindromic substrings are:
 *     "a", "aba", "b", "bab", "a" and "b".
 *
 * Input 2:
 *     A = "ababa"
 * Output 2:
 *     9
 * Explanation 9:
 *     9 palindromic substrings are:
 *     "a", "a", "a", "b", "b" , "aba" ,"bab", "aba" and "ababa".
 */
public class PalindromicSubstringCount {
    public int solve(String A) {
        // fill dp array for every length of substrings in the given string
        boolean[][] dp = fillPalindromeDP(A.toCharArray());
        int count = 0;
        int n = A.length();
        // count number of true present in dp
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
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
        PalindromicSubstringCount ob = new PalindromicSubstringCount();
        System.out.println(ob.solve("abab")); //6
    }
}
