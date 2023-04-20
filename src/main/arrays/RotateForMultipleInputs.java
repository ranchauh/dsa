package arrays;

import java.util.Arrays;

/**
 * Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.
 * Find the rotated array for each value and return the result in the from of a matrix where ith row represents the rotated array for the ith value in B.
 */
public class RotateForMultipleInputs {
    public int[][] solve(int[] A, int[] B) {
        int n = B.length;
        int[][] result = new int[n][A.length];
        for(int i=0; i<n; i++) {
            //result[i] = rotateArray(A, B[i]);
            result[i] = rotateArrayApproach2(A, B[i]);
        }
        return result;
    }

    private int[] rotateArrayApproach2(int[] A, int k) {
        int n = A.length;
        int[] rotated = new int[n];
        for(int i=0; i<n; i++) {
            rotated[i] = A[(i+k) % n];
        }
        return rotated;
    }

    private int[] rotateArray(int[] A, int k) {
        int n = A.length;
        k = k % n;
        int[] rotated = new int[n];
        int cur = 0;
        // Skip k elements in original array and insert rest of the elements in result
        for(int i=k; i<n; i++) {
            rotated[cur] = A[i];
            cur++;
        }
        // Now insert remaining k elements from the start of the original array
        for(int i=0; i<k; i++) {
            rotated[cur] = A[i];
            cur++;
        }
        return rotated;
    }

    public static void main(String[] args) {
        RotateForMultipleInputs obj = new RotateForMultipleInputs();
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 3};
        int[][] result = obj.solve(A, B);
        // [ [3, 4, 5, 1, 2]
        //   [4, 5, 1, 2, 3] ]
        for(int[] x: result) {
            System.out.println(Arrays.toString(x));
        }
    }
}
