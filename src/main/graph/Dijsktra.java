package graph;

import java.util.*;

public class Dijsktra {
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
    public int[] solve(int n, int[][] edges, int src) {
        List<Pair>[] graph = buildGraph(n, edges);
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.w));
        minHeap.add(new Pair(src, 0));
        while(!minHeap.isEmpty()) {
            Pair p = minHeap.poll();
            int v = p.n;
            if(vis[v]) {
                continue;
            }
            vis[v] = true;
            if(graph[v] != null) {
                for(Pair pp : graph[v]) {
                    int newDis = dist[v] + pp.w;
                    if(newDis < dist[pp.n]) {
                        dist[pp.n] = newDis;
                        minHeap.add(new Pair(pp.n, newDis));
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    List<Pair>[] buildGraph(int n, int[][] edges) {
        List<Pair>[] graph = new ArrayList[n+1];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (graph[u] == null) {
                graph[u] = new ArrayList<>();
            }
            graph[u].add(new Pair(v, w));
            if (graph[v] == null) {
                graph[v] = new ArrayList<>();
            }
            graph[v].add(new Pair(u, w));
        }
        return graph;
    }

    public static void main(String[] args) {
        Dijsktra ob = new Dijsktra();
        int[][] edges = {{0, 4, 9},
                        {3, 4, 6},
                        {1, 2, 1},
                        {2, 5, 1},
                        {2, 4, 5},
                        {0, 3, 7},
                        {0, 1, 1},
                        {4, 5, 7},
                        {0, 5, 1}};
        System.out.println(Arrays.toString(ob.solve(6, edges, 4))); // [7, 6, 5, 6, 0, 6]
    }
}
