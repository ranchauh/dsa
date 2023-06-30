package gcd;

/**
 * Problem Description
 * Given 2 non-negative integers A and B, find gcd(A, B)
 *
 * GCD of 2 integers A and B is defined as the greatest integer 'g' such that 'g' is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.
 *
 * Note: DO NOT USE LIBRARY FUNCTIONS.
 */
public class Gcd {
    public static int gcd(int A, int B) {
        while(A > 0 && B > 0) {
            if(A > B) {
                A = A%B;
            } else {
                B = B%A;
            }
        }
        if(A == 0) {
            return B;
        }
        return A;
    }

    /*
     * 12, 8
     * 12: 1, 2, 3, 4, 6, 12
     * 8:  1, 2,    4, 8
     * Ans: 4
     *
     * a = 8
     * b = 12
     * swap(8, 12)
     * a = 12
     * b = 8
     * while(8 > 0) {
     *   a = 12%8 = 4
     *   swap(4, 8)
     *      a = 8
     *      b = 4
     * }
     *
     * while(4 > 0) {
     *   a = 8%4 = 0
     *   swap(0, 4)
     *      a = 4
     *      b = 0
     * }
     * return 4;
     */
    public static int  gcdSwap(int a, int b) {
        if(a%b == 0) return b;
        if(a < b) {
            // swap
            int t = a;
            a = b;
            b = t;
        }
        while(b>0) {
            a = a%b;
            // swap
            int t = a;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(4, 6)); // 2
        System.out.println(gcd(6, 7)); // 1
        System.out.println(gcd(12, 8)); // 1

        System.out.println(gcdSwap(4, 6)); // 2
        System.out.println(gcdSwap(6, 7)); // 1
        System.out.println(gcdSwap(12, 8)); // 1
    }
}
