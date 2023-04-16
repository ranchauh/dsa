package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array A of N integers. Construct prefix sum of the array in the given array itself.
 */
public class InPlacePrefixSum {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        return prefixSum(A);
    }

    private ArrayList<Integer> prefixSum(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i< arr.size(); i++) {
            if(i == 0) {
                result.add(i, arr.get(i));
            } else {
                result.add(i, result.get(i-1) + arr.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        InPlacePrefixSum obj = new InPlacePrefixSum();
        System.out.println(obj.solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)))); //1, 3, 6, 10, 15
    }
}
