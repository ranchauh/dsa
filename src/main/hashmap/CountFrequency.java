package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A. You have some integers given in the array B.
 * For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.
 */
public class CountFrequency {
    public int[] solve(int[] A, int[] B) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int x : A) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }
        int n = B.length;
        int[] result = new int[n];
        int i = 0;
        for(int y : B) {
            result[i++] = freqMap.getOrDefault(y, 0);
        }
        return result;
    }

    public static void main(String[] args) {
        CountFrequency obj = new CountFrequency();
        int[] A = {1, 2, 1, 1};
        int[] B = {1, 2};
        System.out.println(Arrays.toString(obj.solve(A, B))); //[3, 1]
    }
}
