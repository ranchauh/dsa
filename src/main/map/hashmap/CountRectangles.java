package map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
 *
 * Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 2000
 * 0 <= A[i], B[i] <= 109
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 *
 *
 *
 * Output Format
 * Return the number of unordered quadruplets that form a rectangle.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 1, 2, 2]
 *  B = [1, 2, 1, 2]
 * Input 1:
 *
 *  A = [1, 1, 2, 2, 3, 3]
 *  B = [1, 2, 1, 2, 1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All four given points make a rectangle. So, the answer is 1.
 * Explanation 2:
 *
 *  3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
 *                                            (1, 1), (3, 1), (3, 2), (1, 2)
 *                                            (2, 1), (3, 1), (3, 2), (2, 2)
 */
public class CountRectangles {
    public int countRectangles(int[] A, int[] B) {
        Map<String, Integer> map = new HashMap<>();
        int numOfDiagonals = 0;
        int n = A.length;
        for(int i=0; i<n; i++) {
            String key = String.valueOf(A[i]) + B[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(A[i] != A[j] && B[i] != B[j]) {
                    String key1 = String.valueOf(A[i]) + B[j];
                    String key2 = String.valueOf(A[j]) + B[i];
                    if(map.containsKey(key1) && map.containsKey(key2)) {
                        numOfDiagonals++;
                    }
                }
            }
        }

        return numOfDiagonals/2;
    }

    public static void main(String[] args) {
        CountRectangles ob = new CountRectangles();
        System.out.println(ob.countRectangles(new int[]{1,1,2,2}, new int[]{1,2,1,2})); // 1
        System.out.println(ob.countRectangles(new int[]{1, 1, 2, 2, 3, 3}, new int[]{1, 2, 1, 2, 1, 2} )); // 3
    }
}
