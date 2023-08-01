package stack;
import java.util.Stack;

/**
 * Problem Description
 * Given an array of integers A.
 *
 * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
 *
 * Find the area of the largest rectangle formed by the histogram.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 10000
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 1, 5, 6, 2, 3]
 * Input 2:
 *
 *  A = [2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
 * Explanation 2:
 *
 * Largest rectangle has area 2.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] A) {
        int n = A.length;
        int[] prevSmallerIdx = prevSmallerIdx(A);
        int[] nextSmallerIdx = nextSmallerIdx(A);
        int maxArea = 0;
        for(int i=0; i<n; i++) {
            int ps = prevSmallerIdx[i];
            int ns = nextSmallerIdx[i];
            int area = A[i] * (ns - ps - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
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

    public static void main(String[] args) {
        LargestRectangleInHistogram ob = new LargestRectangleInHistogram();
        System.out.println(ob.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3})); // 10
        System.out.println(ob.largestRectangleArea(new int[]{2})); // 2
        System.out.println(ob.largestRectangleArea(new int[]{1,1,1,1})); // 2
    }
}
