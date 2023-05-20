package bit;

/**
 * Problem Description
 * Given an array B of length A with elements 1 or 0. Find the number of subarrays such that the bitwise OR of all the elements present in the subarray is 1.
 * Note : The answer can be large. So, return type must be long.
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 *
 * Input Format
 * The first argument is a single integer A.
 * The second argument is an integer array B.
 *
 *
 * Output Format
 * Return the number of subarrays with bitwise array 1.
 *
 *
 * Example Input
 * Input 1:
 *  A = 3
 * B = [1, 0, 1]
 * Input 2:
 *  A = 2
 * B = [1, 0]
 *
 *
 * Example Output
 * Output 1:
 * 5
 * Output2:
 * 2
 *
 *
 * Example Explanation
 * Explanation 1:
 * The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
 * Except the subarray [0] all the other subarrays has a Bitwise OR = 1
 * Explanation 2:
 * The subarrays are :- [1], [0], [1, 0]
 * Except the subarray [0] all the other subarrays has a Bitwise OR = 1
 */
public class SubArrayWithBitwiseOR1 {
    public static long solve(int A, int[] B) {
        long count=0;
        long lastCount = 0;
        for(int i=A-1; i>=0; i--) {
            if(B[i] == 1) {
                lastCount = (long) (A - i) * B[i];
            }
            count = count + lastCount;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(3, new int[]{1, 0, 1})); //5
        System.out.println(solve(2, new int[]{1, 0})); //2
    }
}
