package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
and at least one occurrence of the minimum value of the array.
Problem Constraints
    1 <= |A| <= 2000
 */
public class ClosestMinMax {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int min = min(A);
        int max = max(A);

        int result = n;
        int minIndex = -1;
        int maxIndex = -1;

        for(int i=0; i<n; i++) {
            if(A.get(i) == min) {
                minIndex = i;
            }
            if(A.get(i) == max) {
                maxIndex = i;
            }
            if(minIndex != -1 && maxIndex != -1) {
                int length = Math.abs(maxIndex - minIndex) + 1;
                result = Math.min(result, length);
            }
        }
        return result;
    }

    private int min(ArrayList<Integer> A) {
        int min = A.get(0);
        for(int i=1; i<A.size(); i++) {
            if(A.get(i) < min) {
                min = A.get(i);
            }
        }
        return min;
    }

    private int max(ArrayList<Integer> A) {
        int max = A.get(0);
        for(int i=1; i<A.size(); i++) {
            if(A.get(i) > max) {
                max = A.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ClosestMinMax obj = new ClosestMinMax();
        System.out.println(obj.solve(new ArrayList<>(Arrays.asList(2, 6, 1, 6, 9)))); // 3
    }
}
