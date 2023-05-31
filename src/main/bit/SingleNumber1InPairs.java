package bit;

/**
 * Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
 * NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber1InPairs {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int singleNumber(final int[] A) {
        int missingNum = 0;
        for(int x : A) {
            missingNum = missingNum ^ x;
        }
        return missingNum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 1};
        System.out.println(singleNumber(A)); // 3
    }
}
