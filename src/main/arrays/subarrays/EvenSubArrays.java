package arrays.subarrays;

import java.util.ArrayList;

/*
Problem Description
You are given an integer array A.
Decide whether it is possible to divide the array into one or more subarrays of even length such that the first and last element of all subarrays will be even.
Return "YES" if it is possible; otherwise, return "NO" (without quotes).

Problem Constraints
    1 <= |A|, A[i] <= 106
 */
public class EvenSubArrays {
    // 2, 4, 8, 7, 6
    // 0th => 2  = (5-0)/2 = 5/2 = 2
    // 1st => 2  = (5-1)/2 = 4/2 = 2
    // 2nd => 1  = (5-2)/2 = 3/2 = 1
    // 3rd => 1  = (5-3)/2 = 2/2 = 1
    // 3th => 0  = (5-4)/2 = 1/2 = 0

    // 2, 4, 8, 6
    // 0 => 2 => (4-0)/2 = 2
    // 1 => 1 => (4-1)/2 = 1
    // 2 => 1 => (4-2)/2 = 1
    // 3 => 0 => (4-4)/2 = 0
    public String solve(ArrayList<Integer> A) {
        int n=A.size();
        if(n%2 == 0 && A.get(0)%2 ==0 && A.get(n-1)%2 == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

}
