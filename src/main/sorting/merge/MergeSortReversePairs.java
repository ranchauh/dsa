package sorting.merge;

import java.util.Arrays;

/**
 * Problem Description
 * Given an integer array, A of size N.
 * You have to find all possible non-empty subsequences of the array of numbers and then,
 * for each subsequence, find the difference between the largest and smallest number in that subsequence.
 * Then add up all the differences to get the number.
 *
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 *
 * NOTE: Subsequence can be non-contiguous.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10000
 *
 * 1<= A[i] <=1000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the output.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2]
 * Input 2:
 *
 * A = [3, 5, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  21
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All possible non-empty subsets are:
 * [1]     largest-smallest = 1 - 1 = 0
 * [2]     largest-smallest = 2 - 2 = 0
 * [1, 2]  largest-smallest = 2 - 1 = 1
 * Sum of the differences = 0 + 0 + 1 = 1
 * So, the resultant number is 1
 * Explanation 2:
 *
 * All possible non-empty subsets are:
 * [3]         largest-smallest = 3 - 3 = 0
 * [5]         largest-smallest = 5 - 5 = 0
 * [10]        largest-smallest = 10 - 10 = 0
 * [3, 5]      largest-smallest = 5 - 3 = 2
 * [3, 10]     largest-smallest = 10 - 3 = 7
 * [5, 10]     largest-smallest = 10 - 5 = 5
 * [3, 5, 10]  largest-smallest = 10 - 3 = 7
 * Sum of the differences = 0 + 0 + 0 + 2 + 7 + 5 + 7 = 21
 * So, the resultant number is 21
 */
public class MergeSortReversePairs {
    public int solve(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }

    private int mergeSort(int[] A, int s, int e) {
        if(s == e) {
            return 0;
        }
        int mid = (s + e) / 2;
        int c1 = mergeSort(A, s, mid);
        int c2 = mergeSort(A, mid+1, e);
        int c3 = merge(A, s, mid, e);
        return c1 + c2 + c3;
    }

    private int merge(int[] A, int s, int mid, int e) {
        int i=s, j=mid+1, k=0;
        int[] result = new int[e - s + 1];
        int count = 0;
        while(i <= mid && j <= e) {
            if(A[i] <= A[j]) {
                i++;
            } else {
                if(A[i] > (2L * A[j])) {
                    count += (mid - i + 1);
                }
                j++;
            }
        }
        i = s;
        j = mid + 1;
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
        // copy
        for(i = s, k=0; i <= e; i++, k++) {
            A[i] = result[k];
        }
        return count;
    }

    private void printArray(int[] A, int s, int e) {
        System.out.print(" [");
        for(int i=s; i<=e; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.print("] ");
    }

    public static void main(String[] args) {
        MergeSortReversePairs ob = new MergeSortReversePairs();
        int[] A = {14046,57239,78362,99387,27609,55100,65536,62099,40820,33056,88380,78549,57512,33137,81212,32365,42276,65368,52459,74924,25355,76044,78056,45190,94365,58869,20611};
        System.out.println(Arrays.toString(A));
        System.out.println(ob.solve(A));
    }
}
