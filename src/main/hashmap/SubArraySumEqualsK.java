package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> prefSumFreq = new HashMap<>();
        prefSumFreq.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int x : A){
            sum += x;
            int diff = sum - B;
            int freq = prefSumFreq.getOrDefault(diff, 0);
            count = count + freq;
            prefSumFreq.put(sum, prefSumFreq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    private int[] prefixSum(int[] A) {
        int n = A.length;
        int[] prefix = new int[n];
        for(int i=0; i<n; i++) {
            if(i==0) {
                prefix[i] = A[i];
            } else {
                prefix[i] = A[i] + prefix[i-1];
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        SubArraySumEqualsK obj = new SubArraySumEqualsK();
        int[] A = {13, 9, 19, -9, -19, 14, -15};
        int B = 15;
        System.out.println(obj.solve(A, B)); //0

        int[] C = {5, 2, 3, 1, 1, 6, -1, -17};
        int D = 5;
        System.out.println(obj.solve(C, D)); // 4
    }
}
