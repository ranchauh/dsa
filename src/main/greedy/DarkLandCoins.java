package greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description
 * The monetary system in DarkLand is really simple and systematic. The locals-only use coins. The coins come in different values. The values used are:
 *
 *  1, 5, 25, 125, 625, 3125, 15625, ...
 * Formally, for each K >= 0 there are coins worth 5K.
 *
 * Given an integer A denoting the cost of an item, find and return the smallest number of coins necessary to pay exactly the cost of the item (assuming you have a sufficient supply of coins of each of the types you will need).
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 2×109
 *
 *
 *
 * Input Format
 * The only argument given is integer A.
 *
 *
 *
 * Output Format
 * Return the smallest number of coins necessary to pay exactly the cost of the item.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 47
 * Input 2:
 *
 *  A = 9
 *
 *
 * Example Output
 * Output 1:
 *
 *  7
 * Output 2:
 *
 *  5
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Representation of 7 coins will be : (1 + 1 + 5 + 5 + 5 + 5 + 25).
 * Explanation 2:
 *
 *  Representation of 5 coins will be : (1 + 1 + 1 + 1 + 5).
 */
public class DarkLandCoins {

    public int solve(int A) {
        long largestDenomination = 0;
        long num = 1;
        while(num <= A) {
            largestDenomination = num;
            num = num * 5L;
        }
        int ans = 1;
        long diff = A - largestDenomination;
        long currDenomination = largestDenomination;
        while(diff > 0) {
            if(diff >= currDenomination) {
                ans++;
                diff = diff - currDenomination;
            } else {
                currDenomination = currDenomination/5;
            }
        }
        return ans;
    }

    public int solveOptimal(int A) {
        ArrayList< Integer > v = new ArrayList<> ();

        int val = 1;

        // Storing all denominations of coins
        while (val <= 2000000000) {
            v.add(val);
            val = val * 5;
        }
        // Sort in decreasing order
        Collections.reverse(v);

        int ans = 0;
        // Loop from the largest denomination
        for (Integer integer : v) {
            ans += A / integer;
            A = A % integer;
        }
        return ans;
    }

    public static void main(String[] args) {
        DarkLandCoins ob = new DarkLandCoins();
        System.out.println(ob.solve(47)); // 7
        System.out.println(ob.solveOptimal(47)); // 7
        System.out.println(ob.solve(9)); // 5
        System.out.println(ob.solveOptimal(9)); // 5
    }
}
