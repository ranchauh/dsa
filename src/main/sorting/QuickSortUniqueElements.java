package sorting;

import java.util.Arrays;

/**
 * Problem Description
 * You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.
 *
 * Find the minimum number of steps.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is an Array A, having N integers.
 *
 *
 *
 * Output Format
 * Return the minimum number of steps required to make all elements unique.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 1, 3]
 * Input 2:
 *
 *  A = [2, 4, 5]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
 * Explanation 2:
 *
 *  All elements are distinct.
 */
public class QuickSortUniqueElements {
    public int solve(int[] A) {
        int n = A.length;
        // Sort the array using quick Sort
        quickSort(A, 0, n-1);
        System.out.println(Arrays.toString(A));
        int count = 0;
        for(int i=1; i<n; i++) {
            if(A[i] == A[i-1]) {
                A[i]++;
                count++;
            } else if(A[i] < A[i-1]) {
                int nextVal = A[i-1] + 1;
                int diff = nextVal - A[i];
                A[i] = nextVal;
                count = count + diff;
            }
        }
        return count;
    }

    private void quickSort(int[] A, int s, int e) {
        if(s >= e) {
            // s == e : base case
            // s > e: cautionary check
            return;
        }
        int p = rearrange(A, s, e);
        quickSort(A, s, p-1);
        quickSort(A, p+1, e);
    }

    private int rearrange(int[] A, int s, int e) {
        int p1 = s + 1;
        int p2 = e;
        while(p1 <= p2) {
            if(A[s] > A[p1]) {
                p1++;
            } else if(A[s] <= A[p2]) {
                p2--;
            } else {
                swap(A, p1, p2);
                p1++;
                p2--;
            }
        }
        swap(A, s, p2);
        return p2;
    }

    private void swap(int[] A, int a, int b) {
        int t = A[a];
        A[a] = A[b];
        A[b] = t;
    }

    public static void main(String[] args) {
        QuickSortUniqueElements ob =  new QuickSortUniqueElements();
        int[] A = {1,3,1,4,8,3,4,8,9};
        System.out.println(ob.solve(A)); // 7

        int[] B = {51,6,10,8,22,61,56,48,88,85,21,98,81,76,71,68,18,6,14,23,72,18,56,30,97,100,81,5,99,2,85,67,46,32,66,51,76,53,36,31,81,56,26,75,69,54,54,54,83,41,86,48,7,32,85,23,47,23,18,45,79,95,73,15,55,16,66,73,13,85,14,80,39,92,66,20,22,25,34,14,51,14,17,10,100,35,9,83,31,60,24,37,69,62};
        System.out.println(ob.solve(B)); // 239
    }
}
