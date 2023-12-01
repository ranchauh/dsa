package backtracking;

import java.util.Arrays;

public class CountSqaurefulArrays {
    int count = 0;
    public int solve(int[] A) {
        if(A.length < 2) {
            return 0;
        }
        count = 0;
        Arrays.sort(A);
        squarefulPermutations(A, 0);
        return count;
    }

    void squarefulPermutations(int[] arr, int idx) {
        if(idx == arr.length-1) {
            if(checkPerfectSquare(arr[idx]+arr[idx - 1])) {
                count++;
            }
            return;
        }
        for(int i=idx; i<arr.length; i++) {
            if(i != idx && arr[i] == arr[idx]) {
                continue;
            }
            swap(arr, i, idx);
            if(idx == 0 || (idx > 0 && checkPerfectSquare(arr[idx]+arr[idx - 1]))) {
                squarefulPermutations(arr, idx+1);
            }
            // restore
            swap(arr, i, idx);
        }
    }

    void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    boolean checkPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        return (sqrt * sqrt) == x;
    }

    public static void main(String[] args) {
        CountSqaurefulArrays ob = new CountSqaurefulArrays();
        System.out.println(ob.solve(new int[]{2, 2, 2})); // 1
        System.out.println(ob.solve(new int[]{1, 8, 17})); // 2
        System.out.println(ob.solve(new int[]{55, 22, 20})); // 0
        System.out.println(ob.solve(new int[]{36229,1020,69,127,162,127})); // 2
    }
}
