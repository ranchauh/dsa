package map.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given an array A of N integers. You will have to return number of distinct elements of the array.
 */
public class CountDistinctElements {
    public int solve(int[] A) {
        Set<Integer> uniqElem = new HashSet<>();
        for(int x : A) {
            uniqElem.add(x);
        }
        return uniqElem.size();
    }

    public static void main(String[] args) {
        CountDistinctElements obj = new CountDistinctElements();
        int[] A = {3, 4, 3, 6, 6};
        System.out.println(obj.solve(A)); //3
    }
}
