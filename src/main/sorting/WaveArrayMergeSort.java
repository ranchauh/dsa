package sorting;

import java.util.Arrays;

/**
 * Problem Description
 * Given an array of integers A, sort the array into a wave-like array and return it.
 * In other words, arrange the elements into a sequence such that
 *
 * a1 >= a2 <= a3 >= a4 <= a5.....
 * NOTE: If multiple answers are possible, return the lexicographically smallest one.
 *
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 106
 * 1 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * The first argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an array arranged in the sequence as described.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 * [2, 1, 4, 3]
 * Output 2:
 *
 * [2, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 * First answer is lexicographically smallest. So, return [2, 1, 4, 3].
 * Explanation 1:
 *
 * Only possible answer is [2, 1].
 */
public class WaveArrayMergeSort {
    public int[] wave(int[] A) {
        int n = A.length;
        // sort the array
        mergeSort(A, 0, n-1);
        System.out.println(Arrays.toString(A));
        for(int i=1; i<n; i += 2) {
            swap(A, i-1, i);
        }
        return A;
    }

    private void swap(int[] A, int a, int b) {
        int t = A[a];
        A[a] = A[b];
        A[b] = t;
    }

    private void mergeSort(int[] A, int s, int e) {
        if(s == e) {
            return;
        }
        int mid = (s + e) / 2;
        mergeSort(A, s, mid);
        mergeSort(A, mid + 1, e);
        merge(A, s, mid, e);
    }

    private void merge(int[] A, int s, int mid, int e) {
        int i = s, j=mid+1, k=0;
        int[] result = new int[e - s + 1];
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
        for(i=s, k=0; i <= e; i++, k++) {
            A[i] = result[k];
        }
    }

    public static void main(String[] args) {
        WaveArrayMergeSort ob = new WaveArrayMergeSort();
        int[] A = {5,1,3,2,4};
        System.out.println(Arrays.toString(ob.wave(A)));
    }
}
