package bit;

/**
 * Given an array of integers A, every element appears twice except for one.
 * Find that integer that occurs once.
 * NOTE: Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
public class SingleNumberInPairs {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int singleNumber(final int[] A) {
        int result = 0;
        for(int i:A) {
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 2, 3, 1})); // 3
    }
}
