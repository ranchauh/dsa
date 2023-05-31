package bit;

import java.util.Arrays;

/**
 * Problem Description
 * Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
 * Find the two integers that appear only once.
 *
 * Note: Return the two numbers in ascending order.
 *
 *
 * Problem Constraints
 * 2 <= |A| <= 100000
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first argument is an array of integers of size N.
 *
 *
 *
 * Output Format
 * Return an array of two integers that appear only once.
 *
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 1, 2, 4]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 * Output 1:
 * [3, 4]
 * Output 2:
 *
 * [1, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 * 3 and 4 appear only once.
 * Explanation 2:
 *
 * 1 and 2 appear only once.
 */
public class SingleNumber2InPairs {
    public int[] solve(int[] A) {
        int xyXor = 0;
        for(int x : A) {
            xyXor = (xyXor ^ x);
        }
        int rsb = getRsb(xyXor);
        int x=0, y=0;
        for(int val : A) {
            if((val & rsb) == 0) {
                x = x ^ val;
            } else {
                y = y ^ val;
            }
        }
        if(x > y) {
            return new int[] {y, x};
        } else {
            return new int[] {x, y};
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
        SingleNumber2InPairs ob = new SingleNumber2InPairs();
        //int[] A = {1, 2, 3, 1, 2, 4};
        //System.out.println(Arrays.toString(ob.solve(A))); //3, 4
        int[] B = new int[]{186,256,102,377,186,377};
        System.out.println(Arrays.toString(ob.solve(B))); //102 256
    }
}
