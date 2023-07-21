package arrays.subarrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sana is a chef who loves to experiment with different flavors. She has an array A of length N of spices in her kitchen. She wants to find the smallest subarray that contains all occurrences of the most frequent spice (There can be multiple most frequent spices).
 * She has noted down the occurrence of each spice in an array, and now she needs your help to find the length of the smallest subarray length that contains all occurrences of the most frequent spice.
 */
public class ChefSana {
    public static int solve(int[] A) {
        Map<Integer, Long> freq = new HashMap<>();
        long max = Long.MIN_VALUE;
        for(int i : A) {
            if(freq.containsKey(i)) {
                freq.put(i, freq.get(i) + 1L);
            } else {
                freq.put(i, 1L);
            }

            if(freq.get(i) > max) {
                max = freq.get(i);
            }
        }
        List<Integer> maxList =  new ArrayList<>();
        for(int k : freq.keySet()) {
            long val = freq.get(k);
            if(val == max) {
                maxList.add(k);
            }
        }

        int start = 0;
        int end = A.length - 1;
        while(start < end) {
            if(!maxList.contains(A[start])) {
                start++;
            } else if(!maxList.contains(A[end])) {
                end--;
            } else {
                break;
            }
        }

        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 3};
        System.out.println(solve(A)); // 4
        int[] B = {3, 2, 1, 2, 5, 6};
        System.out.println(solve(B)); // 3
    }
}

