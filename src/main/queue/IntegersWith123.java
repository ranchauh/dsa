package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
 *
 * NOTE: All the A integers will fit in 32-bit integers.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 29500
 *
 *
 *
 * Input Format
 * The only argument given is integer A.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3
 * Input 2:
 *
 *  A = 7
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 3]
 * Output 2:
 *
 *  [1, 2, 3, 11, 12, 13, 21]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 * Explanation 2:
 *
 *  Output denotes the first 7 integers that contains only digits 1, 2 and 3.
 */
public class IntegersWith123 {
    public static  int[] solve(int A) {
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        int[] result = new int[A];
        while(i < 3 && i < A) {
            result[i] = i+1;
            i++;
            queue.add(i);
        }
        while(i < A) {
            int x = queue.poll();
            for(int y = 1; y<=3 && i < A; y++) {
                int z = Integer.parseInt(String.valueOf(x) + y);
                result[i] = z;
                i++;
                queue.add(z);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(9))); // [1, 2, 3, 11, 12, 13, 21, 22, 23]
    }
}
