package serach.binary;

/**
 * Problem Description
 * Given a sorted array of integers A of size N and an integer B,
 * where array A is rotated at some pivot unknown beforehand.
 *
 * For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
 *
 * Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
 *
 * You can assume that no duplicates exist in the array.
 *
 * NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 * 1 <= A[i] <= 109
 * All elements in A are Distinct.
 *
 *
 * Input Format
 * The First argument given is the integer array A.
 * The Second argument given is the integer B.
 *
 *
 * Output Format
 * Return index of B in array A, otherwise return -1
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [4, 5, 6, 7, 0, 1, 2, 3]
 * B = 4
 * Input 2:
 *
 * A : [ 9, 10, 3, 5, 6, 8 ]
 * B : 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Target 4 is found at index 0 in A.
 * Explanation 2:
 *
 * Target 5 is found at index 3 in A.
 */
public class RotatedSortedArraySearch {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(final int[] A, int B) {
        //return threeBinarySearch(A, 0, A.length-1, B);
        return oneBinarySearch(A, 0, A.length - 1, B);
    }

    private int threeBinarySearch(int[] A, int s, int e, int B) {
        int peak = findPeak(A);
        int idx = binarySearch(A, 0, peak, B);
        if(idx != -1) {
            return idx;
        }
        return binarySearch(A, peak+1, e, B);
    }

    private int binarySearch(int[] A, int s, int e, int B) {
        while(s <= e) {
            int mid = s + (e-s)/2;
            if(A[mid] == B) {
                return mid;
            }
            if(A[mid] > B) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    private int findPeak(int[] A) {
        int s = 0, e = A.length - 2;
        while(s <= e) {
            int mid = s + (e-s)/2;
            if(A[mid] > A[mid + 1]) {
                return mid;
            }
            if(A[mid] > A[0]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    private int oneBinarySearch(int[] A, int s, int e, int B) {
        while(s <= e) {
            int mid = s + (e-s)/2;
            if(A[mid] == B) {
                return mid;
            }
            if(B >= A[0]) { // B is in part 1
                if(A[mid] < A[0]) { // mid is in part 2
                    e  = mid - 1;
                } else if (A[mid] > B) { // mid is in part 1
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else { // B is in part 2
                if(A[mid] > A[e]) { // mid is in part 1
                    s = mid + 1;
                } else if(A[mid] < B) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotatedSortedArraySearch ob = new RotatedSortedArraySearch();
        int[] A = {4,5,6,7,0,1,2};
        int B = 4;
        System.out.println(ob.search(A, B)); // 0
    }
}
