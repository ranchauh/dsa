package bit;

/**
 * Problem Description
 * You are given an array of integers A of size N.
 *
 * The value of a subarray is defined as BITWISE OR of all elements in it.
 *
 * Return the sum of value of all subarrays of A % 109 + 7.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 108
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the sum of Value of all subarrays of A % 109 + 7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [7, 8, 9, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *  71
 * Output 2:
 *
 *  110
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Value([1]) = 1
 *  Value([1, 2]) = 3
 *  Value([1, 2, 3]) = 3
 *  Value([1, 2, 3, 4]) = 7
 *  Value([1, 2, 3, 4, 5]) = 7
 *  Value([2]) = 2
 *  Value([2, 3]) = 3
 *  Value([2, 3, 4]) = 7
 *  Value([2, 3, 4, 5]) = 7
 *  Value([3]) = 3
 *  Value([3, 4]) = 7
 *  Value([3, 4, 5]) = 7
 *  Value([4]) = 4
 *  Value([4, 5]) = 5
 *  Value([5]) = 5
 *  Sum of all these values = 71
 * Explanation 2:
 *
 *  Sum of value of all subarray is 110.
 */
public class SubArraysORSum {
    public static int solve(int[] A) {
        long mod = (long) 1e9 + 7;
        int n = A.length;
        long totalSubArrays = (n * (n+1L) / 2);
        long resultSum = 0;
        for(int i=0; i<=31; i++) {
            long remainingSubArrays = totalSubArrays;
            int consecutiveUnsetBits = 0;
            long subArraysToReduce = 0;
            for(int x : A) {
                if((x & (1<<i)) == 0) {
                    subArraysToReduce++;
                    consecutiveUnsetBits++;
                } else if (consecutiveUnsetBits > 1){
                    subArraysToReduce -= consecutiveUnsetBits;
                    subArraysToReduce += (consecutiveUnsetBits * (consecutiveUnsetBits + 1L) / 2);
                    consecutiveUnsetBits = 0;
                } else {
                    consecutiveUnsetBits = 0;
                }
            }
            if (consecutiveUnsetBits > 1){
                subArraysToReduce -= consecutiveUnsetBits;
                subArraysToReduce += (consecutiveUnsetBits * (consecutiveUnsetBits + 1L) / 2);
            }
            remainingSubArrays -= subArraysToReduce;
            long localSum = (remainingSubArrays * (1<<i)) % mod;
            resultSum += localSum % mod;
        }
        return (int) (resultSum % mod);
    }

    public static int solve2(int[] A) {
        int n = A.length;
        int[] idx = new int[32];
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            long tmp = A[i - 1];
            for (int j = 0; j <= 31; ++j) {
                long pw = 1 << j;
                if ((tmp & pw) != 0) { //if jth bit is set
                    ans += pw * i; // add its contribution in ans for all subarrays ending at index i
                    idx[j] = i; // store the index for next elements
                } else if (idx[j] != 0) // if jth bit is not set
                {
                    ans += pw * idx[j]; // add its contribution in ans for all subarrays ending at index i using
                } // the information of last element having jth bit set
            }
        }
        return (int)(ans % 1000000007);
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        System.out.println(solve(A)); // 40

        int[] B = {1,2,3,4,5};
        System.out.println(solve2(B)); // 71
    }
}
