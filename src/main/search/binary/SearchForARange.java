package search.binary;

import java.util.Arrays;

/**
 * Problem Description
 * Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
 *
 * Return an array of size 2, such that
 *           First element = Left most index of B in A
 *           Second element = Right most index of B in A.
 * If B is not found in A, return [-1, -1].
 *
 * Note : Your algorithm's runtime complexity must be in the order of O(log n).
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 * 1 <= A[i], B <= 109
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 * Output Format
 * Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, 7, 7, 8, 8, 10]
 *  B = 8
 * Input 2:
 *
 *  A = [5, 17, 100, 111]
 *  B = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  [3, 4]
 * Output 2:
 *
 *  [-1, -1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The first occurrence of 8 in A is at index 3.
 *  The last occurrence of 8 in A is at index 4.
 *  ans = [3, 4]
 * Explanation 2:
 *
 *  There is no occurrence of 3 in the array.
 */
public class SearchForARange {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] searchRange(final int[] A, int B) {
        int n = A.length;
        int s = 0, e = n-1;
        int[] result = new int[2];
        result[0] = result[1] = -1;
        while(s <= e) {
            int mid = s + (e - s)/2;
            if(A[mid] == B) {
                if(mid == 0 || A[mid] > A[mid-1]) {
                    result[0] = mid;
                    break;
                }
                e = mid - 1;
            } else if(A[mid] > B) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        if(result[0] != -1) {
            result[1] = result[0];
            s = result[0] + 1;
            e = n - 1;
            while(s <= e) {
                int mid = s + (e - s)/2;
                if(A[mid] == B) {
                    if(mid == n-1 || A[mid] < A[mid+1]) {
                        result[1] = mid;
                        break;
                    }
                    s = mid + 1;
                } else if(A[mid] > B) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SearchForARange ob = new SearchForARange();
        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 8;
        System.out.println(Arrays.toString(ob.searchRange(A, B))); // [3, 4]
        int[] AA = {5, 17, 100, 111};
        int BB = 3;
        System.out.println(Arrays.toString(ob.searchRange(AA, BB))); // [-1, -1]
    }
}
