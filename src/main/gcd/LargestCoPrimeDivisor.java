package gcd;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Description
 *
 * You are given two positive numbers A and B . You need to find the maximum valued integer X such that:
 *
 * X divides A i.e. A % X = 0
 * X and B are co-prime i.e. gcd(X, B) = 1
 *
 *
 * Problem Constraints
 *
 * 1 <= A, B <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer A.
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 *
 * Return an integer maximum value of X as descibed above.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 30
 *  B = 12
 * Input 2:
 *
 *  A = 5
 *  B = 10
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  All divisors of A are (1, 2, 3, 5, 6, 10, 15, 30).
 *  The maximum value is 5 such that A%5 == 0 and gcd(5,12) = 1
 * Explanation 2:
 *
 *  1 is the only value such that A%5 == 0 and gcd(1,10) = 1
 *
 *
 */

/**
 * Hint:
 * We know A is the greatest number dividing A. So if A and B are coprime, we can return the value of X to be A. Else, we can try to remove the common factors of A and B from A.
 * Given this hint, how would you think of the solution?
 */
public class LargestCoPrimeDivisor {
    public int cpFact(int A, int B) {
        // If A and B are co-prime, then X = A such that
        // A%X == 0 and gcd(X, B) == 1
        if(gcd(A, B) == 1) return A;
        // Find factors of both the numbers
        Set<Integer> factorsA = findFactors(A);
        Set<Integer> factorsB = findFactors(B);

        //
        // The result will be a factor of A
        // but it should not be a factor of B greater than 1 to meet the second condition
        // So, Remove common factors from A.
        for(int x : factorsB) {
            factorsA.remove(x);
        }
        // Now, factorsA does not contain any number which divides B as well.
        // Check the remaining factors
        int max = 1;
        for(int x : factorsA) {
            if(gcd(x, B) == 1) {
                max = Math.max(max, x);
            }
        }
        return max;
    }

    int gcd(int a, int b) {
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

    Set<Integer> findFactors(int A) {
        Set<Integer> factors = new HashSet<>();
        for(int i=1; i*i <= A; i++) {
            if(A%i == 0) {
                if(A/i == i) {
                    factors.add(i);
                } else {
                    factors.add(i);
                    factors.add(A/i);
                }
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        LargestCoPrimeDivisor ob = new LargestCoPrimeDivisor();
        System.out.println(ob.cpFact(100, 26)); // 25
        System.out.println(ob.cpFact(2, 2)); // 25
    }
}
