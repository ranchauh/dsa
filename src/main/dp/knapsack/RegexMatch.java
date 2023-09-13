package dp.knapsack;

import java.util.Arrays;

public class RegexMatch {
    public int isMatchTabulative(final String s, final String p) {
        int n = s.length();
        int m = p.length();
        int i=0, j=0, idx_s=-1, idx_p=-1;
        // empty string can match with empty or one or more * pattern.
        if(n == 0) {
            String pp = p.replaceAll("\\*","");
            return pp.length() == 0 ? 1 : 0;
        }
        // aaxybc
        // aa*bc
        while(i < n) {
            // when chars at both i and j index match or p[j] = ?, increment i and j
            // this condition matches ith and jth chars post * encountered as well.
            if(j < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if(j < m && p.charAt(j) == '*') {
                // keep the index of i and j when p[i] = *
                idx_s = i;
                idx_p = j;
                j++;
            } else if(idx_p != -1) {
                // when the chars don't match and we encountered * before,
                // this means that * has convered till current ith index.
                // We also need to check if * has matched 0 char sequence. for that reset i and j
                i = idx_s + 1;
                j = idx_p + 1;
                idx_s++;
            } else {
                return 0;
            }
        }
        while(j < m && p.charAt(j) == '*') {
            j++;
        }
        if(j == m) {
            return 1;
        }
        return 0;
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isMatchRec(final String s, final String p) {
        int n = s.length();
        int m = p.length();
        // dp[i][j]: does string of length i match with patter of length j
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return isMatchMemoized(s, p, n, m, dp);
    }

    int isMatchMemoized(String s, String p, int n, int m, int[][] dp) {
        if(n == 0 && m == 0) {
            return 1;
        }
        if(m == 0) {
            return 0;
        }
        if(n == 0) {
            for(int i=0; i<m; i++) {
                if(p.charAt(i) != '*') {
                    return 0;
                }
            }
            return 1;
        }
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        if(s.charAt(n-1) == p.charAt(m-1) || p.charAt(m-1) == '?') {
            dp[n][m] = isMatchMemoized(s, p, n-1, m-1, dp);
        } else if(p.charAt(m-1) == '*') {
            // check for 0 chars
            int zero = isMatchMemoized(s, p, n, m-1,dp);
            // check for 1 or more chars
            int more = isMatchMemoized(s, p, n-1, m,dp);
            dp[n][m] = (zero | more);
        } else {
            dp[n][m] = 0;
        }
        return dp[n][m];
    }

    int isMatchRecursive(String s, String p, int n, int m) {
        if(n == 0 && m == 0) {
            return 0;
        }
        if(m == 0) {
            return 0;
        }
        if(n == 0) {
            for(int i=0; i<m; i++) {
                if(p.charAt(i) != '*') {
                    return 0;
                }
            }
            return 1;
        }
        if(s.charAt(n-1) == p.charAt(m-1) || p.charAt(m-1) == '?') {
            return isMatchRecursive(s, p, n-1, m-1);
        } else if(p.charAt(m-1) == '*') {
            // check for 0 chars
            int zero = isMatchRecursive(s, p, n, m-1);
            // check for 1 or chars
            int more = isMatchRecursive(s, p, n-1, m);

            return zero | more;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        RegexMatch ob = new RegexMatch();
        System.out.println(ob.isMatchRec("aaa", "a*")); // 1
        System.out.println(ob.isMatchTabulative("aaaxybc", "a*bc")); // 1
    }
}
