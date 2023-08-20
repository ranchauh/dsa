package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxArraySumAfterKNegations {
    static class Pair {
        int n;
        int idx;
        Pair(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }
    }

    public static int solve(List<Integer> arr, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.n));
        for(int i=0; i<arr.size(); i++) {
            int n = arr.get(i);
            minHeap.add(new Pair(n, i));
        }
        while(k > 0) {
            Pair pair = minHeap.poll();
            if(pair.n < 0) {
                pair.n = pair.n * -1;
                arr.set(pair.idx, pair.n);
                if(minHeap.peek().n > pair.n) {
                    minHeap.add(pair);
                }
                k--;
            } else if (pair.n > 0) {
                if(k % 2 != 0) {
                    pair.n = pair.n * -1;
                    arr.set(pair.idx, pair.n);
                }
                break;
            } else {
                break;
            }
        }
        int sum = 0;
        for(int x : arr) {
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(24, -68, -29, -9, 84), 4)); // 196
        System.out.println(solve(Arrays.asList(57, 3, -14, -87, 42, 38, 31, -7, -28, -61), 10)); // 362
    }
}
