package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description
Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Return the maximum possible profit.
Problem Constraints
    0 <= len(A) <= 7e5
    1 <= A[i] <= 1e7
 */
public class BestTimeToBuySellStock {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        int n = A.size();
        if(n<2) {
            return 0;
        }
        int maxProfit=0;
        int[] suffixMax = suffixMax(A);
        for(int i=0; i<=n-2; i++) {
            if( A.get(i) < suffixMax[i+1]) {
                int profit = suffixMax[i+1] - A.get(i);
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }

    private int[] suffixMax(List<Integer> arr) {
        int n = arr.size();
        int[] suffix = new int[n];
        // handle last index
        suffix[n-1] = arr.get(n-1);
        for(int i=n-2; i>=0; i--) {
            if(arr.get(i) > suffix[i+1]) {
                suffix[i] = arr.get(i);
            } else {
                suffix[i] = suffix[i+1];
            }
        }
        return suffix;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock obj = new BestTimeToBuySellStock();
        ArrayList<Integer> arr =new ArrayList<>(Arrays.asList(1, 4, 5, 2, 4));
        System.out.println(obj.maxProfit(arr)); // 4
    }
}
