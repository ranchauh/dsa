package basic;
/*
Problem Description
You are given an integer A. You have to tell whether it is a perfect number or not.

Perfect number is a positive integer which is equal to the sum of its proper positive divisors.

A proper divisor of a natural number is the divisor that is strictly less than the number.



Problem Constraints
1 <= A <= 106



Input Format
First and only argument contains a single positive integer A.



Output Format
Return 1 if A is a perfect number and 0 otherwise.



Example Input
Input 1:

A = 4
Input 2:

A = 6


Example Output
Output 1:

0
Output 2:

1


Example Explanation
Explanation 1:

For A = 4, the sum of its proper divisors = 1 + 2 = 3, is not equal to 4.
Explanation 2:

For A = 6, the sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6.
 */
public class FindPerfectSquare {
    public int solve(int A) {
        if(A==1) return 0;
        int sum=0;
        for(int i=1; i*i <= A; i++){
            if(A%i == 0) {
                int d=A/i;
                if(d == A) sum += i;
                else sum += (i+d);
            }
        }
        return A==sum ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new FindPerfectSquare().solve(4)); // 0
        System.out.println(new FindPerfectSquare().solve(6)); // 1
    }
}
