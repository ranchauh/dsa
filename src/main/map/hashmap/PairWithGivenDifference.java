package map.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an one-dimensional unsorted array A containing N integers.
 * You are also given an integer B, find if there exists a pair of elements in the array whose difference is B.
 * Return 1 if any such pair exists else return 0.
 */
public class PairWithGivenDifference {
    public int withHashMap(int[] A, int B) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int x : A) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }
        for (int x : A) {
            int y = x - B;
            if (x == y && freqMap.getOrDefault(y, 0) > 1) {
                return 1;
            } else if (x != y && freqMap.containsKey(y)) {
                return 1;
            }
        }
        return 0;
    }

    public int withHashSet(int[] A, int B) {
        Set<Integer> set = new HashSet<>();
        for(int x : A) {
            int y = x - B;
            if(set.contains(y)) {
                return 1;
            }
            set.add(x);
        }
        return 0;
    }

    public static void main(String[] args) {
        PairWithGivenDifference obj = new PairWithGivenDifference();
        int[] A = {5, 10, 3, 2, 50, 80};
        int B = 78;
        System.out.println(obj.withHashMap(A, B)); // 1
        System.out.println(obj.withHashSet(A, B)); //1
    }
}
