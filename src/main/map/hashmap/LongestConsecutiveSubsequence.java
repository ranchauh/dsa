package map.hashmap;

import java.util.HashSet;

/**
 * Problem Description
 * Given an unsorted integer array A of size N.
 *
 * Find the length of the longest set of consecutive elements from array A.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 *
 * -106 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the length of the longest set of consecutive elements from the array A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [100, 4, 200, 1, 3, 2]
 * Input 2:
 *
 * A = [2, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The set of consecutive elements will be [1, 2, 3, 4].
 * Explanation 2:
 *
 *  The set of consecutive elements will be [1, 2].
 */
public class LongestConsecutiveSubsequence {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int longestConsecutive(final int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int el:A) {
            set.add(el);
        }
        int ans = 0;
        for(int el : A) {
            int x = el - 1;
            if(!set.contains(x)) {
                x = el + 1;
                int count = 1;
                while(set.contains(x)) {
                    x++;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(A)); //4
    }
}
