/*
Problem Description
You are given A, B and C .
Calculate the value of (A ^ B) % C

Problem Constraints
1 <= A <= 109
0 <= B <= 105
1 <= C <= 109

Input Format
Given three integers A, B and C.

Output Format
Return an integer.

Example Input
Input 1:
A = 2
B = 3
C = 3
Input 2:
A = 5
B = 2
C = 4

Example Output
Output 1:
2
Output 2:
1

Example Explanation
For Input 1:
(2 ^ 3) % 3 = 8 % 3 = 2
For Input 2:
(5 ^ 2) % 4 = 25 % 4 = 1
 */

package modulo;

public class PowerWithModule {
    public int solve(int A, int B, int C) {
        long mul = 1;
        for(int i=1; i<=B; i++) {
            // 10^8 * 10^9 = 10^17
            // 10^9 % 10^9 <= 10^9
            mul = (mul * A) % C;
        }
        return (int) mul % C;
    }

    public static void main(String[] args) {
        PowerWithModule obj = new PowerWithModule();
        int res = obj.solve(2, 3, 3);
        System.out.println(res);
    }
}
