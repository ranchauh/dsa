package map.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
 * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 * NOTE: if B > N, return an empty array.
 */
public class DistinctNumbersInWindow {

    public int[] dNums(int[] A, int B) {
        int n = A.length;
        int[] result = new int[0];
        if(B > n) {
            return result;
        }
        result = new int[n-B+1];
        Map<Integer,Integer> map = new HashMap<>();
        // Create first window of B elements
        for(int i=0; i<B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
        }
        result[0] = map.size();
        int start = 1;
        int end = B;
        while(end < n) {
            // Remove A[start] from the window
            int s = A[start-1];
            if(map.get(s) == 1) {
                map.remove(s);
            } else {
                map.put(s, map.get(s) - 1);
            }
            // Add A[end] to the window
            int e = A[end];
            map.put(e, map.getOrDefault(e, 0) + 1);

            // map.size() is the distict elements in this window
            result[start] = map.size();
            // slide the window
            start++;
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        DistinctNumbersInWindow obj = new DistinctNumbersInWindow();
        int[] A = {1, 2, 1, 3, 4, 3};
        System.out.println(Arrays.toString(obj.dNums(A, 3))); // [2, 3, 3, 2]

    }
}
