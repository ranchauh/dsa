package strings;

import java.util.Arrays;

/**
 * Problem Description
 * Given two string A and B of length N and M respectively consisting of lowercase letters. Find the number of occurrences of B in A.
 *
 *
 * Problem Constraints
 * 1 <= M <= N <= 105
 *
 *
 *
 * Input Format
 * Two argument A and B are strings
 *
 *
 * Output Format
 * Return an integer denoting the number of occurrences of B in A
 *
 *
 * Example Input
 * Input 1:
 * A = "acbac"
 * B = "ac"
 * Input 2:
 * A = "aaaa"
 * B = "aa"
 *
 *
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 3
 *
 *
 * Example Explanation
 * For Input 1:
 * The string "ac" occurs twice in "acbac".
 * For Input 2:
 * The string "aa" occurs thrice in "aaaa".
 */
public class RabinKarpNumberOfOccurrences {
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        int prime = 31;
        int mod = (int)(1e9 + 7);

        long[] p_pow = new long[n];
        p_pow[0] = 1;
        for (int i = 1; i < n; i++) {
            p_pow[i] = (p_pow[i - 1] * prime) % mod;
        }

        long[] h = new long[n + 1];
        for (int i = 0; i < n; i++){
            h[i + 1] = (h[i] + (A.charAt(i) - 'a' + 1) * p_pow[i]) % mod;
        }

        long hash_B = 0;
        for (int i = 0; i < m; i++) {
            hash_B = (hash_B + (B.charAt(i) - 'a' + 1) * p_pow[i]) % mod;
        }

        int ans = 0;
        for (int i = 0; i + m - 1 < n; i++) {
            long curr_hash = (h[i + m] + mod - h[i]) % mod;
            if (curr_hash == hash_B * p_pow[i] % mod)
                ans += 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        RabinKarpNumberOfOccurrences ob = new RabinKarpNumberOfOccurrences();
        System.out.println(ob.solve("ccbcdaacc", "ac")); // 1
        System.out.println(ob.solve("acbdccdbcadaba", "a")); // 4
    }
}
