package graph;
import java.util.*;

public class AliceAndParkBFS {
    public int solve(int dest, int[][] edges) {
        List<Integer>[] graph = buildGraph(dest, edges);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[dest +1];
        queue.add(1);
        visited[1] = true;
        int ans = 0;
        while(!queue.isEmpty()) {
            int level = queue.size();
            while(level > 0) {
                int curr = queue.poll();
                if(curr == dest) {
                    return ans;
                }
                List<Integer> nbrs = graph[curr];
                for(int b : nbrs) {
                    if(!visited[b]) {
                        queue.add(b);
                        visited[b] = true;
                    }
                }
                level--;
            }
            ans++;
        }
        return -1;
    }

    List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }

    public static void main(String[] args) {
        AliceAndParkBFS ob = new AliceAndParkBFS();
        int[][] edges = {
                {3,1},
                {4,3},
                {4,5},
                {1,2}
        };
        System.out.println(ob.solve(5, edges)); // 3
    }
}
