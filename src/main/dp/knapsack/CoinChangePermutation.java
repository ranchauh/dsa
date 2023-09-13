package dp.knapsack;

public class CoinChangePermutation {
    /*
    TC: O(n*k)
    SC: O(k)
     */
    public int coinChangePermutaion(int[] arr, int k) {
        int mod = 1000007;
        int n = arr.length;
        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i=0; i<=k; i++) {
            for(int j=0; j<n; j++) {
                if((i-arr[i]) >= 0 && (i-arr[j]) < k) {
                    dp[i] = dp[i] + dp[i-arr[j]];
                    dp[i] %= mod;
                }
            }
        }
        return dp[k] % mod;
    }
}
