package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



public class FloodFillBFS {
    static class Pair {
        int r,c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    int[] cols = {-1, 0, 1, 0};
    int[] rows = {0, -1, 0, 1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> queue = new LinkedList<>();
        int n = image.length;
        int m = image[0].length;

        int originalColor = image[sr][sc];

        if(image[sr][sc] != color) {
            queue.add(new Pair(sr, sc));
        }

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            sr = pair.r;
            sc = pair.c;
            if(sr >= 0 && sr < n && sc >= 0 && sc < m && image[sr][sc] == originalColor) {
                // change color
                image[sr][sc] = color;
                // add neighbours to queue
                for(int i=0; i< cols.length; i++) {
                    queue.add(new Pair(sr + rows[i], sc + cols[i]));
                }
            }
        }

        return image;
    }


    public static void main(String[] args) {
        FloodFillBFS floodFillDFS = new FloodFillBFS();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(Arrays.deepToString(image));
        floodFillDFS.floodFill(image,1, 1, 2);
        System.out.println(Arrays.deepToString(image)); // [[2,2,2],[2,2,0],[2,0,1]]

        int[][] image1 = {{0,0,0},{0,0,0}};
        System.out.println(Arrays.deepToString(image1));
        floodFillDFS.floodFill(image1,0, 0, 0);
        System.out.println(Arrays.deepToString(image1)); // [[0,0,0],[0,0,0]]
    }
}
