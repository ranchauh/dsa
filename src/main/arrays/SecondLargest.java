package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
You are given an integer array A.
You have to find the second largest element/value in the array or report that no such element exists.
 */
public class SecondLargest {
    public int solve(ArrayList<Integer> A) {
        int max=A.get(0);
        int secondMax = -1;

        for(int i=1; i<A.size(); i++) {
            if (A.get(i) > max) {
                secondMax = max;
                max = A.get(i);
            } else if (A.get(i) != max && A.get(i) > secondMax) {
                secondMax = A.get(i);
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        System.out.println(new SecondLargest()
                .solve(new ArrayList<>(Arrays.asList(2, 1, 2)))); // 1

        System.out.println(new SecondLargest()
                .solve(new ArrayList<>(Collections.singletonList(2)))); // -1
    }
}
