package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.



Problem Constraints
1 <= A.size() <= 104

1 <= A[i] <= 109

1 <= B <= 109



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return 1 if good pair exist otherwise return 0.



Example Input
Input 1:

A = [1,2,3,4]
B = 7
Input 2:

A = [1,2,4]
B = 4
Input 3:

A = [1,2,2]
B = 4


Example Output
Output 1:

1
Output 2:

0
Output 3:

1


Example Explanation
Explanation 1:

 (i,j) = (3,4)
Explanation 2:

No pair has sum equal to 4.
Explanation 3:

 (i,j) = (2,3)
 */
public class GoodPair {
    public int solve(ArrayList<Integer> A, int B) {
        int n=A.size();
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++) {
                if(A.get(i)+A.get(j) == B) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        GoodPair obj = new GoodPair();
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        System.out.println(obj.solve(arr, 7)); // 1

        arr = new ArrayList<Integer>(Arrays.asList(1,2,4));
        System.out.println(obj.solve(arr, 4)); // 0

        arr = new ArrayList<Integer>(Arrays.asList(1,2,2));
        System.out.println(obj.solve(arr, 4)); // 1
    }
}
