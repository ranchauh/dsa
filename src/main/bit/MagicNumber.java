package bit;

/**
 * Problem Description
 * Given an integer A, find and return the Ath magic number.
 *
 * A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
 *
 * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 5000
 *
 *
 *
 * Input Format
 * The only argument given is integer A.
 *
 *
 *
 * Output Format
 * Return the Ath magic number.
 *
 *
 *
 * Example Input
 * Example Input 1:
 *
 *  A = 3
 * Example Input 2:
 *
 *  A = 10
 *
 *
 * Example Output
 * Example Output 1:
 *
 *  30
 * Example Output 2:
 *
 *  650
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
 *  3rd element in this is 30
 * Explanation 2:
 *
 *  In the sequence shown in explanation 1, 10th element will be 650.
 */
public class MagicNumber {
    public int solve(int A) {
        int res = 0;
        int pow = 1;
        int shift = 0;
        while(A>0) {
            if((A&(1<<shift)) == 1) {
                res += Math.pow(5, pow);
            }
            A = A>>1;
            pow++;
        }
        return res;
    }
}

/*
1. 5  = 5^1         1
2. 25 = 5^2         1 0
3. 30 = 5^2 + 5     1 1
4. 125 = 5^3        1 0 0
5. 130 = 5^3+5      1 0 1
6. 150 = 5^3+5^2    1 1 0
7. 155 = 5^3+5^2+5  1 1 1
8. 625 = 5^4
9. 630 = 5^4+5
10. 650 = 5^4+5^2
11. 655 = 5^4+5^2+5
12. 750 = 5^4+5^3
13. 755 = 5^4+5^3+5
14. 775 = 5^4+5^3+5^2
15. 780 = 5^4+5^3+5^2+5
*/


