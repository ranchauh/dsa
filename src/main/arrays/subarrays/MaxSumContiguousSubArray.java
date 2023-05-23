package arrays.subarrays;

import java.util.Arrays;
// kadane's algorithm
/**
 * Problem Description
 * Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1e6
 * -1000 <= A[i] <= 1000
 *
 *
 *
 * Input Format
 * The first and the only argument contains an integer array, A.
 *
 *
 *
 * Output Format
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, -10]
 * Input 2:
 *
 *  A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 * Explanation 2:
 *
 *  The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
public class MaxSumContiguousSubArray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    /**
     A   -2, 1, -3, 4, -1, 2, 1, -5, 4
     sum -2  1  -3  4   3  5  6   1  5
     ans -2  1   1  4   4  5  6   6  6
     */
    public int maxSubArray(final int[] A) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int val : A) {
            sum += val;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public int[] maxSumSubArrayElements(final int[] A) {
        int n = A.length;
        int start = 0, nextStart = 0;
        int end = -1;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            sum += A[i];
            if (sum < 0) {
                sum = 0;
                nextStart = i+1;
            } else if( sum > maxSum) {
                start = nextStart;
                maxSum = sum;
                end = i;
            }
        }
        if(end == -1) {
            start = end = nextStart - 1;
        }
        //System.out.println(start + " " + end);
        int[] result = new int[end-start+1];
        for(int i=0; start <= end; i++) {
            result[i] = A[start];
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSumContiguousSubArray obj = new MaxSumContiguousSubArray();
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(obj.maxSubArray(A)); // 6
        System.out.println(Arrays.toString(obj.maxSumSubArrayElements(A))); //[4, -1, 2, 1]

        int[] B = {-5, -2, -3, -1};
        System.out.println(obj.maxSubArray(B)); // -1
        System.out.println(Arrays.toString(obj.maxSumSubArrayElements(B))); //[-1]
    }
}
