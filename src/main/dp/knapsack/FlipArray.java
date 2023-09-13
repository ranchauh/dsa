package dp.knapsack;

public class FlipArray {
    static class Pair {
        int count;
        int diff;
        Pair(int count, int diff) {
            this.count = count;
            this.diff = diff;
        }
    }

    public int solve(final int[] arr) {
        int sum = 0;
        for(int x : arr) {
            sum += x;
        }
        int k = sum/2;
        return flipIdx(arr, arr.length, k).count;
    }

    Pair flipIdx(int[] arr, int i, int k) {
        if(k < 0 || i == 0) {
            return new Pair(0, k);
        }
        // flip ith ele - reduce arr[i] from k
        Pair pair1 = flipIdx(arr, i-1, k - arr[i-1]);
        pair1.count++;
        // do not flip ele
        Pair pair2 = flipIdx(arr, i-1, k);
        if(pair1.diff >= 0 && pair2.diff >= 0) {
            return pair1.diff < pair2.diff ? pair1 : pair2;
        } else {
            return pair1.count > pair2.count ? pair1 : pair2;
        }
    }

    public static void main(String[] args) {
        FlipArray ob = new FlipArray();
        System.out.println(ob.solve(new int[]{8,4,5,7,6,2}));
        System.out.println(ob.solve(new int[]{5,4,6,8,7,2,3}));
    }
}
