package combinatorics;

/**
 * Problem Description
 * Given a positive integer A.
 *
 * Return the number of ways it can be written as a sum of consecutive positive integers.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 *
 *
 * Input Format
 * The first and the only argument of input contains an integer, A.
 *
 *
 *
 * Output Format
 * Return an integer, representing the answer as described in the problem statement.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 * Input 2:
 *
 *  A = 15
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The 2 ways are:
 *  => [5]
 *  => [2, 3]
 * Explanation 2:
 *
 *  The 4 ways are:
 *  => [15]
 *  => [7, 8]
 *  => [4, 5, 6]
 *  => [1, 2, 3, 4, 5]
 */
public class ConsecutiveNumberSum {
    /**
     Let's consider x be the first digit in the consecutive terms and there are k terms. So
     => x + (x+1) + (x+2)....(x+k-1) = A
     which can be simplified to:
     => kx + k(k-1)/2 = A
     => x = (A - k(k-1)/2)/k
     To find out x, We can try for each k from 1 to the max value where above equation is greater than 0.
     and if the equation is divisible by k it can be counted.
     We can further simplify the above equation:
     => (A - k(k-1)/2)/k  > 0
     => k(k-1)/2k > A
     => A < k(k-1)/2
     => k(k-1) < 2A
     => (k-1)(k-1) < 2A , eg. if 5*4 < 30, then 4*4 < 30
     => (k-1)^2 < 2A
     => (k-1) < sqrt(2A)
     */
    public static int solve(int A) {
        int count = 0;
        for(int i=1; i*i < 2*A; i++) {
            int t = A - (i * (i-1))/2;
            if(t % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(15)); //4
    }
}
