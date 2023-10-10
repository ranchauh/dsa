package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 *
 *
 * Example 1:
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 *
 * Input: triangle = [[-10]]
 * Output: -10
 *
 *
 * Constraints:
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 *
 * Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 */
public class TrianglePathSum {
    public int minimumTotal(List<List<Integer>> triangle) {
        //return minimumTotalRec(triangle, 0, 0);
        //return minimumTotalDP(triangle);
        return minimumTotalDPSpaceOptimized(triangle);
    }

    int minimumTotalDPSpaceOptimized(List<List<Integer>> triangle) {
        int r = triangle.size();
        List<Integer> prev = new ArrayList<>();
        for(int i=0; i<r; i++) {
            int c = triangle.get(i).size();
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<c; j++) {
                if(i == 0 && j == 0) {
                    row.add(triangle.get(i).get(j));
                } else if(j == 0){
                    int curVal = triangle.get(i).get(j);
                    int preVal = prev.get(j);
                    row.add(curVal + preVal);
                } else {
                    int curVal = triangle.get(i).get(j);
                    int topVal = 100000;
                    if(j <= triangle.get(i-1).size() - 1) {
                        topVal = prev.get(j);
                    }
                    int topLeftVal = prev.get(j-1);
                    int minVal = Math.min(curVal + topVal, curVal + topLeftVal);
                    row.add(minVal);
                }
            }
            prev = row;
        }
        int min = Integer.MAX_VALUE;
        for(int x : prev) {
            min = Math.min(min, x);
        }
        return min;
    }

    int minimumTotalDP(List<List<Integer>> triangle) {
        int r = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=0; i<r; i++) {
            int c = triangle.get(i).size();
            List<Integer> row = new ArrayList<>();
            dp.add(row);
            for(int j=0; j<c; j++) {
                if(i == 0 && j == 0) {
                    row.add(triangle.get(i).get(j));
                } else if(j == 0){
                    int curVal = triangle.get(i).get(j);
                    int preVal = dp.get(i-1).get(j);
                    row.add(curVal + preVal);
                } else {
                    int curVal = triangle.get(i).get(j);
                    int topVal = 100000;
                    if(j <= triangle.get(i-1).size() - 1) {
                        topVal = dp.get(i-1).get(j);
                    }
                    int topLeftVal = dp.get(i-1).get(j-1);
                    int minVal = Math.min(curVal + topVal, curVal + topLeftVal);
                    row.add(minVal);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int x : dp.get(r-1)) {
            min = Math.min(min, x);
        }
        return min;
    }



    int minimumTotalRec(List<List<Integer>> triangle, int row, int col) {
        if(row >= triangle.size() || col >= triangle.get(row).size()) {
            return 0;
        }
        int downPath = minimumTotalRec(triangle, row+1, col);
        int rightPath = minimumTotalRec(triangle, row+1, col+1);
        int currVal = triangle.get(row).get(col);
        return Math.min(currVal + downPath, currVal + rightPath);
    }

    public static void main(String[] args) {
        TrianglePathSum ob = new TrianglePathSum();
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3)
        );
        System.out.println(ob.minimumTotal(triangle)); // 11
    }
}
