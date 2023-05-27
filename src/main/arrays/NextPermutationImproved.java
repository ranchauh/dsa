package arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
 *
 * If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.
 *
 * NOTE:
 *
 * The replacement must be in-place, do not allocate extra memory.
 * DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
 *
 *
 * Problem Constraints
 * 1 <= N <= 5 * 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first and the only argument of input has an array of integers, A.
 *
 *
 *
 * Output Format
 * Return an array of integers, representing the next permutation of the given array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3]
 * Input 2:
 *
 *  A = [3, 2, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 3, 2]
 * Output 2:
 *
 *  [1, 2, 3]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Next permutaion of [1, 2, 3] will be [1, 3, 2].
 * Explanation 2:
 *
 *  No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
 *  So will rearranges it in the lowest possible order.
 */
public class NextPermutationImproved {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        boolean status;
        status = nextPerm(A);
        if (!status)
            Collections.sort(A);
        return A;
    }

    public boolean nextPerm(ArrayList<Integer> A) {

        int i = 0;
        int n = A.size();

        for (i = n - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1))
                break;
        }

        // the array is in descending order
        if (i == -1)
            return false;

        int j = n - 1;
        for (; j >= i; j--) {
            if (A.get(j) > A.get(i))
                break;
        }

        // swap with the smallest number in the suffix
        swap(A, i, j);

        // reversing the suffix
        i++;
        int steps = (n - i + 1) / 2;
        for (int k = 0; k < steps; k++) {
            swap(A, i + k, n - k - 1);
        }

        return true;
    }

    public void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
