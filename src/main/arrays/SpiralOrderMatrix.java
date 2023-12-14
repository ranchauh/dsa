package arrays;

import java.util.Arrays;

public class SpiralOrderMatrix {
    public int[][] generateMatrix(int A) {
        int count = 1;
        int[][] ans = new int[A][A];
        int r=0, c=0;
        while(A>1) {
            for(int i=1; i<A; i++) {
                ans[r][c] = count++;
                c++;
            }
            for(int i=1; i<A; i++) {
                ans[r][c] = count++;
                r++;
            }
            for(int i=1; i<A; i++) {
                ans[r][c] = count++;
                c--;
            }
            for(int i=1; i<A; i++) {
                ans[r][c] = count++;
                r--;
            }
            r += 1;
            c += 1;
            A -= 2;
        }
        if(A == 1) {
            ans[r][c] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        SpiralOrderMatrix ob = new SpiralOrderMatrix();
        System.out.println(Arrays.deepToString(ob.generateMatrix(5)));
    }
}