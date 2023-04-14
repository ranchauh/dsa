package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an integer array A of size N. In one second, you can increase the value of one element by 1.

Find the minimum time in seconds to make all elements of the array equal.
 */
public class TimeToEquality {
    public int solve(ArrayList<Integer> A) {
        // Find the max element in the Array
        int max = A.get(0);
        for(int i=1; i<A.size(); i++) {
            if(A.get(i) > max) {
                max = A.get(i);
            }
        }
        int minSeconds = 0;
        for (Integer integer : A) {
            minSeconds += (max - integer);
        }
        return minSeconds;
    }

    public static void main(String[] args) {
        System.out.println(new TimeToEquality()
                .solve(new ArrayList<>(Arrays.asList(2, 4, 1, 3, 2)))); // 8
    }
}
