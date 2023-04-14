package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.


Problem Constraints
1 <= N <= 105
1 <= A[i] <=109
1 <= B <= 109


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.


Output Format
Return the array A after rotating it B times to the right


Example Input
Input 1:

A = [1, 2, 3, 4]
B = 2
Input 2:

A = [2, 5, 6]
B = 1


Example Output
Output 1:

[3, 4, 1, 2]
Output 2:

[6, 2, 5]


Example Explanation
Explanation 1:

Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
Explanation 2:

Rotate towards the right 1 time - [2, 5, 6] => [6, 2, 5]
 */
public class ArrayRotation {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        // Calculate the actual times for rotation
        B = B % n;
        // We need to rotate only if B is more than 0
        if (B > 0) {
            // Reverse the entire List
            A = reverse(A, 0, n-1);
            // Reverse list from 0 till B-1
            A = reverse(A, 0, B-1);
            // Reverse list from B till n-1
            A = reverse(A, B, n-1);
            // Return the final result
        }
        return A;
    }

    private ArrayList<Integer> reverse(ArrayList<Integer> A, int i, int j) {
        while(i < j) {
            swap(A, i++, j--);
        }
        return A;
    }

    private void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayRotation obj = new ArrayRotation();
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        System.out.println(obj.solve(arr, 2)); // [3, 4, 1, 2]

        arr = new ArrayList<Integer>(Arrays.asList(2, 5, 6));
        System.out.println(obj.solve(arr, 1)); // [6, 2, 5]
    }
}
