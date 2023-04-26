package hashmap;

import java.util.*;

/**
 * Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
 * NOTE:
 * Each element in the result should appear as many times as it appears in both arrays.
 * The result can be in any order.
 */
public class CommonElementsInArray {
    public List<Integer> solve(List<Integer> A, List<Integer> B) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        for(int x : A) {
            freqCount.put(x, freqCount.getOrDefault(x, 0) + 1);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int y : B) {
            if(freqCount.getOrDefault(y, 0) > 0) {
                result.add(y);
                freqCount.put(y, freqCount.get(y) - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CommonElementsInArray obj = new CommonElementsInArray();
        List<Integer> A = Arrays.asList(1, 2, 2, 1);
        List<Integer> B = Arrays.asList(2, 3, 1, 2);
        System.out.println(obj.solve(A, B)); // [1, 2, 2]
    }
}
