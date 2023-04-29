package arrays;

/**
 * Given an array of integers A and an integer B.
 * Find the total number of subarrays having sum equals to B.
 */
public class SubArraysSumEqualsK {
    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                sum += A[j];
                if(sum == B) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 1};
        System.out.println(new SubArraysSumEqualsK().solve(A, 1)); // 4
    }
}
