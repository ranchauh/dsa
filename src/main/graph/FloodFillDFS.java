package graph;

import java.util.Arrays;

public class FloodFillDFS {
    int[] cols = {-1, 0, 1, 0};
    int[] rows = {0, -1, 0, 1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        if(sr >= 0 && sr < n && sc >= 0 && sc < m && image[sr][sc] != color) {
            floodFillHelper(image, n, m, sr, sc, color, image[sr][sc]);
        }
        return image;
    }

    private void floodFillHelper(int[][] image, int n, int m, int sr, int sc, int color, int originalColor) {
        if(sr >= 0 && sr < n && sc >= 0 && sc < m && image[sr][sc] == originalColor) {
            // fill color
            image[sr][sc] = color;
            // fill in all four directions
            // fill in all four directions
            for(int i=0; i<cols.length; i++) {
                floodFillHelper(image, n, m, sr+rows[i], sc+cols[i], color, originalColor);
            }
//            // left
//            floodFillHelper(image, n, m, sr, sc - 1, color, originalColor);
//            // right
//            floodFillHelper(image, n, m, sr, sc + 1, color, originalColor);
//            // up
//            floodFillHelper(image, n, m, sr-1, sc, color, originalColor);
//            // down
//            floodFillHelper(image, n, m, sr+1, sc, color, originalColor);
        }
    }

    public static void main(String[] args) {
        FloodFillDFS floodFillDFS = new FloodFillDFS();
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
