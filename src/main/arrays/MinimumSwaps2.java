package arrays;

/**
 * Problem Description
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
 *
 * It is allowed to swap any two elements (not necessarily consecutive).
 *
 * Find the minimum number of swaps required to sort the array in ascending order.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= A[i] < N
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the minimum number of swaps.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 0]
 * Input 2:
 *
 * A = [2, 0, 1, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * 4
 * Output 2:
 *
 * 2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * There are many ways, to make the array sorted,
 *
 * One of the sequence of swaps as follow:
 *     Initial array   ->   [1, 2, 3, 4, 0]
 *  swapping (1, 2) becomes [2, 1, 3, 4, 0]
 *  swapping (2, 3) becomes [3, 1, 2, 4, 0]
 *  swapping (4, 0) becomes [3, 1, 2, 0, 4]
 *  swapping (3, 0) becomes [0, 1, 2, 3, 4].
 * Thus the array is sorted in 4 swaps.  It cannot be sorted inlesser than 4 swaps.
 * Explanation 2:
 *
 * One of the sequence of swaps as follow:
 *     Initial array  ->    [2, 0, 1, 3]
 *  swapping (2, 0) becomes [0, 2, 1, 3]
 *  swapping (1, 2) becomes [0, 1, 2, 3].
 *
 * Thus the array is sorted in 2 swaps. It cannot be sorted in lesser than 4 swaps.
 */
public class MinimumSwaps2 {
    public int solve(int[] A) {
        int n = A.length;
        int count = 0;
        for(int i=0; i<n-1; i++) {
            if(A[i] == i) {
                continue;
            }
            while(A[i] != i) {
                swap(A, i, A[i]);
                count++;
            }
        }
        return count;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        MinimumSwaps2 ob = new MinimumSwaps2();
        System.out.println(ob.solve(new int[] {2, 0, 1, 3})); // 2
        System.out.println(ob.solve(new int[] {6,50,16,30,37,12,43,52,24,2,53,28,31,36,10,32,51,60,64,38,3,46,7,4,55,72,75,66,73,68,54,22,25,65,5,49,0,8,47,78,35,57,83,90,27,9,19,26,76,41,39,40,1,11,67,61,71,56,58,108,110,102,15,70,59,14,42,23,29,20,118,13,106,17,69,18,21,34,44,62,33,80,45,87,48,63,74,131,134,111,77,79,81,139,132,124,82,84,85,86,88,89,91,92,93,130,94,98,95,96,151,97,99,100,109,101,142,103,143,104,105,146,107,112,113,138,114,115,116,117,160,119,120,148,145,121,122,123,125,126,127,135,128,153,129,133,144,136,137,140,141,147,149,150,152,154,155,156,157,158,159})); //154
    }
}
