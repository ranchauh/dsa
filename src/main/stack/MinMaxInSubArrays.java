package stack;
import java.util.Stack;
/**
 * Problem Description
 * Given an array of integers A.
 *
 * The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
 *
 * Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 1000000
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the sum of values of all possible subarrays of A modulo 109+7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1]
 * Input 2:
 *
 *  A = [4, 7, 3, 8]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  26
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Only 1 subarray exists. Its value is 0.
 * Explanation 2:
 *
 * value ( [4] ) = 4 - 4 = 0
 * value ( [7] ) = 7 - 7 = 0
 * value ( [3] ) = 3 - 3 = 0
 * value ( [8] ) = 8 - 8 = 0
 * value ( [4, 7] ) = 7 - 4 = 3
 * value ( [7, 3] ) = 7 - 3 = 4
 * value ( [3, 8] ) = 8 - 3 = 5
 * value ( [4, 7, 3] ) = 7 - 3 = 4
 * value ( [7, 3, 8] ) = 8 - 3 = 5
 * value ( [4, 7, 3, 8] ) = 8 - 3 = 5
 * sum of values % 10^9+7 = 26
 */
public class MinMaxInSubArrays {
    public int solve(int[] A) {
        long mod = 1000000000 + 7L;
        int n = A.length;

        int[] psi = prevSmallerIdx(A);
        int[] nsi = nextSmallerIdx(A);

        int[] pgi = prevGreaterIdx(A);
        int[] ngi = nextGreaterIdx(A);

        long ans = 0;
        for(int i=0; i<n; i++) {
            long maxCount = ((long)(i - pgi[i]) * (ngi[i] - i)) % mod;
            long minCount = ((long)(i - psi[i]) * (nsi[i] - i)) % mod;
            long iContribution = (A[i] * (maxCount - minCount + mod)) % mod;
            ans = (ans + iContribution) % mod;
        }
        return (int) (ans % mod);
    }

    public static int[] prevSmallerIdx(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    public static int[] nextSmallerIdx(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = n;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    public static int[] prevGreaterIdx(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    public static int[] nextGreaterIdx(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length;
        int[] result = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = n;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        MinMaxInSubArrays ob = new MinMaxInSubArrays();
        System.out.println(ob.solve(new int[]{4, 7, 3, 8})); // 26
        System.out.println(ob.solve(new int[]{1,2})); // 1
        System.out.println(ob.solve(new int[]{2})); // 0
    }
}
