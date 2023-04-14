package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array A and an integer B, find the number of occurrences of B in A.
 */
public class OccurrenceOfElement {
    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        for (Integer integer : A) {
            if (integer == B) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new OccurrenceOfElement()
                .solve(new ArrayList<>(Arrays.asList(1, 2, 2)), 2)); // 2
    }
}
