package arrays;

/**
 * Problem Description
 * You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
 * If so, return the integer. If not, return -1.
 *
 * If there are multiple solutions, return any one.
 *
 * Note: Read-only array means that the input array should not be modified in the process of solving the problem
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 7*105
 * 1 <= A[i] <= 109
 *
 *
 * Input Format
 * The only argument is an integer array A.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * Input 1:
 * [1 2 3 1 1]
 * Input 2:
 * [1 2 3]
 *
 *
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * -1
 *
 *
 * Example Explanation
 * Explanation 1:
 * 1 occurs 3 times which is more than 5/3 times.
 * Explanation 2:
 * No element occurs more than 3 / 3 = 1 times in the array.
 */
public class MajorityElement2 {


    public int repeatedNumber(int[] A) {
        int n = A.length;
        if(n < 2) {
            return A[0];
        }
        int nBy3 = n/3;
        int majority1 = -1;
        int majority2 = -1;
        int freq1 = 0;
        int freq2 = 0;
        for(int v : A) {
            if(v == majority1) {
                freq1++;
            } else if(v == majority2) {
                freq2++;
            } else if(freq1 == 0) {
                majority1 = v;
                freq1 = 1;
            } else if(freq2 == 0) {
                majority2 = v;
                freq2 = 1;
            } else {
                freq1--;
                freq2--;
            }
        }
        freq1 = 0;
        freq2 = 0;
        for(int v : A) {
            if(v == majority1) {
                freq1++;
            } else if(v == majority2) {
                freq2++;
            }
        }
        if(freq1 > nBy3) {
            return majority1;
        } else if(freq2 > nBy3) {
            return majority2;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        MajorityElement2 ob = new MajorityElement2();
        System.out.println(ob.repeatedNumber(new int[]{1, 2, 3, 1, 1}));// 1
        System.out.println(ob.repeatedNumber(new int[]{1, 2, 3}));// -1
    }
}
