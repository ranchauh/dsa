package greedy;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class JumpGame {

    public boolean canJumpGreedy(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return true;
        }
        int pathNode = -1;
        for(int i=n-2; i>=0; i--) {
            if((i+nums[i]) >= n-1 && pathNode == -1) {
                pathNode = i;
            }
            if(pathNode != -1 && ((i+nums[i]) >= n-1 || (i+nums[i]) >= pathNode)) {
                pathNode = i;
            }
        }
        if(pathNode == 0) return true;
        return false;
    }

    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    boolean canJump(int[] nums, int index) {
        if(index == nums.length - 1) {
            return true;
        }
        if(nums[index] == 0) {
            return false;
        }
        for(int i=1; i<=nums[index]; i++) {
            boolean res = canJump(nums, index+i);
            if(res == true) {
                return true;
            }
        }
        return false;
    }
}
