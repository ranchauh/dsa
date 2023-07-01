package arrays.twopointers;

/**
 * Problem Description
 * Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
 *
 * Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 10^9
 *
 * 1 <= B <= 10^9
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 * Return the number of pairs for which sum is equal to B modulo (10^9+7).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 1, 1]
 * B = 2
 * Input 2:
 *
 * A = [1, 5, 7, 10]
 * B = 8
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The pairs of A[i] and A[j] which sum up to 2 are (0, 1), (0, 2) and (1, 2).
 *  There are 3 pairs.
 * Explanation 2:
 *
 *  There is only one pair, such that i = 0, and j = 2 sums up to 8.
 */
public class AllPairsWithGivenSum {
    private static final long MOD = 1000000007;
    public int solve(int[] A, int B) {
        int n = A.length;
        int p1 = 0;
        int p2 = n-1;
        long count = 0;
        while(p1 < p2) {
            int sum = A[p1] + A[p2];
            if(sum == B) {
                int i = p1, j = p2;
                if(A[i] == A[j]) {
                    long c = j - i + 1;
                    count += (c * (c-1)/2) % MOD;
                    count %= MOD;
                    break;
                } else {
                    while(A[i] == A[p1]) {
                        i++;
                    }
                    long c1 = i - p1;
                    while(A[j] == A[p2]) {
                        j--;
                    }
                    long c2 = p2 - j;
                    long cnt = (c1 * c2) % MOD;
                    count = (count + cnt) % MOD;
                    p1 = i;
                    p2 = j;
                }
            } else if(sum < B) {
                p1++;
            } else {
                p2--;
            }
        }
        return (int) count;
    }

    public static void main(String[] args) {
        AllPairsWithGivenSum ob = new AllPairsWithGivenSum();
        int[] A = {1,2,6,6,7,9,9};
        int B = 13;
        System.out.println(ob.solve(A, B)); // 2
    }
}
