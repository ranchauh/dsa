package sorting;

import java.util.Arrays;

/*
Problem Description
You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.

Note: You cannot use any extra space


Problem Constraints
1 <= N <= 104
1 <= A[i] <= 104


Input Format
First argument A is an array of integers.


Output Format
Return an array of integers.


Example Input
Input 1:
A = [6, 8, 9]
Input 2:
A = [2, 4, 7]


Example Output
Output 1:
[9, 6, 8]
Output 2:
[2, 7, 4]


Example Explanation
For Input 1:
The number 9 has 3 factors, 6 has 4 factors and 8 has 4 factors.
For Input 2:
The number 2 has 2 factors, 7 has 2 factors and 4 has 3 factors.
 */
public class FactorSort {
    public static int[] solve(int[] A) {
        A = Arrays.stream(A).
                boxed().
                sorted(FactorSort::compare). // sort descending
                mapToInt(i -> i).
                toArray();
        return A;
    }

    public static int compare(int a, int b) {
        int x = countFactors(a);
        int y = countFactors(b);
        if(x > y) {
            return 1;
        } else if (x < y) {
            return -1;
        } else {
            return Integer.compare(a, b);
        }
    }

    public static int countFactors(int A) {
        int count = 0 ;
        for(int i = 1; (i*i) <= A; i++) {
            if(A%i == 0) {
                if(A/i == i) count++;
                else count += 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {6, 8, 9};
        System.out.println(Arrays.toString(solve(a))); // 9, 6, 8

        int[] b = {2, 4, 7};
        System.out.println(Arrays.toString(solve(b))); // 2, 7, 4
    }
}
