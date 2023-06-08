package prime;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * Given an integer A. Find the list of all prime numbers in the range [1, A].
 *
 *
 * Problem Constraints
 * 1 <= A <= 106
 *
 *
 *
 * Input Format
 * Only argument A is an integer.
 *
 *
 *
 * Output Format
 * Return a sorted array of prime number in the range [1, A].
 *
 *
 *
 * Example Input
 * Input 1:
 * A = 7
 * Input 2:
 * A = 12
 *
 *
 * Example Output
 * Output 1:
 * [2, 3, 5, 7]
 * Output 2:
 * [2, 3, 5, 7, 11]
 *
 *
 * Example Explanation
 * For Input 1:
 * The prime numbers from 1 to 7 are 2, 3, 5 and 7.
 * For Input 2:
 * The prime numbers from 1 to 12 are 2, 3, 5, 7 and 11.
 */
public class FindAllPrimes {
    /**
     * TC: O(loglogn)
     * SC: O(n)
     */
    public ArrayList<Integer> solve(int A) {
        boolean[] sieve = sieve(A);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=2; i<=A; i++) {
            if(sieve[i]) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * TC: O(loglogn)
     * SC: O(n)
     */
    boolean[] sieve(int A) {
        int n = A + 1;
        boolean[] sieve = new boolean[n];
        for(int i=0; i<n; i++) { // O(n)
            sieve[i] = true;
        }
        for(int i=2; i*i<n; i++) { // O(logn)
            if(sieve[i]) {
                for(int j=i*i; j<n; j += i) { // O(logn)
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }

    public static void main(String[] args) {
        FindAllPrimes ob = new FindAllPrimes();
        System.out.println(Arrays.toString(ob.sieve(7))); //[2, 3, 5, 7]
        System.out.println(Arrays.toString(ob.sieve(12))); // [2, 3, 5, 7, 11]
    }

}
