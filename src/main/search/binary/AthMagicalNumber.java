package search.binary;

/**
 * Problem Description
 * You are given three positive integers, A, B, and C.
 *
 * Any positive integer is magical if divisible by either B or C.
 *
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 *
 * Note: Ensure to prevent integer overflow while calculating.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 * 2 <= B, C <= 40000
 *
 *
 *
 * Input Format
 * The first argument given is an integer A.
 *
 * The second argument given is an integer B.
 *
 * The third argument given is an integer C.
 *
 *
 *
 * Output Format
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 1
 *  B = 2
 *  C = 3
 * Input 2:
 *
 *  A = 4
 *  B = 2
 *  C = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  1st magical number is 2.
 * Explanation 2:
 *
 *  First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */
public class AthMagicalNumber {
    private static final long MOD = 1000000007L;
    public int solve(int A, int B, int C) {
        long min = Math.min(B,C);
        long s = min, e = min * A, ans = 0;
        long lcm = lcm(B, C);
        while(s <= e) {
            long mid = s + (e-s)/2;
            long i = (mid/B) + (mid/C) - (mid/lcm);
            if(i < A) {
                s = mid + 1;
            } else if (i > A) {
                e = mid - 1;
            } else {
                ans = mid;
                e = mid - 1;
            }
        }
        return (int) (ans % MOD);
    }

    private long lcm(long a, long b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        for(long i=max; ; i += max) {
            if(i % min == 0) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        AthMagicalNumber ob = new AthMagicalNumber();
        System.out.println(ob.solve(4,2,3)); //6
    }
}
