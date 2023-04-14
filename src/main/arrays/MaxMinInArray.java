package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array A of size N.
You need to find the sum of Maximum and Minimum element in the given array.
 */
public class MaxMinInArray {
    public int solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Integer integer : A) {
            if (integer > max) {
                max = integer;
            }
            if (integer < min) {
                min = integer;
            }
        }
        return max + min;
    }

    public static void main(String[] args) {
        System.out.println(new MaxMinInArray()
                .solve(new ArrayList<>(Arrays.asList(-2, 1, -4, 5, 3)))); // 1

        System.out.println(new MaxMinInArray()
                .solve(new ArrayList<>(Arrays.asList(1, 3, 4, 1)))); // 5
    }
}
