package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 */

public class RangeSumQuery {
    public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Long> result = new ArrayList<Long>();
        ArrayList<Long> prefixSum = prefixSum(A);
        for(ArrayList<Integer> query:B) {
            int l = query.get(0);
            int r = query.get(1);

            if(l == 0) {
                result.add(prefixSum.get(r));
            } else {
                long sum = prefixSum.get(r) - prefixSum.get(l-1);
                result.add(sum);
            }
        }
        return result;
    }

    private ArrayList<Long> prefixSum(ArrayList<Integer> arr) {
        ArrayList<Long> result = new ArrayList<>();
        for(int i=0; i< arr.size(); i++) {
            if(i == 0) {
                result.add(i, Long.valueOf(arr.get(i)));
            } else {
                result.add(i, result.get(i-1) + arr.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RangeSumQuery obj = new RangeSumQuery();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(0, 3)));
        B.add(new ArrayList<>(Arrays.asList(1, 2)));
        System.out.println(obj.rangeSum(A, B)); // [10, 5]
    }
}
