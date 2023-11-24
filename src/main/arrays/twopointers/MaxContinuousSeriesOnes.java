package arrays.twopointers;

import java.util.Arrays;

/**
 * Problem Description
 * Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.
 *
 * For this problem, return the indices of maximum continuous series of 1s in order.
 *
 * If there are multiple possible solutions, return the sequence which has the minimum start index.
 *
 *
 *
 * Problem Constraints
 * 0 <= B <= 105
 *
 * 1 <= size(A) <= 105
 *
 * 0 <= A[i] <= 1
 *
 *
 *
 * Input Format
 * First argument is an binary array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 1, 0, 1, 1, 0, 0, 1, 1, 1]
 *  B = 1
 * Input 2:
 *
 *  A = [1, 0, 0, 0, 1, 0, 1]
 *  B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  [0, 1, 2, 3, 4]
 * Output 2:
 *
 *  [3, 4, 5, 6]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Flipping 0 present at index 2 gives us the longest continous series of 1's i.e subarray [0:4].
 * Explanation 2:
 *
 *  Flipping 0 present at index 3 and index 5 gives us the longest continous series of 1's i.e subarray [3:6].
 */
public class MaxContinuousSeriesOnes {
    public int[] maxone(int[] A, int B) {
        int n = A.length;
        int s = 0, e = 0;
        int sIdx = 0, eIdx = 0;
        int origB = B;
        while(e < n) {
            if(A[e] == 0) {
                if(B > 0) {
                    B--;
                    e++;
                } else {
                    if((e-s) > (eIdx - sIdx)) {
                        sIdx = s;
                        eIdx = e;
                    }
                    if(A[s++] == 0 && origB > 0) {
                        B++;
                    }
                }
            } else {
                e++;
            }
            if(s > e) {
                e = s;
            }
        }
        if((e-s) > (eIdx - sIdx)) {
            sIdx = s;
            eIdx = e;
        }
        int[] result = new int[eIdx - sIdx];
        for(int i=sIdx; i<eIdx; i++) {
            result[i-sIdx] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxContinuousSeriesOnes ob = new MaxContinuousSeriesOnes();
        System.out.println(Arrays.toString(
                ob.maxone(new int[] {1, 1, 0, 1, 1, 0, 0, 1, 1, 1}, 1))); // [0, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
                ob.maxone(new int[] {1, 0, 0, 0, 1, 0, 1}, 2))); // [3, 4, 5, 6]
    }
}
