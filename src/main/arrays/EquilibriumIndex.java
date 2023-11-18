package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
You are given an array A of integers of size N.
Your task is to find the equilibrium index of the given array
The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
Note:
    Array indexing starts from 0.
    If there is no equilibrium index then return -1.
    If there are more than one equilibrium indexes then return the minimum index.
 */
public class EquilibriumIndex {

    public int solve(int[] arr) {
        int n = arr.length;
        int[] pfSum = prefixSum(arr);
        for(int i=0; i<n; i++) {
            if(i==0) {
                // there is no left element, so check if sum(1, n-1) is 0
                int rs = pfSum[n-1] - pfSum[i];
                if(rs == 0) {
                    return i;
                }
            } else {
                int ls = pfSum[i] - arr[i];
                int rs = pfSum[n-1] - pfSum[i];
                if(ls == rs) {
                    return i;
                }
            }
        }
        return -1;
    }

    int[] prefixSum(int[] arr) {
        int[] pfSum = new int[arr.length];
        pfSum[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            pfSum[i] = pfSum[i-1] + arr[i];
        }
        return pfSum;
    }
    public int solve(ArrayList<Integer> A) {
        ArrayList<Integer> prefixSum = prefixSum(A);
        int n = A.size();
        for(int i=0; i<n; i++) {
            if(i == 0) {
                // When i == 0, there are no left elements so just consider the right sum
                int rs = (prefixSum.get(n-1) - A.get(i));
                if (rs == 0) {
                    return i;
                }
            } else {
                int ls = prefixSum.get(i-1);
                int rs = prefixSum.get(n-1) - prefixSum.get(i);
                if ( ls == rs) {
                    return i;
                }
            }
        }
        return -1;
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
        EquilibriumIndex obj = new EquilibriumIndex();
        System.out.println(obj.solve(new ArrayList<>(Arrays.asList(-7, 1, 5, 2, -4, 3, 0)))); // 3
    }
}
