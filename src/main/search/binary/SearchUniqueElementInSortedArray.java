package search.binary;

/**
 * Problem Description
 * Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
 *
 * Elements which are appearing twice are adjacent to each other.
 *
 * NOTE: Users are expected to solve this in O(log(N)) time.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 10^9
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the single element that appears only once.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 1, 7]
 * Input 2:
 *
 * A = [2, 3, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 *  7
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  7 appears once
 * Explanation 2:
 *
 *  2 appears once
 */
public class SearchUniqueElementInSortedArray {
    public int solve(int[] A) {
        int n = A.length;
        if(n == 1) {
            return A[0];
        } else if(A[0] != A[1]) {
            return A[0];
        } else if(A[n-2] != A[n-1]) {
            return A[n-1];
        } else {
            return searchSingleElement(A, 1, n-2);
        }
    }

    // apply binary search
    private int searchSingleElement(int[] A, int s, int e) {
        while(s <= e) {
            int mid = s + (e-s)/2;
            if(A[mid] != A[mid-1] && A[mid] != A[mid+1]) {
                return A[mid];
            }
            if(A[mid] == A[mid-1]) {
                mid = mid - 1;
            }
            if(mid % 2 == 0) {
                s = mid + 2;
            } else {
                e = mid  - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchUniqueElementInSortedArray ob = new SearchUniqueElementInSortedArray();
        int[] A = {1,1,2,2,3,4,4,5,5};
        System.out.println(ob.solve(A)); // 3
        System.out.println(ob.solve(new int[]{1,1})); //-1
    }
}
