package map.treemap;

import java.util.*;

public class TopKFrequentElements {
    public int[] solve(int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : A) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        System.out.println(map);
        SortedSet<Map.Entry<Integer, Integer>> set = new TreeSet<>((e1, e2) -> {
            if(Objects.equals(e1.getValue(), e2.getValue())) {
                return e2.getValue().compareTo(e1.getValue());
            } else {
                return e2.getKey().compareTo(e1.getKey());
            }
        });
        set.addAll(map.entrySet());
        int[] ans = new int[B];
        int i=0;
        System.out.println(set);
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
        while(B > 0 && iterator.hasNext()) {
            ans[i++] = iterator.next().getKey();
            B--;
        }
        return ans;
    }

    public static void main(String[] args) {
        TopKFrequentElements ob = new TopKFrequentElements();
        int[] A = {3,3,3,1,2,2,1,4};
        System.out.println(Arrays.toString(ob.solve(A, 2)));
    }
}
