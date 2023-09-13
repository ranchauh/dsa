package dp.knapsack;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem Description
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 *
 * Also given an integer C which represents knapsack capacity.
 *
 * Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).
 *
 * NOTE:
 *
 * You can break an item for maximizing the total value of the knapsack
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i], B[i] <= 103
 *
 * 1 <= C <= 103
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N denoting the values on N items.
 *
 * Second argument is an integer array B of size N denoting the weights on N items.
 *
 * Third argument is an integer C denoting the knapsack capacity.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [60, 100, 120]
 *  B = [10, 20, 30]
 *  C = 50
 * Input 2:
 *
 *  A = [10, 20, 30, 40]
 *  B = [12, 13, 15, 19]
 *  C = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  24000
 * Output 2:
 *
 *  2105
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
 * the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
 * Explanation 2:
 *
 * Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.
 */
public class FractionalKnapsack {
    static class Pair {
        int val;
        int wt;
        double ppu;
        Pair(int val, int wt) {
            this.val = val;
            this.wt = wt;
            this.ppu = (double) this.val/this.wt;
        }
    }
    public int solve(int[] val, int[] wt, int k) {
        int n = val.length;
        Pair[] pairs = new Pair[n];
        for(int i=0; i<n; i++) {
            pairs[i] = new Pair(val[i], wt[i]);
        }
        Arrays.sort(pairs, Comparator.comparing(p -> p.ppu));
        double ans = 0;
        int i = n-1;
        while(k > 0 && i >= 0) {
            Pair pair = pairs[i];
            if(k >= pair.wt) {
                k = k - pair.wt;
                ans += pair.val;
            } else {
                ans += pair.ppu * k;
                k = 0;
            }
            i--;
        }
        ans = ans * 1000;
        return (int) ans/10;
    }

    public static void main(String[] args) {
        FractionalKnapsack ob = new FractionalKnapsack();
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        System.out.println(ob.solve(val, wt, 50)); // 24000

        int[] val1 = {10, 20, 30 , 40};
        int[] wt1 = {12, 13, 15, 19};
        System.out.println(ob.solve(val1, wt1, 10)); // 2105

        System.out.println(ob.solve(new int[] {3}, new int[]{20}, 17)); // 255

    }
}
