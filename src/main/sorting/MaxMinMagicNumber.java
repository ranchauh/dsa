package sorting;

/**
 * Problem Description
 * Given an array of integers A of size N where N is even.
 *
 * Divide the array into two subsets such that
 *
 * 1.Length of both subset is equal.
 * 2.Each element of A occurs in exactly one of these subset.
 * Magic number = sum of absolute difference of corresponding elements of subset.
 *
 * Note: You can reorder the position of elements within the subset to find the value of the magic number.
 *
 * For Ex:-
 * subset 1 = {1, 5, 1},
 * subset 2 = {1, 7, 11}
 * Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12
 * Return an array B of size 2, where B[0] = maximum possible value of Magic number modulo 109 + 7, B[1] = minimum possible value of a Magic number modulo 109 + 7.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * -109 <= A[i] <= 109
 *
 * N is even
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return an array B of size 2, where B[0] = maximum possible value of Magic number % 109 + 7,B[1] = minimum possible value of a Magic number % 109 + 7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 11, -1, 5]
 * Input 2:
 *
 *  A = [2, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [14, 10]
 * Output 2:
 *
 *  [0, 0]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All possible magical numbers:-
 *  sub1 = {3, 11}, sub2 = {-1, 5}, Magic Number = abs(3 - -1) + abs(11 - 5) = 10
 *  sub1 = {3, -1}, sub2 = {11, 5}, Magic Number = abs(3 - 11) + abs(-1 - 5) = 14
 *  sub1 = {3, 5}, sub2 = {11, -1}, Magic Number = abs(3 - 11) + abs(5 - -1) = 14
 *  sub1 = {11, -1}, sub2 = {3, 5}, Magic Number = abs(11 - 3) + abs(-1 - 5) = 14
 *  sub1 = {11, 5}, sub2 = {3, -1}, Magic Number = abs(11 - 3) + abs(5 - -1) = 14
 *  sub1 = {-1, 5}, sub2 = {3, 11}, Magic Number = abs(-1 - 3) + abs(5 - 11) = 10
 *  maximum of all magic number = 14 % 10^9 + 7 = 14
 *  minimum of all magic number = 10 % 10^9 + 7 = 10
 */
public class MaxMinMagicNumber {
    private static final int MOD = 1000000007;
    public int[] solve(int[] A) {
        //Arrays.sort(A);
        int n = A.length;
        mergeSort(A, 0, n-1);
        int mid = n/2 - 1;
        long maxMagicNumber = 0;
        for(int i=0, j=mid+1; j<n; i++, j++) {
            maxMagicNumber = (maxMagicNumber + Math.abs(A[j] - A[i])) % MOD;
        }
        long minMagicNumber = 0;
        for(int i=1; i<n; i += 2) {
            minMagicNumber = (minMagicNumber + Math.abs(A[i] - A[i-1])) % MOD;
        }
        return new int[]{(int)maxMagicNumber, (int)minMagicNumber};
    }

    private void mergeSort(int[] A, int s, int e) {
        if(s == e) {
            return;
        }
        int mid = (s + e) / 2;
        mergeSort(A, s, mid);
        mergeSort(A, mid+1, e);
        merge(A, s, mid, e);
    }

    private void merge(int[] A, int s, int mid, int e) {
        int[] result = new int[e-s+1];
        int i=s, j=mid+1, k=0;
        while(i <= mid && j <= e) {
            if(A[i] <= A[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = A[j++];
            }
        }
        while(i <= mid) {
            result[k++] = A[i++];
        }
        while(j <= e) {
            result[k++] = A[j++];
        }
        // copy to original array
        for(i=s, k=0; i<=e; i++, k++) {
            A[i] = result[k];
        }
    }
}
