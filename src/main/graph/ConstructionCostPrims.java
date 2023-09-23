package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ConstructionCostPrims {
    static class Pair {
        int n;
        int w;
        Pair(int n, int w) {
            this.n = n;
            this.w = w;
        }
        @Override
        public String toString() {
            return n + ":" + w;
        }
    }
    public int solve(int n, int[][] edges) {
        List<Pair>[] graph = buildGraph(n, edges);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.w));
        // insert any random node pair with weight
        for(List<Pair> pairs : graph) {
            if(pairs != null && pairs.size() > 0){
                Pair p = new Pair(0,Integer.MAX_VALUE);
                for(Pair pp : pairs) {
                    if(pp.w < p.w) {
                        p = pp;
                    }
                }
                // adding node pair with 0 wt, to avoid adding it twice in the while loop
                minHeap.add(new Pair(p.n, 0));
                break;
            }
        }
        boolean[] visited = new boolean[n+1];
        int ans  = 0;
        while(!minHeap.isEmpty()) {
            Pair p = minHeap.poll();
            int v = p.n;
            int w = p.w;
            if(!visited[v]) {
                ans += w;
                visited[v] = true;
                if(graph[v] != null) {
                    for(Pair pp : graph[v]) {
                        if(!visited[pp.n]) {
                            minHeap.add(pp);
                        }
                    }
                }
            }
        }
        return ans;
    }

    List<Pair>[] buildGraph(int n, int[][] edges) {
        List<Pair>[] graph = new ArrayList[n+1];
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            if(graph[u] == null) {
                graph[u] = new ArrayList<>();
            }
            graph[u].add(new Pair(v, w));
            if(graph[v] == null) {
                graph[v] = new ArrayList<>();
            }
            graph[v].add(new Pair(u, w));
        }
        return graph;
    }

    public static void main(String[] args) {
        ConstructionCostPrims ob = new ConstructionCostPrims();
        int[][] edges = {
                {1,2,14},
                {2,3,7},
                {3,1,2}
        };
        System.out.println(ob.solve(3, edges)); // 9
    }
}
