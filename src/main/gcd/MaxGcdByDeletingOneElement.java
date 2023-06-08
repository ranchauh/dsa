package gcd;

import java.util.Arrays;

/**
 * Problem Description
 *
 * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
 *
 * Find the maximum value of GCD.
 *
 *
 *
 * Problem Constraints
 *
 * 2 <= N <= 105
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the maximum value of GCD.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [12, 15, 18]
 * Input 2:
 *
 *  A = [5, 15, 30]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  15
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 *  If you delete 12, gcd will be 3.
 *  If you delete 15, gcd will be 6.
 *  If you delete 18, gcd will 3.
 *  Maximum vallue of gcd is 6.
 * Explanation 2:
 *
 *  If you delete 5, gcd will be 15.
 *  If you delete 15, gcd will be 5.
 *  If you delete 30, gcd will be 5.
 */
public class MaxGcdByDeletingOneElement {
    public int solve(int[] A) {
        int[] prefixGcd = prefixGcd(A);
        int[] suffixGcd = suffixGcd(A);
        int maxGcd = 0;
        int gcd = 0;
        int n = A.length;
        for(int i=0; i<n; i++) {
            if(i == 0) {
                gcd = suffixGcd[i+1];
            } else if(i == n-1) {
                gcd = prefixGcd[i-1];
            } else {
                gcd = gcd(prefixGcd[i-1], suffixGcd[i+1]);
            }
            maxGcd = Math.max(maxGcd, gcd);
        }
        return maxGcd;
    }

    private int[] prefixGcd(int[] A) {
        int n = A.length;
        int[] prefix = new int[n];
        prefix[0] = A[0];
        for(int i=1; i<n; i++) {
            prefix[i] = gcd(A[i], prefix[i-1]);
        }
        return prefix;
    }

    private int[] suffixGcd(int[] A) {
        int n = A.length;
        int[] suffix = new int[n];
        suffix[n-1] = A[n-1];
        for(int i=n-2; i>=0; i--) {
            suffix[i] = gcd(A[i], suffix[i+1]);
        }
        return suffix;
    }

    private int gcd(int A, int B) {
        while(A > 0 && B > 0) {
            if(A > B) {
                A = A%B;
            } else {
                B = B%A;
            }
        }
        if(A == 0) {
            return B;
        }
        return A;
    }

    public static void main(String[] args) {
        MaxGcdByDeletingOneElement ob = new MaxGcdByDeletingOneElement();
        System.out.println(ob.solve(new int[] {12, 15, 18})); // 6
        System.out.println(ob.solve(new int[] {5, 15, 30})); // 15
    }
}
