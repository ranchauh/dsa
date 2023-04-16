package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.
 */
public class ProductArray {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> prefix = new ArrayList<>(Arrays.asList(new Integer[n]));
        ArrayList<Integer> suffix = new ArrayList<>(Arrays.asList(new Integer[n]));
        ArrayList<Integer> result = new ArrayList<>();
        prefix.set(0, A.get(0));
        for(int i=1; i<n; i++) {
            prefix.set(i, prefix.get(i-1) * A.get(i));
        }
        suffix.set(n-1, A.get(n-1));
        for(int i=n-2; i>=0; i--) {
            suffix.set(i, suffix.get(i+1) * A.get(i));
        }
        for(int i=0; i<n; i++) {
            if(i == 0) {
                result.add(suffix.get(i+1));
            } else if(i == n-1) {
                result.add(prefix.get(i-1));
            } else {
                result.add(prefix.get(i-1) * suffix.get(i+1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ProductArray obj = new ProductArray();
        System.out.println(obj.solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)))); // [120, 60, 40, 30, 24]
    }
}
