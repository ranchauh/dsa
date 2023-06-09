package prime;

import java.util.Arrays;
/**
 * Problem Description
 * Groot has an array A of size N. However, seeking excitement, Groot embarked on constructing an equally-sized array B with a unique definition for each of its elements:
 *
 * B[i] = factorial of A[i] for every i such that 1<= i <= N.
 *
 * Now Groot is interested in the total number of non-empty subsequences of array B such that every element in the subsequence has the same non-empty set of prime factors.
 *
 * Since the number can be huge, return it modulo 109 + 7.
 *
 * NOTE:
 *
 * Factorial of a number X denotes (1 x 2 x 3 x 4......(X-1) x (X)).
 * A set is a data structure having only distinct elements. E.g : the set of prime factors of Y=12 will be {2,3} and not {2,2,3}
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer deonting the total number of non-empty subsequences of array B such that every element in the subsequence has the same set of prime factors modulo 109+7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 3, 2, 3]
 * Input 2:
 *
 *  A = [2, 3, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Array B will be : [2, 6, 2, 6]
 *  The total possible subsequences are 6 : [2], [2], [2, 2], [6], [6], [6, 6].
 * Explanation 2:
 *
 *  Array B will be : [2, 6, 24]
 *  The total possible subsequences are 4 : [2], [6], [24], [6, 24].
 */

/**
 * Hint:
 * We can say that the factorial of any number between two consecutive prime numbers, say (x, y) will have an equal set of prime numbers as that of a set of prime numbers in x.
 * Since the factorial of x will contain all prime numbers less than equal to x.
 *
 * We will store all the prime numbers less than equal to the highest value in the given array in sorted order in an auxiliary array, say v.
 *
 * Iterate over all prime numbers in array v, and for each v[i], count the number of values in the array which are less than v[i].
 * Let cnt denotes that value of each prime number v[i].
 *
 * All the subsequences of this will be pow(2, cnt) - 1.
 *
 * Sum all the values and return the answer.
 *
 * Note that we are talking of a non-empty set. So the 1st set will be discarded.
 */
public class FactorialArray {
    private static final int MOD = 1000000007;
    public int solve(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        int max = A[n-1];
        int[] sieve = sieve(max);
        int m = sieve.length;
        int i = 0, j=0;
        int count = 0;
        int ans = 0;
        while(i < n) {
            if(A[i] == 1) {
                i++;
                continue;
            }
            if(j >= m || A[i] < sieve[j]) {
                i++;
                count++;
            } else {
                ans += ((Math.pow(2, count) - 1) % MOD);
                count = 0;
                j++;
            }
        }
        ans += ((Math.pow(2, count) - 1) % MOD);
        return ans;
    }

    int[] sieve(int n) {
        boolean[] sieve = new boolean[n+1];
        for(int i=0; i<=n; i++) {
            sieve[i] = true;
        }
        int count = 0;
        for(int i=2; i<=n; i++) {
            if(sieve[i]) {
                count++;
                for(int j=2*i; j<=n; j += i) {
                    sieve[j] = false;
                }
            }
        }
        int[] result = new int[count];
        result[1] = 1;
        for(int i=2, j=0; i<=n; i++) {
            if(sieve[i]) {
                result[j] = i;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FactorialArray ob = new FactorialArray();
        System.out.println(ob.solve(new int[]{2,3,4,5,6})); //7
        System.out.println(ob.solve(new int[]{251,923,561,230,100,399,542,198,548,892,721,781,174,809,9,232,165,861,36,837,377,313,475,269,210,530,940,570,24,434,764,275,709,325,505,161,724,47,359,625,291,81,406,465,242,767,698,408,629,86,597,358,399,72,979,962,603,919,884,627,353,1,254,414,678,111,575,755,511,287,380,802,720,138,620,314,905,670,74,886,756,671,244,508,744,224,822,347,495,706,326,201,707,580,615,386,43,543,141,554})); //134

    }
}
