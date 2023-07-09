package sorting.radix;

import java.util.ArrayList;
import java.util.List;

/**
 * RADIX SORT ALGO LOGIC. But this solution doesn't work for LargestNumber problem :(
 */
public class LargestNumber {
    public String largestNumber(final int[] A) {
        for(int k=0; k<10; k++) {
            sortOnkthDigit(A, k);
        }
        int n = A.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(A[i]);
        }
        return sb.toString();
    }

    private int[] sortOnkthDigit(int[] arr, int k) {
        int n = arr.length;
        List<List<Integer>> freq = new ArrayList<>();
        for(int i=0; i<=9; i++) {
            freq.add(new ArrayList<>());
        }
        int d = (int) Math.pow(10, k);
        for (int x : arr) {
            int r = (x / d) % 10;
            freq.get(r).add(x);
        }
        int idx = 0;
        for(int i=0; i<=9; i++) {
            List<Integer> list = freq.get(i);
            for(int el : list) {
                arr[idx] = el;
                idx++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        LargestNumber ob = new LargestNumber();
        System.out.println(ob.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
