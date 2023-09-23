package dp;

public class WaysToDecode {
    public int numDecodings(String A) {
        int n = A.length();
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {

        }
        return 0;
    }

    boolean isValid(int n) {
        return n >= 1 && n <= 26;
    }

    public static void main(String[] args) {
        WaysToDecode ob = new WaysToDecode();
        System.out.println(ob.numDecodings("12345")); //3
    }
}
