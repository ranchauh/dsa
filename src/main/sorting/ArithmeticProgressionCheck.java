package sorting;

import java.util.Arrays;

/**
 * Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 */
public class ArithmeticProgressionCheck {
    public static int solve(int[] A) {
        Arrays.sort(A);
        int diff = A[1] - A[0];
        for(int i=2; i<A.length; i++) {
            int d = A[i] - A[i-1];
            if(d != diff) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] A = {3, 5, 1};
        System.out.println(solve(A)); // 1

        int[] B = {2, 4, 1};
        System.out.println(solve(B)); // 0
    }
}
