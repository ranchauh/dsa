package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
You are given an integer array A of size N.
You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
Find and return the maximum possible sum of the elements that were removed after B operations.
NOTE: Suppose B = 4, and array A contains 10 elements, then
You can remove the first four elements or can remove the last four elements, or can remove 1 from front and 3 from the back, etc. You need to return the maximum possible sum of elements you can remove.
 */
public class PickFromBothSides {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int maxSum = Integer.MIN_VALUE;
        int curr = 0;
        // Initially pick all B elements from the front.
        // LEFT     RIGHT
        //  4         0
        int i=0;
        while(i<=B-1) {
            curr += A.get(i);
            i++;
        }

        // Iterate for the remaining conditions to choose the max sum. i.e. -
        // LEFT     RIGHT
        //  3         1
        //  2         2
        //  1         3
        //  0         4
        int last = n-1;
        maxSum = curr;
        // Move back i by 1 as the above loop has moved it past 1
        i--;
        while(i>=0) {
            // Remove the left most element to make space for righmost one.
            curr = curr - A.get(i);
            // Add the right most element
            curr = curr + A.get(last);
            // Choose the max between the last maximum and current sum
            maxSum = Math.max(maxSum, curr);
            // Reduce the last and current position by 1
            last--;
            i--;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        PickFromBothSides obj = new PickFromBothSides();
        System.out.println(obj.solve(new ArrayList<>(Arrays.asList(5, -2, 3 , 1, 2)), 3)); // 8
        System.out.println(obj.solve(new ArrayList<>(Arrays.asList(2, 3, -1, 4, 2, 1)), 4)); // 9
    }
}
