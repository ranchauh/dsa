package bit;

/**
 * Given an array A. For every pair of indices i and j (i != j), find the maximum A[i] & A[j].
 */
public class MaximumAndPair {
    public static int solve(int[] A) {
        int result = 0;
        for(int i=31; i>=0; i--) {
            int val = (result | (1 << i));
            int count = 0;
            for(int x : A) {
                if((val & x) == val) {
                    count++;
                }
            }
            if(count >= 2) {
                result = val;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //Maximum bitwise and among all pairs is (38, 44) = 36
        System.out.println(solve(new int[]{38, 44, 84, 12})); //36
    }

}
