package map.treemap;

import java.util.*;

public class TreeMapValueSort {
    public static void main(String[] args) {
        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 2);
        treeMap.put(3, 4);
        treeMap.put(2, 1);
        treeMap.put(5, 3);
        treeMap.put(4, 1);
        SortedSet<Map.Entry<Integer, Integer>> set = new TreeSet<>((e1, e2) -> {
            if(Objects.equals(e1.getValue(), e2.getValue())) {
                return e2.getKey().compareTo(e1.getKey());
            } else {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        set.addAll(treeMap.entrySet());
        System.out.println(set);
    }
}
