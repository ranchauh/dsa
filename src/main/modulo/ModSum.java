package modulo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array A <= 105
 *
 * 1 <= A[i] <= 103
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return a single integer denoting sum % (109 + 7).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3]
 * Input 2:
 *
 *  A = [17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  61
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5
 */
public class ModSum {
    public int solveBrutForce(int[] A) {
        int n = A.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i != j) {
                    sum += (A[i] % A[j]);
                }
            }
        }
        return sum;
    }

    public int solveOptimal(int[] A) {
        int mod = (int) 1e9 + 7;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int x : A) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        long[] modSum = new long[1000];
        for(int i=1; i<=1000; i++) {
            for(int x : A) {
                modSum[i-1] += (i%x);
            }
        }
        long result = 0;
        for(int i=1; i<=1000; i++) {
            result += modSum[i-1] * freq.getOrDefault(i, 0);
        }
        return (int) (result % mod);
    }

    public static void main(String[] args) {
        ModSum ob = new ModSum();
        System.out.println(ob.solveBrutForce(new int[]{1, 2, 3})); // 5

        System.out.println(ob.solveOptimal(new int[]{1, 2, 3})); // 5

    }
}
