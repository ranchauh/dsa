package arrays;

public class CountEvenOddSpecialIndex {
    public int solve(int[] A) {
        int n = A.length;
        int[] evenPf = evenPf(A);
        int[] oddPf = oddPf(A);
        int ans = 0;
        for(int i=0; i<n; i++) {
            int evenSum, oddSum;
            if(i == 0) {
                evenSum = oddPf[n-1];
                oddSum = evenPf[n-1] - A[0];
            } else {
                evenSum = evenPf[i-1] + (oddPf[n-1] - oddPf[i]);
                oddSum = oddPf[i-1] + (evenPf[n-1] - evenPf[i]);
            }
            if(evenSum == oddSum) {
                ans++;
            }
        }
        return ans;
    }

    int[] evenPf(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        result[0] = arr[0];
        for(int i=1; i<n; i++) {
            if(i%2 == 0) {
                result[i] = result[i-1] + arr[i];
            } else {
                result[i] = result[i-1];
            }
        }
        return result;
    }

    int[] oddPf(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        result[0] = 0;
        for(int i=1; i<n; i++) {
            if(i%2 != 0) {
                result[i] = result[i-1] + arr[i];
            } else {
                result[i] = result[i-1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountEvenOddSpecialIndex ob =new CountEvenOddSpecialIndex();
        System.out.println(ob.solve(new int[]{2,1,6,4})); // 1
        System.out.println(ob.solve(new int[]{1,1,1})); // 3
    }
}
