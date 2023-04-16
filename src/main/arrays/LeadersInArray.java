package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.
NOTE: The rightmost element is always a leader.
Problem Constraints
    1 <= N <= 105
    1 <= A[i] <= 108
 */
// Without suffixMax SC: O(1)
public class LeadersInArray {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        int suffixMax;
        ArrayList<Integer> result = new ArrayList<>();
        // Handler last index. Last element is a leader in itself.
        suffixMax = A.get(n-1);
        result.add(suffixMax);
        for(int i=n-2; i>=0; i--) {
            if(A.get(i) > suffixMax) {
                suffixMax = A.get(i);
                result.add(suffixMax);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeadersInArray obj = new LeadersInArray();
        System.out.println(obj.solve(new ArrayList<>(Arrays.asList(16, 17, 4, 3, 5, 2)))); // [17, 2, 5]
    }
}
