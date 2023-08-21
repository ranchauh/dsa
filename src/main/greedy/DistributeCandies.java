package greedy;

import java.util.Arrays;

/**
 * Problem Description
 * N children are standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum number of candies you must give?
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first and only argument is an integer array A representing the rating of children.
 *
 *
 *
 * Output Format
 * Return an integer representing the minimum candies to be given.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2]
 * Input 2:
 *
 *  A = [1, 5, 2, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  7
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
 *  So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
 * Explanation 2:
 *
 *  Candies given = [1, 3, 2, 1]
 */
public class DistributeCandies {
    public static int distributeCandy(int[] A) {
        int n = A.length;
        int[] candies = new int[n];
        for(int i=0; i<n; i++) {
            candies[i] = 1;
        }
        // Distribute candies left to right
        for(int i=1; i<n; i++) {
            if(A[i] > A[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        // Distribute candies right to left
        for(int i=n-2; i>=0; i--) {
            if(A[i] > A[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
        }
        int sum = 0;
        for(int x : candies) {
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(distributeCandy(new int[] {1, 5, 2, 1}));// 7
        System.out.println(distributeCandy(new int[] {1,2}));// 3
    }
}
