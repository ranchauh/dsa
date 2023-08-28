package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * NOTE: No 2 entries in the permutation sequence should be the same.
 *
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 * Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 9
 *
 * 0 <= A[i] <= 10
 *
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return a 2-D array denoting all possible unique permutation of the array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 1, 2]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 * [ [1,1,2]
 *   [1,2,1]
 *   [2,1,1] ]
 * Output 2:
 *
 * [ [1, 2]
 *   [2, 1] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All the possible unique permutation of array [1, 1, 2].
 * Explanation 2:
 *
 *  All the possible unique permutation of array [1, 2].
 */
public class UniqueNumericPermutations {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int[] freq = new int[11];
        for(int x : A) {
            freq[x]++;
        }
        permute(A, 0, new ArrayList<>(), freq);
        return result;
    }

    void permute(ArrayList<Integer> arr, int idx, ArrayList<Integer> res, int[] freq) {
        if(idx == arr.size()) {
            result.add(new ArrayList<>(res));
            return;
        }
        for(int i=0; i<=10; i++) {
            if(freq[i] > 0) {
                freq[i]--;
                res.add(i);
                permute(arr, idx+1, res, freq);
                // restore state
                freq[i]++;
                res.remove(res.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        UniqueNumericPermutations ob  = new UniqueNumericPermutations();
        System.out.println(ob.permute(new ArrayList<>(Arrays.asList(1,1,2)))); // [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
    }

}
