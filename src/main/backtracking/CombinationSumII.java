package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSumII {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum2(candidates, target, 0, list);
        return ans;
    }

    void combinationSum2(int[] candidates, int target, int index, List<Integer> list) {
        int n = candidates.length;

        if(target == 0) {
            List<Integer> newList = new ArrayList<>(list);
            ans.add(newList);
        }

        for(int i=index; i<n; i++) {
            if(candidates[i] <= target) {
                list.add(candidates[i]);
                combinationSum2(candidates, target-candidates[i], i+1, list);
                list.remove(list.size()-1);
            } else {
                break; // no need to continue as the array is sorted
            }
            // skipping duplicates
            while(i < n-1 && candidates[i] == candidates[i+1]) {
                i++;
            }
        }
    }
}
