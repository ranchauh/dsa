package sorting;

import java.util.Arrays;

/**
 * Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.
 * Note: Using the library sort function is not allowed.
 */
public class SortColors {

    // sort by moving red to start and blue to end of the array inline
    public static int[] sortByMoving(int[] A) {
        int n = A.length;
        int left = 0;
        int right = n-1;
        int i = 0;
        while(i <= right) {
            if(A[i] == 0) {
                swap(A, i, left);
                i++;
                left++;
            } else if(A[i] == 2) {
                swap(A, i, right);
                right--;
            } else {
                i++;
            }
        }
        return A;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // sort by count number of red, while and blue colors
    public static int[] sortColorsInPlace(int[] A) {
        int rCount = 0;
        int wCount = 0;
        int bCount = 0;
        int n = A.length;
        for(int i=0; i<n; i++) {
            if(A[i] == 0) {
                rCount++;
            } else if(A[i] == 1) {
                wCount++;
            } else {
                bCount++;
            }
        }
        // Fill rCount cells with 0
        int i = 0;
        while(i < rCount) {
            A[i] = 0;
            i++;
        }
        // Fill wCount cells with 1
        while(i < (rCount + wCount)) {
            A[i] = 1;
            i++;
        }
        // Fill bCount cells with 2
        while(i < n) {
            A[i] = 2;
            i++;
        }
        return A;
    }

    // Sort red, white and blue colors with O(n) time and space complexity.
    public static int[] sortColorAdditionalSpace(int[] A) {
        int rCount = 0;
        int wCount = 0;
        int bCount = 0;
        int n = A.length;
        for(int i=0; i<n; i++) {
            if(A[i] == 0) {
                rCount++;
            } else if(A[i] == 1) {
                wCount++;
            } else {
                bCount++;
            }
        }
        int rIdx = 0;
        int wIdx = rCount;
        int bIdx = rCount + wCount;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            if(A[i] == 0) {
                result[rIdx] = A[i];
                rIdx++;
            } else if(A[i] == 1) {
                result[wIdx] = A[i];
                wIdx++;
            } else {
                result[bIdx] = A[i];
                bIdx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(sortColorAdditionalSpace(A))); //[0 0 1 1 2 2]
        System.out.println(Arrays.toString(sortColorsInPlace(A))); //[0 0 1 1 2 2]
        System.out.println(Arrays.toString(sortByMoving(A))); //[0 0 1 1 2 2]
    }
}
