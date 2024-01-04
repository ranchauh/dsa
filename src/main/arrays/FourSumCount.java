package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * Output: 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * Example 2:
 *
 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n3 = nums3.length;
        int n4 = nums4.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n1; i++) {
            for(int j=0; j<n2; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for(int i=0; i<n3; i++) {
            for(int j=0; j<n4; j++) {
                int sum = nums3[i] + nums4[j];
                count += map.getOrDefault(-sum, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FourSumCount fourSumCount = new FourSumCount();
        int[] A = {1,2}, B = {-2,-1}, C = {-1,2}, D = {0,2};
        System.out.println(fourSumCount.fourSumCount(A, B, C ,D)); // 2
    }
}
