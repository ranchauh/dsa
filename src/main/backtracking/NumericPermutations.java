package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * Given an integer array A of size N denoting collection of numbers , return all possible permutations.
 *
 * NOTE:
 *
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * Return the answer in any order
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 * Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 *
 *
 * Problem Constraints
 * 1 <= N <= 9
 *
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return a 2-D array denoting all possible permutation of the array.
 *
 *
 *
 * Example Input
 * A = [1, 2, 3]
 *
 *
 * Example Output
 * [ [1, 2, 3]
 *   [1, 3, 2]
 *   [2, 1, 3]
 *   [2, 3, 1]
 *   [3, 1, 2]
 *   [3, 2, 1] ]
 *
 *
 * Example Explanation
 * All the possible permutation of array [1, 2, 3].
 */
public class NumericPermutations {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        permute(A, 0, new ArrayList<>(), new boolean[9]);
        return result;
    }

    void permute(ArrayList<Integer> arr, int idx, ArrayList<Integer> res, boolean[] visited) {
        if(idx == arr.size()) {
            result.add(new ArrayList<>(res));
            return;
        }
        for(int i=0; i<arr.size(); i++) {
            int n = arr.get(i);
            if(!visited[n]) {
                visited[n] = true;
                res.add(n);
                permute(arr, idx+1, res, visited);
                // restore state
                visited[n] = false;
                res.remove(res.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        NumericPermutations ob = new NumericPermutations();
        System.out.println(ob.permute(new ArrayList<>(Arrays.asList(1,2,3)))); // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }
}
