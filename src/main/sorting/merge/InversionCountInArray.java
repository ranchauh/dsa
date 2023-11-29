package sorting.merge;

/**
 * Problem Description
 * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the number of inversions of A modulo (109 + 7).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 3, 2]
 * Input 2:
 *
 * A = [3, 4, 1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
 * Explanation 2:
 *
 * The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
 * The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
 * The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
 * The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]
 */
public class InversionCountInArray {
    private static final int MOD = 1000000007;

    public int solve(int[] A) {
        int n = A.length;
        return countPairs(A, 0, n-1);
    }

    int countPairs(int[] A, int start, int end) {
        // If both pointers are same, we just have 1 element, so no pair possible
        if(start == end) {
            return 0;
        }
        // divide the array into two parts and count pairs in each part.
        int mid = (start + end) / 2;
        int leftPairsCount = countPairs(A, start, mid);
        int rightPairsCount = countPairs(A, mid + 1, end);
        // count the pair combining the two parts as well
        int combinedPairs = merge(A, start, mid, end);
        // return sum of all pairs.
        return (((leftPairsCount + rightPairsCount) % MOD) + combinedPairs) % MOD;
    }

    int merge(int[] A, int start, int mid, int end) {
        // first part: A[start] till A[mid]
        // second part A[mid+1] till A[end]
        int[] result = new int[end - start + 1];
        int i=start, j=mid+1, k=0;
        int pairs = 0;
        // compare both parts of array and copy in sorted order
        while(i <= mid && j <= end) {
            if(A[i] <= A[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = A[j++];
                pairs += ((mid - i + 1) % MOD);
            }
        }
        // copy remaining elements from the left part
        while(i <= mid) {
            result[k++] = A[i++];
        }
        // copy remaining elements from the right part
        while(j <= end) {
            result[k++] = A[j++];
        }
        // copy into original array
        for(i=start, k=0; i<=end; i++, k++) {
            A[i] = result[k];
        }
        return pairs % MOD;
    }

    public static void main(String[] args) {
        InversionCountInArray ob = new InversionCountInArray();
        int[] A = {3, 4, 1, 2};
        System.out.println(ob.solve(A)); // 4
        System.out.println(ob.solve(new int[]{10,3,8,15,6,12,2,18,7,1})); // 26

    }
}
