package modulo;

/**
 * Problem Description
 * Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
 *
 * "^" means power,
 * "%" means mod, and
 * "!" means factorial.
 *
 * Note: Ensure to handle integer overflow when performing the calculations.
 *
 *
 * Problem Constraints
 * 1 <= A, B <= 5e5
 *
 *
 *
 * Input Format
 * First argument is the integer A
 *
 * Second argument is the integer B
 *
 *
 *
 * Output Format
 * Return one integer, the answer to the problem
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 1
 * B = 1
 * Input 2:
 *
 * A = 2
 * B = 2
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
 *  1! = 1. Hence 1^1 = 1.
 * Explanation 2:
 *
 *  2! = 2. Hence 2^2 = 4.
 */
public class VeryLargePower {
    private static final long MOD = (long) 1e9 + 7;
    public int solve(int A, int B) {
        long fact = fact(B);
        return (int) power(A, fact);
    }

    long power(long A, long B) {
        if(B == 0) return 1;
        long pow = 1;
        while(B > 0) {
            if((B&1) == 1) {
                pow = (pow * A) % MOD;
            }
            A = ((A % MOD) *( A % MOD)) % MOD;
            B = B >> 1;
        }
        return (pow % MOD);
    }

    long fact(long B) {
        if(B==0 || B == 1) {
            return 1;
        }
        return (B * fact(B-1)) % (MOD-1);
    }

    public static void main(String[] args) {
        VeryLargePower ob = new VeryLargePower();
        System.out.println(ob.solve(2, 27)); //666348826
    }
}
