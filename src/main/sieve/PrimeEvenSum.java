package sieve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
 *
 * If there is more than one solution possible, return the lexicographically smaller solution.
 *
 * If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
 * [a, b] < [c, d], If a < c OR a==c AND b < d.
 * NOTE: A solution will always exist. Read Goldbach's conjecture.
 *
 *
 *
 * Problem Constraints
 * 4 <= A <= 2*107
 *
 *
 *
 * Input Format
 * First and only argument of input is an even number A.
 *
 *
 *
 * Output Format
 * Return a integer array of size 2 containing primes whose sum will be equal to given number.
 *
 * Example Input
 *  4
 *
 *
 * Example Output
 *  [2, 2]
 *
 *
 * Example Explanation
 *  There is only 1 solution for A = 4.
 */
public class PrimeEvenSum {

    public int[] primeSum(int A) {
        List<Integer> sieve = sieve(A);
        for(int x : sieve) {
            int diff = A - x;
            if(sieve.contains(diff)) {
                return new int[]{x, diff};
            }
        }
        return new int[]{};
    }

    List<Integer> sieve(int n) {
        boolean[] sieve = new boolean[n+1];
        for(int i=0; i<=n; i++) {
            sieve[i] = true;
        }
        for(int i=2; i<=n; i++) {
            if(sieve[i]) {
                for(int j=2*i; j<=n; j += i) {
                    sieve[j] = false;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=2; i<=n; i++) {
            if(sieve[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PrimeEvenSum ob = new PrimeEvenSum();
        System.out.println(Arrays.toString(ob.primeSum(4))); // [2,2]
        System.out.println(Arrays.toString(ob.primeSum(18)));// [5,13]
    }
}
