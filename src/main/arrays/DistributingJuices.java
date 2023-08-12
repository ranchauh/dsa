package arrays;

/**
 * Given an array where each element A[i] represents a container at ith position having capacity i.
 * Given another number k represents a jar containing k units of juice, we need to distribute k units
 * of juice into the maximum number of containers possible. We can either start from front or back.
 * We can't skip a container.
 */
public class DistributingJuices {
    public int solve(int[] arr, int k) {
        int n = arr.length;
        int t = k;
        int countFront = 0;
        for(int x : arr) {
            t = t - x;
            if(t >= 0) {
                countFront++;
            } else {
                break;
            }
        }
        t = k;
        int countBack = 0;
        for(int i=n-1; i>=0; i--) {
            t = t - arr[i];
            if(t >= 0) {
                countBack++;
            } else {
                break;
            }
        }
        return Math.max(countFront, countBack);
    }
}
