package sorting.comparator;

import java.util.Arrays;
import java.util.Collections;

/**
Problem Description
Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.

Problem Constraints
1 <= |A| <= 2*105
-108 <= A[i] <= 108

Input Format
First and only argument is an integer array A.

Output Format
Return 1 if any such integer p is present else, return -1.

Example Input
Input 1:

 A = [3, 2, 1, 3]
Input 2:

 A = [1, 1, 3, 3]

Example Output
Output 1:

 1
Output 2:

 -1

Example Explanation
Explanation 1:

 For integer 2, there are 2 greater elements in the array..
Explanation 2:

 There exist no integer satisfying the required conditions.
 */
public class NobleInteger {
    public static int solve(int[] A) {
        A = Arrays.stream(A).
                boxed().
                sorted(Collections.reverseOrder()).
                mapToInt(i -> i).
                toArray();
        int firstOccCount = 0;
        if(A[0] == 0) {
            return 1;
        }
        for(int i=1; i<A.length; i++) {
            if(A[i] != A[i-1]) {
                firstOccCount = i;
            }
            if(A[i] == firstOccCount) {
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 3};
        System.out.println(solve(a)); // 1

        int[] b = {1, 1, 3, 3};
        System.out.println(solve(b)); // -1
    }
}
