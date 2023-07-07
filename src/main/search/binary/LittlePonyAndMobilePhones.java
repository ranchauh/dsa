package search.binary;

import java.util.Arrays;

public class LittlePonyAndMobilePhones {
    public int[] solve(int[] A, int[] B) {
        int[] prefix = prefixSum(A);
        int n = B.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            int q = B[i];
            int r = calculateMaxPhoneToPurchase(prefix, q);
            if(r == -1) {
                result[i] = 0;
            } else {
                result[i] = r;
            }
        }
        return result;
    }

    private int[] prefixSum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }
        return prefix;
    }

    private int calculateMaxPhoneToPurchase(int[] arr, int amount) {
        int ans = -1;
        int s = 0, e = arr.length - 1;
        // apply binary search
        while(s <= e) {
            int mid = s + (e-s)/2;
            if(arr[mid] <= amount) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        LittlePonyAndMobilePhones ob = new LittlePonyAndMobilePhones();
        int[] A = {3, 4, 4, 6};
        int[] B = {20, 4, 10, 2};
        System.out.println(Arrays.toString(ob.solve(A, B))); // [4, 1, 2, 0]
    }
}
