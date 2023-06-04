package bit;

/**
 * Problem Description
 * Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.
 *
 * Since the answer can be large, return the remainder after the dividing the answer by 109+7.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] < 109
 *
 *
 *
 * Input Format
 * Only argument A is an array of integers
 *
 *
 *
 * Output Format
 * Return an integer denoting the sum of xor of all pairs of number in the array.
 *
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3]
 * Input 2:
 * A = [3, 4, 2]
 *
 *
 * Example Output
 * Output 1:
 * 6
 * Output 2:
 * 14
 *
 *
 * Example Explanation
 * For Input 1:
 * Pair    Xor
 * {1, 2}  3
 * {1, 3}  2
 * {2, 3}  1
 * Sum of xor of all pairs = 3 + 2 + 1 = 6.
 * For Input 2:
 * Pair    Xor
 * {3, 4}  7
 * {3, 2}  1
 * {4, 2}  6
 * Sum of xor of all pairs = 7 + 1 + 6 = 14.
 */
public class XorSumOfAllPairs {
    public static int solve(int[] A) {
        int n = A.length;
        long mod = (long) 1e9 + 7;
        long xorSum = 0;
        for(int i=0; i<31; i++) {
            int setCount = 0;
            long val = 1<<i;
            for(long x : A) {
                long r = (x & val);
                if(r != 0) {
                    setCount++;
                }
            }
            long unsetCount = n - setCount;
            xorSum += (((setCount * unsetCount) % mod) * val) % mod;
        }
        return (int) (xorSum % mod);
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3}));//6
        System.out.println(solve(new int[]{3, 4, 2}));//14
    }
}
