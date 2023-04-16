package modulo;

import java.util.Arrays;

/*
Problem Description
Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.

Return the minimum result obtained.



Problem Constraints
10 <= A, B, C <= 99



Input Format
The first argument of input contains an integer, A.

The second argument of input contains an integer, B.

The third argument of input contains an integer, C.



Output Format
Return an integer representing the answer.



Example Input
Input 1:

 A = 10
 B = 20
 C = 30
Input 2:

 A = 55
 B = 43
 C = 47


Example Output
Output 1:

 102030
Output 2:

 434755


Example Explanation
Explanation 1:

 10 + 20 + 30 = 102030
Explanation 2:

 43 + 47 + 55 = 434755
 */
public class ConcatenateThreeNumbers {
    public int solve(int A, int B, int C) {
        int max = Math.max(A, Math.max(B, C));
        int min = Math.min(A, Math.min(B, C));
        int mid = A + B + C - max - min;
        return mergeNum(max, mid, min);
    }

    private int mergeNum(int A, int B, int C) {
        int num = 0;
        int mul = 1;
        while(A>0) {
            num = num + (A%10) * mul;
            mul = mul * 10;
            A = A/10;
        }
        while(B>0) {
            num = num + (B%10) * mul;
            mul = mul * 10;
            B = B/10;
        }
        while(C>0) {
            num = num + (C%10) * mul;
            mul = mul * 10;
            C = C/10;
        }
        return num;
    }

    public int solve2(int A, int B, int C) {
        int[] a = {A, B, C};
        Arrays.sort(a);
        return 10000*a[0] + 100*a[1] + a[2];
    }

    public static void main(String[] args) {
        ConcatenateThreeNumbers obj = new ConcatenateThreeNumbers();
        int res = obj.solve(10, 20, 30);
        System.out.println(res);
        res = obj.solve2(10, 20, 30);
        System.out.println(res);
    }
}
