package dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem Description
 * Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * Find the maximum number of envelopes you can put one inside other.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000
 * 1 <= A[i][0], A[i][1] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum number of envelopes you can put one inside other.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *          [5, 4]
 *          [6, 4]
 *          [6, 7]
 *          [2, 3]
 *      ]
 * Input 2:
 *
 *  A = [     '
 *          [8, 9]
 *          [8, 18]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Step 1: put [2, 3] inside [5, 4]
 *  Step 2: put [5, 4] inside [6, 7]
 *  3 envelopes can be put one inside other.
 * Explanation 2:
 *
 *  No envelopes can be put inside any other so answer is 1.
 */
public class RussianDollEnvelops {
    static class Pair {
        int height;
        int width;
        Pair(int h, int w) {
            this.height = h;
            this.width = w;
        }
    }
    public int solve(int[][] A) {
        int n = A.length;
        Pair[] envs = new Pair[n];
        for(int i=0; i<n; i++) {
            envs[i] = new Pair(A[i][0], A[i][1]);
        }
        // sort envs based on its height
        Arrays.sort(envs, Comparator.comparingInt(p -> p.height));

        // apply LIS
        // dp[i]: longest increasing subsequence from (0-i) ending with element i
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1; i<n; i++) {
            // for the single elemnt LIS is alwasy 1;
            dp[i] = 1;
            // compare ith number with all the previous elements and if its greater, add 1 to dp[j]
            for(int j=0; j<i; j++) {
                if(envs[i].height > envs[j].height && envs[i].width > envs[j].width) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // max of dp is the answer.
        int max = dp[0];
        for(int i=1; i<n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] A = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}};
        RussianDollEnvelops ob = new RussianDollEnvelops();
        System.out.println(ob.solve(A)); // 3

        int[][] B = {
                {8, 9},
                {8, 18}};
        System.out.println(ob.solve(B)); // 1
    }
}
