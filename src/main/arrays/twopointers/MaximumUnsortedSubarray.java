package arrays.twopointers;

import java.util.Arrays;

/**
 * Problem Description
 * Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.
 *
 * Note :
 * Follow 0-based indexing, while returning the sub-array's starting and ending indexes.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 * 1 <= A[i] <= 1000000
 *
 *
 *
 * Input Format
 * First and only argument is an array of non-negative integers of size N.
 *
 *
 *
 * Output Format
 * Return an array of length two where,
 * the first element denotes the starting index(0-based) and
 * the second element denotes the ending index(0-based) of the sub-array.
 * If the array is already sorted, return an array containing only one element i.e. -1.
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 3, 2, 4, 5]
 * Input 2:
 *
 * A = [1, 2, 3, 4, 5]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1, 2]
 * Output 2:
 *
 * [-1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * If we sort the sub-array [A1, A2] then the whole array A gets sorted.
 * Explanation 2:
 *
 * A is already sorted.
 */
public class MaximumUnsortedSubarray {
        /**
         Assume that Al ,..., Ar is the minimum-unsorted-subarray which is to be sorted.
         then min(Al,..., Ar) >= max(A0,..., Al-1)
         and max(Al,..., Ar) <= min(Ar+1,..., AN-1)
         */
    public int[] subUnsort(int[] A) {
        int n = A.length;
        int i = 0, j = n-1;
        // find the left most index till the array is sorted.
        while(i < n - 1 && A[i] <= A[i+1]) {
            i++;
        }
        // if the array is already sorted return -1
        if(i == n - 1) {
            return new int[] {-1};
        }
        // find the right most index till the array is sorted.
        while(j > 0 && A[j] >= A[j-1]) {
            j--;
        }
        // find the min and max element between A[i] and A[j]
        int max = A[i];
        int min = A[j];
        for(int k=i; k<=j; k++) {
            max = Math.max(max, A[k]);
            min = Math.min(min, A[k]);
        }
        // find the left index (l) which is <= the min element.
        int l = 0;
        while(l <= i && A[l] <= min) {
            l++;
        }
        // find the right index (r) which is >= the max element.
        int r = n - 1;
        while(r >= j && A[r] >= max) {
            r--;
        }
        return new int[] {l, r};
    }
    //1, 1
    public static void main(String[] args) {
        MaximumUnsortedSubarray ob = new MaximumUnsortedSubarray();
        System.out.println(Arrays.toString(ob.subUnsort(new int[]{1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15}))); // [4, 10]
        System.out.println(Arrays.toString(ob.subUnsort(new int[]{1, 1}))); // [-1]
    }
}
