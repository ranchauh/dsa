package search.binary;

import java.util.Arrays;

/**
 * Problem Description
 * You are given a 2-D matrix C of size A × B.
 * You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in such a way that the cost of the newly built array is minimized.
 *
 * The cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.
 *
 * So if the newly built array is X, the element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on.
 *
 * Determine the minimum cost of the newly built array.
 *
 *
 *
 * Problem Constraints
 * 2 <= A <= 1000
 * 2 <= B <= 1000
 * 1 <= C[i][j] <= 106
 *
 *
 *
 * Input Format
 * The first argument is an integer A denoting number of rows in the 2-D array.
 * The second argument is an integer B denoting number of columns in the 2-D array.
 * The third argument is a 2-D array C of size A x B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum cost of the newly build array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 *  B = 2
 *  C = [ [8, 4]
 *       [6, 8] ]
 * Input 2:
 *
 *  A = 3
 *  B = 2
 *  C = [ [7, 3]
 *        [2, 1]
 *        [4, 9] ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).
 * Explanation 2:
 *
 *  Newly build array : [3, 2, 4]. The minimum cost will be 1 since the minimum absolute difference will be 1(3 - 2).
 */
public class MinimumDifference {
    public int solve(int[][] C) {
        // sort each row
        int n = C.length;
        for (int[] ints : C) {
            Arrays.sort(ints);
        }
        int result = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++) {
            int[] arr1 = C[i];
            int[] arr2 = C[i+1];
            for(int el : arr1) {
                int largestSmaller = searchLargestSmaller(arr2, el);
                int smallestLarger = searchSmallestLarger(arr2, el);
                int diff1 = largestSmaller == -1 ? Integer.MAX_VALUE : Math.abs(el - largestSmaller);
                int diff2 = smallestLarger == -1 ? Integer.MAX_VALUE : Math.abs(el - smallestLarger);
                int min = Math.min(diff1, diff2);
                result = Math.min(result, min);
            }
        }
        return result;
    }

    private int searchLargestSmaller(int[] arr, int k) {
        int n = arr.length;
        int s = 0, e = n-1;
        int ans = -1;
        while(s <= e) {
            int mid = s + (e-s)/2;
            if(arr[mid] <= k) {
                ans = arr[mid];
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    private int searchSmallestLarger(int[] arr, int k) {
        int n = arr.length;
        int s = 0, e = n-1;
        int ans = -1;
        while(s <= e) {
            int mid = s + (e-s)/2;
            if(arr[mid] >= k) {
                ans = arr[mid];
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumDifference ob = new MinimumDifference();
        int[][] A = {{7,3},{2,1},{4,9}};
        System.out.println(ob.solve(A)); // 1
    }
}
