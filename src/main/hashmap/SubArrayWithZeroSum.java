package hashmap;

import java.util.*;

public class SubArrayWithZeroSum {
    /**
     * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
     * If the given array contains a sub-array with sum zero return 1, else return 0.
     */
    public int subArrayWithZeroSumExists(int[] A) {
        long[] prefixSum = prefixSum(A);
        Set<Long> uniqElem = new HashSet<>();
        for(long x : prefixSum) {
            // If a prefixSum array element is 0 that means sum of all the elements before it (sub array) is 0
            if(x == 0) {
                return 1;
            }
            uniqElem.add(x);
        }
        // If there are duplicate elements in prefixSum, it indicates that some range (sub array) in A generates sum=0;
        if(uniqElem.size() != prefixSum.length) {
            return 1;
        }
        return 0;
    }

    /**
     * Given an array A of N integers.
     * Find the count of the subarrays in the array which sums to zero.
     * Since the answer can be very large, return the remainder on dividing the result with 109+7
     * @param A
     * @return
     */
    public int subArrayWithZeroSumCount1(int[] A) {
        final int mod = (int)(1e9 + 7);
        long[] prefixSum = prefixSum(A);
        Map<Long, Long> sumCount = new HashMap<>();
        long count = 0;
        for(long x : prefixSum) {
            if(sumCount.containsKey(x)) {
                if(x == 0) {
                    sumCount.put(x, sumCount.get(x) + 1);
                    count += sumCount.get(x);
                } else {
                    count += sumCount.get(x);
                    sumCount.put(x, sumCount.get(x) + 1);
                }
            } else {
                if(x == 0) {
                    count++;
                }
                sumCount.put(x, 1L);
            }
        }
        return (int) (count % mod);
    }

    /**
     * Given an array A of N integers.
     * Find the count of the subarrays in the array which sums to zero.
     * Since the answer can be very large, return the remainder on dividing the result with 109+7
     * @param A
     * @return
     */
    public int subArrayWithZeroSumCount(int[] A) {
        final int mod = (int) (1e9 + 7);
        HashMap<Long, Long> prefSumFreq = new HashMap<>();
        prefSumFreq.put(0L, 1L);
        long sum = 0;
        long count = 0;
        for(long x : A) {
            sum += x;
            long freq = prefSumFreq.getOrDefault(sum, 0L);
            prefSumFreq.put(sum, freq + 1);
            count += freq;
        }
        return (int) count % mod;
    }

    private long[] prefixSum(int[] A) {
        int n = A.length;
        long[] prefix = new long[n];
        for(int i=0; i<n; i++) {
            if(i==0) {
                prefix[i] = A[i];
            } else {
                prefix[i] = prefix[i-1] + A[i];
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        SubArrayWithZeroSum obj = new SubArrayWithZeroSum();

        // Existence
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(obj.subArrayWithZeroSumExists(A)); //0
        int[] B = {-1, 1};
        System.out.println(obj.subArrayWithZeroSumExists(B)); // 1

        // Count
        int[] C = {1, -1, -2, 2};
        System.out.println(obj.subArrayWithZeroSumCount(C)); // 3
        int[] D = {-1, 2, -1};
        System.out.println(obj.subArrayWithZeroSumCount(D)); // 1
        int[] E = {2, 3, -4, 4, -4};
        System.out.println(obj.subArrayWithZeroSumCount(E)); // 2
        int[] F = {3, -3, 3, -3};
        System.out.println(obj.subArrayWithZeroSumCount(F)); // 4
        int[] G = {-57, 84, -317, -349, -4, 297, 65, 36, -23, 350, -219, -213, 190, -86, -235, 238, -326, 35, 149, 106, 115, 394, 200, 32, -191, -386, 236, -190, -108, -163, 336, 40, 265, 60, -167, -246, 131, 74, 216, 40, -231, 287, -227, 318, 185, 177, -74, -65, 310, -182, -330, 231, -395, -30, -272, 0, 300, -380, -51, 178, 153, 97, -347, 327, 381, 169, 265, 239, -216, 143, 208, -251, 314, 55, -369, -313, 90, -312, 93, 181, -206, -175, 171, 115, 52, -246, -99, 151, -108, -73, -46, -84, 23, 51, -360, 161, -341, -30, -393, -72, 75, -138, -249, 281, -251, 63, -242, -302, -222, 168, 74, 182, 387, 155, 268, 99, 268, -63, -189, 97, -16, 63, -211, -246, -122, 84, 223, 166, 37, -290, 361, 282, -85, -135, -351, 39, 350, 133, -358, -359, 71, 210, -87, -28, -259, -28, -14, -42, 32, 362, 347, -220, -244, -255, -369, 272, 196, -254, -26, 152, -384, 186, 72, -254, -100, 316, 84, 147, -278, 263, 131, 127, 289, -78, -158, 300, 301, -280, -102, 371, -63, 345, 156, 286, -40, -390, 195, 120, -117, 65, -56, -188, -359, 286, -51, 15, -195, 91, -261, -378, 184, -308, 149, -190, -308, 43, 110, 181, -268, 264, 218, -349, -281, 235, 310, -269, -296, 272, 192, -75, 130, 289, 383, 217, -316, 67, -22, 367, 116, -207, -342, -16, -7, -6, -208, 95, -197, 272, 178, -64, 274, -370, -64, -3, -225, -308, 218, 257, 308, -151, 259, -182, 388, 123, -109, -280, -93, -151, -310, -44, 288, 74, -42, -337, 333, 210, 204, 214, 327, -85, 107, 285, 5, 43, -145, 263, 208, -56, -93, 90, -347, 269, -334, 137, -222, -328, 21, 227, 187, 154, 358, 71, 277, -28, -224, 196, -317, -82, 324, 360, -172, 226, -239, -57, -231, -154, 137, -205, -14, -209, -49, -281, -17, -57, 169, -305, 251, 96, -333, -18, 4, -62, 195, 85, -385, -14, 293, -183, 110, -69, -26, -41, -394, 292, 234, 212, 23, -176, 179, -37, 1, 205, -246, 245, -57, 83, 387, -301, 84, 394, -263, -246, -80, -233, -217, -246, -257, 358, -86, -321, -51, -147, -295, -33, -340, 160, -207, 121, -150, -123, 133, 60, -212, 278, -153, 70, -66, -191, -365, -357, 140, -383, -190, 395, -87, 41, -394, -124, -137, 203, -317, -193, 94, 281, -40, -396 };
        System.out.println(obj.subArrayWithZeroSumCount(G)); // 30
    }
}
