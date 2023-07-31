package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers A and an integer B.
 * Find the total number of subarrays having sum equals to B.
 */
public class SubArraysSumEqualsK {
    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                sum += A[j];
                if(sum == B) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySumWithPrefixSumArray(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = prefix(nums);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for(int p : prefix) {
            int diff = p - k;
            if(map.containsKey(diff)) {
                int c = map.get(diff);
                count += c;
            }
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        return count;
    }

    public int subarraySumWithPrefixSum(int[] nums, int k) {
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for(int n : nums) {
            prefix += n;
            int diff = prefix - k;
            if(map.containsKey(diff)) {
                int c = map.get(diff);
                count += c;
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

    int[] prefix(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        return prefix;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 1};
        System.out.println(new SubArraysSumEqualsK().solve(A, 1)); // 4
    }
}
