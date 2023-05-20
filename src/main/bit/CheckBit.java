package bit;

/**
 * Problem Description
 * You are given two integers A and B.
 * Return 1 if B-th bit in A is set
 * Return 0 if B-th bit in A is unset
 * Note:
 * The bit position is 0-indexed, which means that the least significant bit (LSB) has index 0.
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 * 0 <= B <= 30
 *
 *
 * Input Format
 * First argument A is an integer.
 * Second argument B is an integer.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * Input 1:
 * A = 4
 * B = 1
 * Input 2:
 * A = 5
 * B = 2
 *
 *
 * Example Output
 * Output 1:
 * 0
 * Output 2:
 * 1
 */
public class CheckBit {
    public int solve(int A, int B) {
        if((A&(1 << B)) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
