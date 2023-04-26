package hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array A of size N, find the first repeating element in it.
 * We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
 * If there is no repeating element, return -1.
 */
public class FirstRepeatingElement {
    public int solve(List<Integer> A) {
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        for(int i=A.size()-1; i>=0; i--) {
            if(set.contains(A.get(i))) {
                ans = A.get(i);
            } else {
                set.add(A.get(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FirstRepeatingElement obj = new FirstRepeatingElement();
        System.out.println(obj.solve(Arrays.asList(10, 5, 3, 4, 3, 5, 6))); //5
        System.out.println(obj.solve(Arrays.asList(6, 10, 5, 4, 9, 120))); // -1
    }
}
