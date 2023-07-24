package arrays.subarrays;

import java.util.*;

/**
 * Sana is a chef who loves to experiment with different flavors. She has an array A of length N of spices in her kitchen. She wants to find the smallest subarray that contains all occurrences of the most frequent spice (There can be multiple most frequent spices).
 * She has noted down the occurrence of each spice in an array, and now she needs your help to find the length of the smallest subarray length that contains all occurrences of the most frequent spice.
 */
public class ChefSana {
    public static int solve(int[] A) {
        Map<Integer, Long> freq = new HashMap<>();
        long max = 1;
        for(int i : A) {
            freq.put(i, freq.getOrDefault(i, 0L) + 1L);
            if(freq.get(i) > max) {
                max = freq.get(i);
            }
        }
        Set<Integer> maxList =  new HashSet<>();
        for(int k : freq.keySet()) {
            if(freq.get(k) == max) {
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

