package sorting;

import java.util.Arrays;

/**
 * Problem Description
 * Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 * 1 <= A[i] <= 105
 *
 *
 * Input Format
 * The first argument is an integer array A.
 *
 *
 * Output Format
 * Return an integer array that is the sorted array A.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 3, 1]
 * Input 2:
 * A = [4, 2, 1, 3]
 *
 *
 * Example Output
 * Output 1:
 * [1, 1, 3]
 * Output 2:
 * [1, 2, 3, 4]
 *
 *
 * Example Explanation
 * For Input 1:
 * The array in sorted order is [1, 1, 3].
 * For Input 2:
 * The array in sorted order is [1, 2, 3, 4].
 */
public class CountSort {
    public int[] solve(int[] A) {
        int n = A.length;
        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, A[i]);
        }
        int[] countArr = new int[max];
        for(int i=0; i<n; i++) {
            // A[i] -1 because the range is from 1 <= A[i] <= 10^5
            countArr[A[i] -1]++;
        }
        int idx = 0;
        for(int i=0; i<max; i++) {
            int count = countArr[i];
            for(int j=0; j<count; j++) {
                A[idx] = i+1;
                idx++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        CountSort obj = new CountSort();
        System.out.println(Arrays.toString(obj.solve(new int[]{4, 2, 1, 3})));  // [1, 2, 3, 4]
    }
}
