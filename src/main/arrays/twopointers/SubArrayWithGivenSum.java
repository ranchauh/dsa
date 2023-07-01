package arrays.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 *
 * If the answer does not exist return an array with a single integer "-1".
 *
 * First sub-array means the sub-array for which starting index in minimum.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 5
 * Input 2:
 *
 *  A = [5, 10, 20, 100, 105]
 *  B = 110
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 3]
 * Output 2:
 *
 *  [-1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  [2, 3] sums up to 5.
 * Explanation 2:
 *
 *  No subarray sums up to required number.
 */
public class SubArrayWithGivenSum {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int start = 0, end = 0;
        int sum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(end = 0; end < n; end++) {
            sum += A.get(end);
            result.add(A.get(end));
            while(sum > B) {
                result.remove(0);
                sum -= A.get(start);
                start++;
            }
            if(sum == B && B != 0) {
                return result;
            }
        }
        result.clear();
        result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        SubArrayWithGivenSum ob = new SubArrayWithGivenSum();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int B = 5;
        System.out.println(ob.solve(A, B));
        ArrayList<Integer> AA = new ArrayList<>(Arrays.asList(5, 10, 20, 100, 105));
        int BB = 110;
        System.out.println(ob.solve(AA, BB));
        ArrayList<Integer> AAA = new ArrayList<>(Arrays.asList(15, 2, 5, 6, 9));
        int BBB = 7;
        System.out.println(ob.solve(AAA, BBB));
    }
}
