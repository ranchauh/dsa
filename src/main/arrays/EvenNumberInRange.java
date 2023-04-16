package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
You are given an array A of length N and Q queries given by the 2D array B of size Q×2.
Each query consists of two integers B[i][0] and B[i][1].
For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].

Problem Constraints
1 <= N <= 105
1 <= Q <= 105
1 <= A[i] <= 109
0 <= B[i][0] <= B[i][1] < N

 */
public class EvenNumberInRange {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> prefixEvenCount = prefixEvenCount(A);
        for(ArrayList<Integer> query : B) {
            int l = query.get(0);
            int r = query.get(1);
            if(l == 0) {
                result.add(prefixEvenCount.get(r));
            } else {
                result.add( prefixEvenCount.get(r) - prefixEvenCount.get(l-1));
            }
        }
        return result;
    }

    private ArrayList<Integer> prefixEvenCount(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<arr.size(); i++) {
            if(i == 0) {
                if(arr.get(i)%2 == 0) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            } else {
                if(arr.get(i)%2 == 0) {
                    result.add( result.get(i-1) + 1);
                } else {
                    result.add( result.get(i-1) );
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        EvenNumberInRange obj = new EvenNumberInRange();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(0, 2)));
        B.add(new ArrayList<>(Arrays.asList(2, 4)));
        B.add(new ArrayList<>(Arrays.asList(1, 4)));

        System.out.println(obj.solve(A, B)); // [1, 1, 2]
    }
}
