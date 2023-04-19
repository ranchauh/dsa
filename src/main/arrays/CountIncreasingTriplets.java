package arrays;

/**
 * You are given an array A of N elements.
 * Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]
 */
public class CountIncreasingTriplets {
    public int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        // For A[i] < A[j] < A[k], try to fix j at an index and find out smallar elements to its right and larger elements to its right
        // and multiply the counts.

        // since j is middle element in the equation, leaving the elements at both ends.
        for(int j=1; j<=n-2; j++) {
            int countSmaller = 0;
            // count smallar elements than A[j] to its left
            for(int i=0; i<j; i++) {
                if(A[i] < A[j]) countSmaller++;
            }

            // count larger elements than A[j] to its right
            int countLarger = 0;
            for(int k=j+1; k<n; k++) {
                if(A[k] > A[j]) countLarger++;
            }
            ans += countSmaller * countLarger;
        }

        return ans;

    }

    public static void main(String[] args) {
        CountIncreasingTriplets obj = new CountIncreasingTriplets();
        int[] A = {1, 2, 4, 3};
        System.out.println(obj.solve(A)); // 2
        int[] B = {2, 1, 2, 3};
        System.out.println(obj.solve(B)); // 1

    }
}
