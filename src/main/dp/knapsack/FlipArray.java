package dp.knapsack;

/**
 * Given an array of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative (as close to zero as possible). Return the minimum no. of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative. Note that the sum of all the array elements will not exceed 104.
 * Examples:
 *
 * Input: arr[] = {15, 10, 6}
 * Output: 1
 * Here, we will flip the sign of 15
 * and the resultant sum will be 1.
 * Input: arr[] = [14, 10, 4]
 * Output: 1
 * Here, we will flip the sign of 14 and the resultant sum will be 0.
 * Note that flipping the signs of 10 and 4 also gives
 * the resultant sum 0 but the count of flipped elements is not minimum.
 */
public class FlipArray {
    static class Pair {
        int count;
        int sum;
        Pair(int count, int sum) {
            this.count = count;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return this.count + " " + this.count;
        }
    }

    public int solveTabulative(final int[] arr) {
        int sum = 0;
        for(int x : arr) {
            sum += x;
        }
        int k = sum/2;
        int n = arr.length;
        Pair[][] dp = new Pair[n+1][k+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=k; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = new Pair(0, 0);
                } else {
                    if(arr[i-1] > j) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        Pair p = dp[i-1][j-arr[i-1]];
                        Pair include = new Pair(p.count + 1, p.sum + arr[i-1]) ;
                        Pair exclude = dp[i-1][j];
                        dp[i][j] = compare(include, exclude);
                    }
                }
            }
        }
        return dp[n][k].count;
    }

    Pair compare(Pair pair1, Pair pair2) {
        if(pair1.sum == pair2.sum) {
            return pair1.count < pair2.count ? pair1 : pair2;
        } else {
            return pair1.sum > pair2.sum ? pair1 : pair2;
        }
    }

    public int solveMemoized(final int[] arr) {
        int sum = 0;
        for(int x : arr) {
            sum += x;
        }
        int k = sum/2;
        int n = arr.length;
        // Pair[i][j] = min elements to flip with array of size i and for the sum j
        Pair[][] dp = new Pair[n+1][k+1];
        for(int i=0; i<=n; i++) {
           for(int j=0; j<=k; j++) {
               dp[i][j] = new Pair(-1, 0);
           }
        }
        flipIdxMemoized(arr, n, k, 0, dp);
        return dp[n][k].count;
    }

    Pair flipIdxMemoized(int[] arr, int i, int k, int sum, Pair[][] dp) {
        if(sum > k || i == 0) {
            return new Pair(0, 0);
        }
        if(dp[i][sum].count != -1) {
            return dp[i][sum];
        }
        // flip ith ele - reduce arr[i] from k
        Pair pair1 = flipIdxMemoized(arr, i-1, k, sum + arr[i-1], dp);
        pair1.sum += arr[i-1];
        pair1.count++;
        // do not flip ele
        Pair pair2 = flipIdxMemoized(arr, i-1, k, sum, dp);

        if(pair1.sum == pair2.sum) {
            dp[i][sum] = pair1.count < pair2.count ? pair1 : pair2;
        } else {
            dp[i][sum] = pair1.sum > pair2.sum ? pair1 : pair2;
        }
        return dp[i][sum];
    }

    public int solveRecursive(final int[] arr) {
        int sum = 0;
        for(int x : arr) {
            sum += x;
        }
        int k = sum/2;
        return flipIdxRecursive(arr, arr.length, k, 0).count - 1;
    }

    Pair flipIdxRecursive(int[] arr, int i, int k, int sum) {
        if(sum > k || i == 0) {
            return new Pair(0, 0);
        }
        // flip ith ele - reduce arr[i] from k
        Pair pair1 = flipIdxRecursive(arr, i-1, k, sum + arr[i-1]);
        pair1.sum += arr[i-1];
        pair1.count++;
        // do not flip ele
        Pair pair2 = flipIdxRecursive(arr, i-1, k, sum);
        if(pair1.sum == pair2.sum) {
            return pair1.count < pair2.count ? pair1 : pair2;
        } else {
            return pair1.sum > pair2.sum ? pair1 : pair2;
        }
    }

    public static void main(String[] args) {
        FlipArray ob = new FlipArray();
        System.out.println(ob.solveRecursive(new int[]{8,4,5,7,6,2})); // 3
        System.out.println(ob.solveRecursive(new int[]{5,4,6,8,7,2,3})); // 3

        System.out.println(ob.solveMemoized(new int[]{8,4,5,7,6,2})); // 3
        System.out.println(ob.solveMemoized(new int[]{5,4,6,8,7,2,3})); // 3

        System.out.println(ob.solveTabulative(new int[]{8,4,5,7,6,2})); // 3
        System.out.println(ob.solveTabulative(new int[]{5,4,6,8,7,2,3})); // 3
    }
}
