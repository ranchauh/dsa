package bit;

/**
 * Problem Description
 * Reverse the bits of an 32 bit unsigned integer A.
 *
 *
 *
 * Problem Constraints
 * 0 <= A <= 232
 *
 *
 *
 * Input Format
 * First and only argument of input contains an integer A.
 *
 *
 *
 * Output Format
 * Return a single unsigned integer denoting the decimal value of reversed bits.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  0
 * Input 2:
 *
 *  3
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  3221225472
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *         00000000000000000000000000000000
 * =>      00000000000000000000000000000000
 * Explanation 2:
 *
 *         00000000000000000000000000000011
 * =>      11000000000000000000000000000000
 */
public class ReverseBits {
    /**
     * Check from both sides -
     * If bits are same, nothing to do.
     * Else toggle the bits.
     */
    public long reverse(long A) {
        int i=0;
        int j=31;
        //printBits(A);
        while(i<j) {
            boolean left=false, right=false;
            if((A&(1L<<i)) != 0) {
                right = true;
            }
            if((A&(1L<<j)) != 0) {
                left = true;
            }

            if(left != right) {
                A = (A^(1L<<j));
                A = (A^(1L<<i));
            }

            i++;
            j--;
            //printBits(A);
            // System.out.print(A + " | ");
        }
        return A;
    }

    private void printBits(long A) {
        for(int i=31; i>=0; i--) {
            if((A&(1L <<i)) == 0) {
                System.out.print(0);
            } else {
                System.out.print(1);
            }
        }
        System.out.print("|");
    }
}
