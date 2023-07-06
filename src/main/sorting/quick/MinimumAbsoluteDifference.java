package sorting.quick;

/**
 * Problem Description
 * Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] | where i != j and |x| denotes the absolute value of x.
 *
 *
 *
 * Problem Constraints
 * 2 <= length of the array <= 100000
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the minimum value of | A[i] - A[j] |.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The absolute difference between any two adjacent elements is 1, which is the minimum value.
 * Explanation 2:
 *
 *  The minimum value is 6 (|11 - 5| or |17 - 11|).
 */
public class MinimumAbsoluteDifference {
    public int solve(int[] A) {
        int n = A.length;
        //Arrays.sort(A);
        quickSort(A, 0, n-1);
        int minVal =  Math.abs(A[1] - A[0]);
        for(int i = 2; i < n; i++) {
            int min = Math.abs(A[i] - A[i-1]);
            minVal = Math.min(minVal, min);
        }
        return minVal;
    }

    private void quickSort(int[] A, int s, int e) {
        if(s >= e) {
            return;
        }
        int idx = arrangeNthElement(A, s, e);
        quickSort(A, s, idx - 1);
        quickSort(A, idx + 1, e);
    }

    private int arrangeNthElement(int[] A, int s, int e) {
        int p1 = s+1, p2=e;
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

    private void swap(int[] A, int x, int y) {
        int t = A[x];
        A[x] = A[y];
        A[y] = t;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifference ob = new MinimumAbsoluteDifference();
        int[] A = {5, 17, 100, 11};
        System.out.println(ob.solve(A)); // 6
    }
}
