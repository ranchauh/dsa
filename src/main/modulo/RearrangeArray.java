package modulo;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array A of size N. Rearrange the given array so that A[i] becomes A[A[i]] with O(1) extra space.
 *
 * Constraints:
 *
 * 1 <= N <= 5×104
 *
 * 0 <= A[i] <= N - 1
 *
 * The elements of A are distinct
 *
 * Input Format
 *
 * The argument A is an array of integers
 *
 * Example 1:
 *
 * Input : [1, 0]
 * Return : [0, 1]
 * Example 2:
 *
 * Input : [0, 2, 1, 3]
 * Return : [0, 1, 2, 3]
 */
public class RearrangeArray {
    public static void arrange(List<Integer> A) {
        int n = A.size();
        for(int i=0; i<n; i++) {
            // A[i] = A[i] * n
            A.set(i, A.get(i) * n);
        }
        for(int i=0; i<n; i++) {
            // A[i] = A[i] + A[A[i]/n] (old value)
            int newIdx = A.get(i)/n;
            A.set(i, A.get(i) + A.get(newIdx)/n);
        }
        for(int i=0; i<n; i++) {
            // A[i] = A[i] % n (new value)
            A.set(i, A.get(i) % n);
        }
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(4, 0, 2, 1, 3);
        arrange(array);
        System.out.println(array); // 3 4 2 0 1
    }
}
