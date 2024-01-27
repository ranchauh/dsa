package map.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairSum {
    /**
     * You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j. Since the answer can be very large, return the remainder after dividing the count with 109+7.
     * Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.
     */
    public int countPairSum(int[] A, int B) {
        final int mod = (int) (1e9 + 7);
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;
        for(int x : A) {
            int y = B - x;
            count += map.getOrDefault(y, 0);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return (int) (count % mod);
    }

    /**
     * Given an Array of integers B, and a target sum A.
     * Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
     * @param A
     * @param B
     * @return
     */
    public int checkPairSum(int[] A, int B) {
        Set<Integer> set = new HashSet<>();
        for(int x : A) {
            int y = B - x;
            if(set.contains(y)) {
                return 1;
            }
            set.add(x);
        }
        return 0;
    }

    public static void main(String[] args) {
        PairSum obj = new PairSum();
        int[] A = {3, 5, 1, 2};
        int B = 8;
        System.out.println(obj.countPairSum(A, B)); //1
        System.out.println(obj.checkPairSum(A, B)); //1

        int[] C = {1, 2, 1 , 2};
        int D = 3;
        System.out.println(obj.countPairSum(C, D)); // 4
        System.out.println(obj.checkPairSum(C, D)); // 1

        int[] E = {9, 10, 7, 10, 9, 1, 5, 1, 5};
        int F = 21;
        System.out.println(obj.countPairSum(E, F)); // 0
        System.out.println(obj.checkPairSum(E, F)); // 0
    }
}
