package arrays;

import java.util.Arrays;

/**
 * Problem Description
 * Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is the vector A
 *
 *
 *
 * Output Format
 * Return one integer, the answer to the question
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [0, 1, 0, 2]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 1 unit is trapped on top of the 3rd element.
 * Explanation 2:
 *
 * No water is trapped.
 */
public class RainWaterTrapped {
    public int trap(final int[] A) {
        int n = A.length;
        int[] suffixRightMax = suffixRightMax(A);
        System.out.println(Arrays.toString(suffixRightMax));
        int total = 0;
        int leftMax = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            leftMax = Math.max(leftMax, A[i]);
            total += Math.min(leftMax, suffixRightMax[i]) - A[i];
        }
        return total;
    }

    public int trapTwoPointers(final int[] A) {
        return 0;
    }

    private int[] prefixLeftMax(int[] A) {
        int n = A.length;
        int[] prefix = new int[n];
        int max = A[0];
        prefix[0] = max;
        for(int i=1; i<n; i++) {
            if(A[i] > max) {
                max = A[i];
            }
            prefix[i] = max;
        }
        return prefix;
    }

    private int[] suffixRightMax(int[] A) {
        int n = A.length;
        int[] suffix = new int[n];
        int max = A[n-1];
        suffix[n-1] = max;
        for(int i = n-2; i>=0; i--) {
            if(A[i] > max) {
                max = A[i];
            }
            suffix[i] = max;
        }
        return suffix;
    }

    public static void main(String[] args) {
        RainWaterTrapped obj = new RainWaterTrapped();
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Arrays.toString(A));
        System.out.println(obj.trap(A)); // 6
    }

}
