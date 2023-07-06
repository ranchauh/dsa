package sorting;

import java.util.Arrays;

/**
 * Problem Description
 * Given an integer array, A of size N.
 * You have to find all possible non-empty subsequences of the array of numbers and then,
 * for each subsequence, find the difference between the largest and smallest number in that subsequence.
 * Then add up all the differences to get the number.
 *
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 *
 * NOTE: Subsequence can be non-contiguous.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10000
 *
 * 1<= A[i] <=1000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the output.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2]
 * Input 2:
 *
 * A = [3, 5, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  21
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All possible non-empty subsets are:
 * [1]     largest-smallest = 1 - 1 = 0
 * [2]     largest-smallest = 2 - 2 = 0
 * [1, 2]  largest-smallest = 2 - 1 = 1
 * Sum of the differences = 0 + 0 + 1 = 1
 * So, the resultant number is 1
 * Explanation 2:
 *
 * All possible non-empty subsets are:
 * [3]         largest-smallest = 3 - 3 = 0
 * [5]         largest-smallest = 5 - 5 = 0
 * [10]        largest-smallest = 10 - 10 = 0
 * [3, 5]      largest-smallest = 5 - 3 = 2
 * [3, 10]     largest-smallest = 10 - 3 = 7
 * [5, 10]     largest-smallest = 10 - 5 = 5
 * [3, 5, 10]  largest-smallest = 10 - 3 = 7
 * Sum of the differences = 0 + 0 + 0 + 2 + 7 + 5 + 7 = 21
 * So, the resultant number is 21
 */
public class SumTheDifferences {
    public int solve(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        long mod = 1000000007L;
        long ans = 0;
        for (int i=0; i<n; i++) {
            long max =  powWithModulo(2, i, mod);
            long min = powWithModulo(2, n-i-1, mod);
            ans = (ans + (A[i] % mod * (max - min)) % mod) % mod;
        }
        return (int) ((ans + mod) % mod);
    }

    public long powWithModulo(int A, int B, long C) {
        long mul = 1;
        for(int i=1; i<=B; i++) {
            mul = (mul * A) % C;
        }
        return mul % C;
    }

    public static void main(String[] args) {
        SumTheDifferences ob = new SumTheDifferences();
        int[] A = {3, 5, 10};
        System.out.println(ob.solve(A)); // 21
    }
}
