package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an array A of N integers. Count the number of elements that have at least 1 elements greater than itself.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109


Input Format
First and only argument is an array of integers A.


Output Format
Return the count of elements.


Example Input
Input 1:
A = [3, 1, 2]
Input 2:
A = [5, 5, 3]


Example Output
Output 1:
2
Output 2:
1


Example Explanation
Explanation 1:
The elements that have at least 1 element greater than itself are 1 and 2
Explanation 2:
The elements that have at least 1 element greater than itself is 3
 */
public class CountElementsGreaterThanItself {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        if(n == 1) return 0;
        int max=A.get(0);
        int maxCount = 0;
        for(int i=1; i<n; i++) {
            if(A.get(i) > max) {
                max = A.get(i);
                maxCount=1;
            } else if (A.get(i) == max) {
                maxCount++;
            }
        }
        return n - maxCount;
    }

    public static void main(String[] args) {
        CountElementsGreaterThanItself obj = new CountElementsGreaterThanItself();
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(3, 1, 2));
        System.out.println(obj.solve(arr));
    }
}
