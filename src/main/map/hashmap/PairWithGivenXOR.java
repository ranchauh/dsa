package map.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array A containing N distinct integers.
 * Find the number of unique pairs of integers in the array whose XOR is equal to B.
 * NOTE:
 * Pair (a, b) and (b, a) is considered to be the same and should be counted once.
 */
public class PairWithGivenXOR {
    /**
     * Logic:
     * If x^y = z
     * so, x^z = y and y^z = x
     * Hence, we can do XOR of B with each number (x) iteratively and
     * look for the result of x ^ B in the set we create along the iterations.
     */
    public int withHashSet(int[] A, int B) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int x : A) {
            int y = x ^ B;
            if(set.contains(y)) {
                count++;
            }
            set.add(x);
        }
        return count;
    }

    public static void main(String[] args) {
        PairWithGivenXOR obj = new PairWithGivenXOR();
        int[] A = {5, 4, 10, 15, 7, 6};
        int B = 5;
        System.out.println(obj.withHashSet(A, B)); // 1
    }
}
