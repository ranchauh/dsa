package sorting.comparator;

import java.util.Arrays;

/**
Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format
The first argument is an array of integers.



Output Format
Return a string representing the largest number.



Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */
public class LargestNumber {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static String largestNumber(final int[] A) {
        String[] strArr = new String[A.length];
        for(int i=0; i<A.length; i++) {
            strArr[i] = String.valueOf(A[i]);
        }
        Arrays.sort(strArr, LargestNumber::compare);
        StringBuilder result = new StringBuilder();
        for (String j : strArr) {
            result.append(j);
        }
        // edge case when all elements are [0, 0, 0, 0]
        int pos = 0;
        while(pos + 1 < result.length() && result.charAt(pos) == '0') {
            pos++;
        }
        return result.substring(pos);
    }

    private static int compare(String x, String y) {
        String a = x+y;
        String b = y+x;
        return b.compareTo(a);
    }

    public static void main(String[] args) {
        int[] arr = {8, 89};
        System.out.println(largestNumber(arr)); // 898

        int[] arr1 = { 3, 30, 34, 5, 9 };
        System.out.println(largestNumber(arr1)); // 9534330

        int[] arr2 = { 0, 0, 0 , 0, 0 };
        System.out.println(largestNumber(arr2)); // 9534330
    }
}
