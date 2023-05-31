package bit;

import java.util.Arrays;

/**
 * Problem Description
 * Given an array A of length N where all the elements are distinct and are in the range [1, N+2].
 *
 * Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= N+2
 *
 * The elements of array A are distinct
 *
 *
 *
 * Input Format
 * Only argument A is an array of integers
 *
 *
 *
 * Output Format
 * Return a sorted array of size 2 denoting the missing elements.
 *
 *
 *
 * Example Input
 * Input 1:
 * A = [3, 2, 4]
 * Input 2:
 * A = [5, 1, 3, 6]
 *
 *
 * Example Output
 * Output 1:
 * [1, 5]
 * Output 2:
 * [2, 4]
 *
 *
 * Example Explanation
 * For Input 1:
 * The missing numbers are 1 and 5.
 * For Input 2:
 * The missing numbers are 2 and 4.
 */
public class FindTwoMissingNumbers {
    public int[] solve(int[] A) {
        int n = A.length;
        int xorAllElem = 0;
        for(int x : A) {
            xorAllElem ^= x;
        }
        int xorTillNPlus2 = 0;
        for(int i=1; i<=n+2; i++) {
            xorTillNPlus2 ^= i;
        }
        // xor xorAllElem and xorTillNPlus2, this would be xor of two missing numbers x and y
        int xorXY = xorAllElem ^ xorTillNPlus2;
        // get RSB of x^y
        int rsb = getRsb(xorXY);
        // divide numbers into two groups based on the set bit on rsb
        int x=0, y = 0;
        for(int val : A) {
            if((val & rsb) == 0) {
                // bit is not set
                x = x ^ val;
            } else {
                // bit is set
                y = y ^ val;
            }
        }
        // xor x and y with numbers from 1 to N+2 to cancel the array elements out.
        for(int i=1; i<=n+2; i++) {
            if((i & rsb) == 0) {
                // bit is not set
                x = x ^ i;
            } else {
                // bit is set
                y = y ^ i;
            }
        }
        if(x > y) {
            return new int[]{y, x};
        } else {
            return new int[]{x, y};
        }
    }

    /**
     1. 1's complement of x = x`
     2. Add one to 1's complement x' + 1 = x" => 2's complement
     3. Do & with original number.
     */
    private int getRsb(int x) {
        // calc 1's complement of x
        int xc = x;
        for(int i=0; i<32; i++) {
            if((x & (1<<i)) != 0 ) {
                // ith bit is set, unset it
                xc = (xc ^ (1<<i));
            } else {
                // ith bit is not set, set it
                xc = (xc | (1<<i));
            }
        }
        // Add 1 to xc
        xc = xc + 1;
        // & with original
        return (xc & x);
    }

    public static void main(String[] args) {
        FindTwoMissingNumbers ob = new FindTwoMissingNumbers();
        System.out.println(Arrays.toString(ob.solve(new int[]{5, 1, 3, 6}))); // 2, 4
    }
}
