package dp;

import java.util.Arrays;

public class AliceAndStairs {
    public int solve(int A, String B) {
        int[] dp = new int[A];
        Arrays.fill(dp, -2);
        return maxChoc(0, B, dp);
    }

    int maxChoc(int index, String str, int[] dp) {
        if(index > str.length() - 1) {
            return -1;
        } else if(index == str.length() -1) {
            return 0;
        } else if(str.charAt(index) == 'B') {
            return -1;
        } else {
            if(dp[index] != -2) {
                return dp[index];
            }
            int oneStep = maxChoc(index+1, str, dp);
            int threeSteps = maxChoc(index+3, str, dp);
            if(oneStep == -1 && threeSteps == -1) {
                dp[index] = -1;
                return -1;
            }
            int currChoc = str.charAt(index) == 'C' ? 1 : 0;
            dp[index] = currChoc + Math.max(oneStep, threeSteps);
            return dp[index];
        }
    }

    public static void main(String[] args) {
        AliceAndStairs ob = new AliceAndStairs();
        System.out.println(ob.solve(3, "ECE")); // 1
        System.out.println(ob.solve(5, "ECBCE")); // 1
    }
}
