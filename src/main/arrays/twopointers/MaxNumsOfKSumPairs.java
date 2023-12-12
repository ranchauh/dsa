package arrays.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumsOfKSumPairs {

    /**
     * TC: O(N)
     * SC: O(N)
     */
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : nums) {
            int diff = k - x;
            if(map.containsKey(diff)) {
                ans++;
                if(map.get(diff) == 1) map.remove(diff);
                else map.put(diff, map.get(diff) - 1);
            } else {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        return ans;
    }

    /**
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int maxOperationsNLogN(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while(i < j) {
            int sum = nums[i]+nums[j];
            if(sum == k) {
                i++;
                j--;
                ans++;
            } else if(sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
