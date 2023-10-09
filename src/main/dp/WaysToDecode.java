package dp;

import java.util.Arrays;

/**
 * Problem Description
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.
 *
 *
 *
 * Problem Constraints
 * 1 <= length(A) <= 105
 *
 *
 *
 * Input Format
 * The first and the only argument is a string A.
 *
 *
 *
 * Output Format
 * Return an integer, representing the number of ways to decode the string modulo 109 + 7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "12"
 * Input 2:
 *
 *  A = "8"
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 *  The number of ways decoding "12" is 2.
 * Explanation 2:
 *
 *  Given encoded message "8", it could be decoded as only "H" (8).
 *  The number of ways decoding "8" is 1.
 */
public class WaysToDecode {
    private int[] dp;
    private int N;
    private String A;

    public int numDecodingsTabular(String A) {
        N = A.length();

        if (N == 0 || N == 1)
            return 1;

        dp = new int[N];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<N; i++) {
            if(A.charAt(i-2) > '0') {
                dp[i] = dp[i-1];
            }
            if (isValidTwoDigits(i-2)) {
                dp[i] += dp[i-2] + 1;
            }
        }
        return dp[N-1];
    }

    public int numDecodings(String A) {

        N = A.length();

        if (A == null)
            return 0;

        dp = new int[N];
        Arrays.fill(dp, -1);
        this.A = A;

        return rec(N - 1);
    }

    private int rec(int index) {

        if (index < 0)
            return 1;

        if (dp[index] != -1)
            return dp[index] % 1000000007;

        int ways = 0;

        if (A.charAt(index) > '0') {
            ways = rec(index - 1);
            ways %= 1000000007;
        }

        if (isValidTwoDigits(index)) {
            ways += rec(index - 2);
            ways %= 1000000007;
        }

        return dp[index] = ways;
    }



    private boolean isValidTwoDigits(int index) {
        return index > 0 && (A.charAt(index - 1) == '1' || A.charAt(index - 1) == '2' && A.charAt(index) < '7');
    }

    public static void main(String[] args) {
        WaysToDecode ob = new WaysToDecode();
        System.out.println("------ Recursive -------");
        System.out.println(ob.numDecodings("")); //1
        System.out.println(ob.numDecodings("1")); //1
        System.out.println(ob.numDecodings("10")); //2
        System.out.println(ob.numDecodings("12345")); //3
        System.out.println(ob.numDecodings("5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190")); //0
        System.out.println("------ Tabular -------");
        System.out.println(ob.numDecodingsTabular("")); //1
        System.out.println(ob.numDecodingsTabular("1")); //1
        System.out.println(ob.numDecodingsTabular("10")); //2
        System.out.println(ob.numDecodingsTabular("12345")); //3
        System.out.println(ob.numDecodingsTabular("5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190")); //0
    }
}
