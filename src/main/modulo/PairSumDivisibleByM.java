package modulo;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
 *
 * Since the answer may be large, return the answer modulo (109 + 7).
 *
 * Note: Ensure to handle integer overflow when performing the calculations.
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 106
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 2
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *  B = 28
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *  All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5).
 *  So total 4 pairs.
 * Explanation 2:
 *  There is only one pair which is divisible by 28 is (17, 11)
 */
public class PairSumDivisibleByM {
    public static int solve(int[] A, int B) {
        long mod = 1000000007L;
        Map<Integer, Long> frequency = new HashMap<>();
        for(int x : A) {
            int rem = x % B;
            frequency.put(rem, frequency.getOrDefault(rem, 0L) + 1L);
        }
        long freqZero = frequency.getOrDefault(0, 0L);
        long count =  (freqZero * (freqZero - 1)) / 2;
        int l=1, r=B-1;
        while(l < r) {
            count += frequency.getOrDefault(l, 0L) * frequency.getOrDefault(r, 0L);
            l++;
            r--;
        }
        if(l == r) {
            long freqMid = frequency.getOrDefault(l, 0L);
            count += (freqMid * (freqMid - 1)) / 2;
        }
        return (int) (count % mod);
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3, 4, 5}, 2)); // 4
        System.out.println(solve(new int[]{5, 17, 100, 11}, 28)); // 1
    }
}
