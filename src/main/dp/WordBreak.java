package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string A and a dictionary of words B, determine if A can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Input Format:
 *
 * The first argument is a string, A.
 * The second argument is an array of strings, B.
 * Output Format:
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
 * Constraints:
 *
 * 1 <= len(A) <= 6500
 * 1 <= len(B) <= 10000
 * 1 <= len(B[i]) <= 20
 * Examples:
 *
 * Input 1:
 *     A = "myinterviewtrainer",
 *     B = ["trainer", "my", "interview"]
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".
 *
 * Input 2:
 *     A = "a"
 *     B = ["aaa"]
 *
 * Output 2:
 *     0
 *
 * Explanation 2:
 *     Return 0 ( corresponding to false ) because "a" cannot be segmented as "aaa".
 */
public class WordBreak {
    public int wordBreak(String A, String[] B) {
        Set<String> set = new HashSet<>();
        for(String s : B) {
            set.add(s);
        }
        int n = A.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return wordBreakMemoized(A, 0, set, dp);
    }

    int wordBreakMemoized(String word, int index, Set<String> set, int[] dp) {
        if(index == word.length()) {
            return 1;
        }
        if(dp[index] != -1) {
            return dp[index];
        }
        int result = 0;
        StringBuilder substring = new StringBuilder();
        for(int i=index; i<word.length(); i++) {
            substring.append(word.charAt(i));
            // as per problem constraint.
            if(substring.length()>20)
                break;
            if(set.contains(substring.toString())) {
                result |= wordBreakMemoized(word, i+1, set, dp);
            }
        }
        dp[index] = result;
        return dp[index];
    }

    int wordBreakDP(String word, Set<String> set) {
        int n = word.length();
        // dp[i]: whether substring from (0..i) can be segmented into dictionary words.
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                String w = word.substring(i-j, i);
                // as per problem constraint.
                if(w.length()>20)
                    break;
                if(set.contains(w) && dp[i-j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[n] ? 1 : 0;
    }

    int wordBreak(String word, Set<String> set) {
        if(word.length() == 0) {
            return 1;
        }
        for(int i=1; i<=word.length(); i++) {
            String prefix = word.substring(0,i);
            if(set.contains(prefix)) {
                int ans = wordBreak(word.substring(i), set);
                if(ans == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordBreak ob = new WordBreak();
        System.out.println(ob.wordBreak("myinterviewtrainer", new String[]{"trainer", "my", "interview"})); // 1
        System.out.println(ob.wordBreak("a", new String[]{"aaa"})); // 0
    }
}
