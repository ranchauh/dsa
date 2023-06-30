package serach.binary;

import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * There are two sorted arrays A and B of sizes N and M respectively.
 *
 * Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
 *
 * NOTE:
 *
 * The overall run time complexity should be O(log(m+n)).
 * IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
 *
 *
 * Problem Constraints
 * 1 <= N + M <= 2*106
 *
 *
 *
 * Input Format
 * The first argument is an integer array A of size N.
 * The second argument is an integer array B of size M.
 *
 *
 *
 * Output Format
 * Return a decimal value denoting the median of two sorted arrays.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 4, 5]
 *  B = [2, 3]
 * Input 2:
 *
 *  A = [1, 2, 3]
 *  B = [4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  3.0
 * Output 2:
 *
 *  2.5
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The median of both the sorted arrays will be 3.0.
 * Explanation 2:
 *
 *  The median of both the sorted arrays will be (2+3)/2 = 2.5.
 */
public class MedianOfArray {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int n = a. size(), m = b. size();
        if (n > m) {
            // Swap the arrays to ensure 'a' is always smaller
            return findMedianSortedArrays(b, a);
        }

        int total = n + m;
        int half = (total + 1) / 2; // Half of the merged array size
        int l = 0, r = n;
        while (l <= r) {
            int partitionA = (l + r) / 2;
            int partitionB = half - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer. MIN_VALUE : a. get(partitionA - 1);
            int minRightA = (partitionA == n) ? Integer. MAX_VALUE : a. get(partitionA);
            int maxLeftB = (partitionB == 0) ? Integer. MIN_VALUE : b. get(partitionB - 1);
            int minRightB = (partitionB == m) ? Integer. MAX_VALUE : b. get(partitionB);

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // Found the correct partitions
                if (total % 2 == 0) {
                    // Merged array has even size
                    return (Math. max(maxLeftA, maxLeftB) + Math. min(minRightA, minRightB)) / 2.0;
                } else {
                    // Merged array has odd size
                    return Math. max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                // Need to move left in partitionA
                r = partitionA - 1;
            } else {
                // Need to move right in partitionA
                l = partitionA + 1;
            }
        }
        throw new IllegalArgumentException("Invalid input arrays");
    }

    public static void main(String[] args) {
        MedianOfArray ob = new MedianOfArray();
        System.out.println(ob.findMedianSortedArrays(Arrays.asList(), Arrays.asList(20))); //20.0
        System.out.println(
                ob.findMedianSortedArrays(
                        Arrays.asList(-43,-25,-18,-15,-10,9,39,40), Arrays.asList(-2))); // -10.0
    }
}
