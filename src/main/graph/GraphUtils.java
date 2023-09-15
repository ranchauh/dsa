package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphUtils {
    public static List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] list = new ArrayList[n+1];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (list[u] == null) {
                list[u] = new ArrayList<>();
            }
            list[u].add(v);
        }
        return list;
    }
}
