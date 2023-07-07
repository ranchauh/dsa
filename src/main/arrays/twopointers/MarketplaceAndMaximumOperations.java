package arrays.twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Once upon a time in a bustling marketplace, there was a clever merchant named Ethan.
 * Ethan had a booth filled with an array of unique treasures, each represented by an integer value.
 * Customers from far and wide flocked to his booth, seeking to acquire these precious items.
 * One day, Ethan stumbled upon a challenge that piqued his interest.
 * You are given an integer array A and an integer B.
 * In one operation, you can pick two numbers from the array whose sum equals and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 */
public class MarketplaceAndMaximumOperations {
    /**
     * Using HashSet
     */
    public int solveUsingHashSet(int[] A, int B) {
        Set<Integer> set = new HashSet<>();
        for(int e:A) {
            set.add(e);
        }
        int count = 0;
        for(int e:A) {
            int d = B - e;
            if(d != e && set.contains(d)){
                count++;
                set.remove(e);
                set.remove(d);
            } else {
                set.add(d);
            }
        }
        return count;
    }

    // Using sorting and two pointers
    public int solveUsingTwoPointers(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);
        int p1 = 0, p2 = n - 1;
        int count = 0;
        while(p1 < p2) {
            int sum = p1+p2;
            if(sum == B) {
                count++;
                p1++;
                p2--;
            } else if(sum > B) {
                p2--;
            } else {
                p1++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MarketplaceAndMaximumOperations ob = new MarketplaceAndMaximumOperations();
        int[] A = {2,4,6,0};
        int B = 6;
        System.out.println(ob.solveUsingHashSet(A, B)); //2
        System.out.println(ob.solveUsingTwoPointers(A, B)); //2
    }
}
