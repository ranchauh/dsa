package basic;

import prime.IsPrime;

/**
 * A lucky number  is a number that has exactly 2 distinct  prime divisors.
 * You are given a number A and you need to determine the count  of lucky numbers between the range 1 to A (both inclusive).
 * Output: Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.
 */
public class ContLuckyNumbers {
    public static int solve(int A) {
        // TC: O(n^2 root(n))
        int luckyNumbers = 0;
        for(int i=1; i<=A; i++) { // O(n)
            int count = 0;
            for(int j=2; j<=i; j++) { // O(n)
                if(IsPrime.solve((long) j) == 1 && i%j == 0) { // root(n)
                    count++;
                }
            }
            if(count == 2) {
                luckyNumbers++;
            }
        }
        return luckyNumbers;
    }

    public static int solveSieveOfEratosthenes(int A) {
        // TC: O(nlong)
        // SC: O(n)
        int[] sieve = new int[A+1];
        for(int i=2; i<=A; i++) { // O(n)
            if(sieve[i] == 0) {
                for(int j=2*i; j<= A; j = j + i) { // O(logn)
                    sieve[j]++;
                }
            }
        }
        int count = 0;
        for(int i=2; i<=A; i++) { // O(n)
            if(sieve[i] == 2) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(8)); // 1 = > 6
        System.out.println(solve(12)); // 3 = > 6, 10, 12

        System.out.println(solveSieveOfEratosthenes(8)); // 1 = > 6
        System.out.println(solveSieveOfEratosthenes(12)); // 3 = > 6, 10, 12
    }
}
