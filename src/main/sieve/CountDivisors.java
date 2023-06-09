package sieve;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * Given an array of integers A, find and return the count of divisors of each element of the array.
 *
 * NOTE: The order of the resultant array should be the same as the input array.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the count of divisors of each element of the array in the form of an array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 3, 4, 5]
 * Input 2:
 *
 *  A = [8, 9, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 2, 3, 2]
 * Output 1:
 *
 *  [4, 3, 4]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 *  So the count will be [2, 2, 3, 2].
 * Explanation 2:
 *
 *  The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 *  So the count will be [4, 3, 4].
 */
public class CountDivisors {

    private static final int MAX_VALUE = 1000000;

    public int[] solveSieve(int[] A) {
        int n = A.length;
        int[] factors = new int[n];
        int[] spfArray = smallestPrimeFactor();
        int i = 0;
        // initialize
        for(int j = 0; j < n; j++) {
            factors[j]  = 1;
        }
        for(int x : A) {
            Map<Integer,Integer> countMap = new HashMap<>();
            while(x > 1) {
                int spf = spfArray[x];
                countMap.put(spf, countMap.getOrDefault(spf, 0) + 1);
                x = x/spf;
            }
            System.out.println(countMap);
            for(int key : countMap.keySet()) {
                int pow = countMap.get(key);
                factors[i] = factors[i] * (pow + 1);
            }
            i++;
        }
        return factors;
    }

    int[] smallestPrimeFactor() {
        int[] spf = new int[MAX_VALUE+1];
        for(int i=0; i<MAX_VALUE; i++) {
            spf[i] = i;
        }
        for(int i=2; i*i<=MAX_VALUE; i++) {
            if(spf[i] == i) {
                for(int j=i*i; j<=MAX_VALUE; j += i) {
                    if(spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }

    public int[] solve(int[] A) {
        int n = A.length;
        int[] factors = new int[n];
        for(int i=0; i<n; i++) {
            factors[i] = countFactors(A[i]);
        }
        return factors;
    }

    int countFactors(int n) {
        int count = 0;
        for(int i=1; i*i<=n; i++) {
            if(n%i == 0) {
                if(n/i == i) count++;
                else count += 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountDivisors ob = new CountDivisors();
        System.out.println(Arrays.toString(ob.solveSieve(new int[]{2, 3, 4, 5}))); // 2, 2, 3, 2
        System.out.println(Arrays.toString(ob.solveSieve(new int[]{3,52,66,64,14,51,6,39,5,26,80,88,60,73,67,16,1,81,62,42,83,31,40,4,32,31,44,3,20,94,93,57,2,18,32,59,91,30,45}))); //2 6 8 7 4 4 4 4 2 4 10 8 12 2 2 5 1 5 4 8 2 2 8 3 6 2 6 2 6 4 4 4 2 6 6 2 4 8 6
    }
}
