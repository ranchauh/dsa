package sorting.merge;

import java.util.Arrays;

/**
 * Problem Description
 * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
 *
 *
 * Problem Constraints
 * -1010 <= A[i], B[i] <= 1010
 *
 *
 * Input Format
 * First Argument is a 1-D array representing  A.
 * Second Argument is also a 1-D array representing B.
 *
 *
 * Output Format
 * Return a 1-D vector which you got after merging A and B.
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [4, 7, 9]
 * B = [2, 11, 19]
 * Input 2:
 *
 * A = [1]
 * B = [2]
 *
 *
 * Example Output
 * Output 1:
 *
 * [2, 4, 7, 9, 11, 19]
 * Output 2:
 *
 * [1, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Merging A and B produces the output as described above.
 * Explanation 2:
 *
 *  Merging A and B produces the output as described above.
 */
public class MergeTwoSortedArray {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] solve(final int[] A, final int[] B) {
        int i=0, j=0, k=0;
        int n = A.length;
        int m = B.length;
        int[] result = new int[n+m];
        // compare and copy elements from both array until one of them or both are over.
        while(i < n && j < m) {
            if(A[i] <= B[j]) {
                result[k] = A[i];
                i++;
                k++;
            } else {
                result[k] = B[j];
                j++;
                k++;
            }
        }
        // copy remaining elements from array A
        while(i < n) {
            result[k] = A[i];
            i++;
            k++;
        }

        // copy remaining elements from array B
        while(j < m) {
            result[k] = B[j];
            j++;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {4, 7, 9};
        int[] B = {2, 11, 19};
        System.out.println(Arrays.toString(solve(A, B))); //[2, 4, 7, 9, 11, 19]
    }

}
