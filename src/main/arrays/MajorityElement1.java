package arrays;

/**
 * Problem Description
 * Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 * You may assume that the array is non-empty and the majority element always exists in the array.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 5*105
 * 1 <= num[i] <= 109
 *
 *
 * Input Format
 * Only argument is an integer array.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * Input 1:
 * [2, 1, 2]
 * Input 2:
 * [1, 1, 1]
 *
 *
 * Example Output
 * Input 1:
 * 2
 * Input 2:
 * 1
 *
 *
 * Example Explanation
 * For Input 1:
 * 2 occurs 2 times which is greater than 3/2.
 * For Input 2:
 *  1 is the only element in the array, so it is majority
 */
public class MajorityElement1 {
    public int majorityElement(final int[] A) {
        int n = A.length;
        int majority = A[0];
        int freq = 1;

        for(int i=1; i<n; i++) {
            if(freq == 0) {
                majority = A[i];
                freq = 1;
            } else if(A[i] != majority) {
                freq--;
            } else {
                freq++;
            }
        }
        freq = 0;
        for (int v : A) {
            if(v == majority) {
                freq++;
            }
        }
        if(freq > n/2) {
            return majority;
        }
        return -1;

    }

    public static void main(String[] args) {
        MajorityElement1 ob = new MajorityElement1();
        System.out.println(ob.majorityElement(new int[]{4,4,3,8,8,4,9,4,4}));// 4
        System.out.println(ob.majorityElement(new int[]{1, 2, 3}));// -1
    }
}
