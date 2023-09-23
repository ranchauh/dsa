package dp;

/**
 * Problem Description
 * Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.
 *
 * Return an integer corresponding to the maximum product possible.
 *
 * NOTE: Answer will fit in 32-bit integer value.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 5 * 105
 *
 * -100 <= A[i] <= 100
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer corresponding to the maximum product possible.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [4, 2, -5, 1]
 * Input 2:
 *
 *  A = [-3, 0, -5, 0]
 *
 *
 * Example Output
 * Output 1:
 *
 *  8
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can choose the subarray [4, 2] such that the maximum product is 8.
 * Explanation 2:
 *
 *  0 will be the maximum product possible.
 */
public class MaxProduct {
    public static int maxProduct(final int[] A) {
        int ans = Integer.MIN_VALUE;
        int minProd = 1;
        int maxProd = 1;
        for (int j : A) {
            int mnp = Math.min(j, Math.min(j * minProd, j * maxProd));
            int mxp = Math.max(j, Math.max(j * minProd, j * maxProd));
            minProd = mnp;
            maxProd = mxp;
            ans = Math.max(ans, Math.max(minProd, maxProd));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,-3,-2,0,1,0,0,0,0,0,-2,0,0,0,3,3,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-2,0,0,0,-1,0,0,0,0,0,0,2,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,-1,0,0,3,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-2,0,0,0,0,-1,0,0,0,0,0,0,-3,0,0,0,0,-1,0,2,0,0,0,0,3,0,0,0,0,0,0,0,0,0,2,0,2,0,0,-2,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,-3,1,0,0,0,0,0,0,0,0,0,0,-2,0,0,3,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,-1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,-3,0,0,0,0,0,0,0,-1,-2,0,0,0,0,0,0,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(maxProduct(arr)); // 9
    }
}
