package arrays;

import java.util.Arrays;

/**
 * Problem Description
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
 *
 * If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.
 *
 * NOTE:
 *
 * The replacement must be in-place, do not allocate extra memory.
 * DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
 *
 *
 * Problem Constraints
 * 1 <= N <= 5 * 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first and the only argument of input has an array of integers, A.
 *
 *
 *
 * Output Format
 * Return an array of integers, representing the next permutation of the given array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3]
 * Input 2:
 *
 *  A = [3, 2, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 3, 2]
 * Output 2:
 *
 *  [1, 2, 3]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Next permutaion of [1, 2, 3] will be [1, 3, 2].
 * Explanation 2:
 *
 *  No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
 *  So will rearranges it in the lowest possible order.
 */
public class NextPermutation {
    public int[] nextPermutation(int[] A) {
        int n = A.length;
        int i=n-2;
        // Find the index of the number where descending order breaks from the end.
        int startIdx = -1;
        while(i > 0) {
            if(A[i] < A[i+1]) {
                startIdx = i;
                break;
            }
            i--;
        }
        // If no such index found, then the next larger permutation cannot be formed.
        if(startIdx == -1) {
            // Reverse as per the requirement.
            reverse(A, 0, n-1);
            return A;
        } else {
            // Find the just next number of the num present at the startIdx which should be larger than it
            // but smallar than other numbers.
            int nextMaxIdx = startIdx;
            for(i=startIdx+1; i<n; i++) {
                if(A[i] > A[nextMaxIdx]) {
                    nextMaxIdx = i;
                }
                if(A[i] >= A[startIdx] && A[i] <= A[nextMaxIdx]) {
                    nextMaxIdx = i;
                }
            }
            // swap with the next big number
            int temp = A[startIdx];
            A[startIdx] = A[nextMaxIdx];
            A[nextMaxIdx] = temp;
            // Finally reverse the rest of the array.
            reverse(A, startIdx+1, n-1);
            return A;
        }
    }

    private int[] reverse(int[] A, int a, int b) {
        int n = A.length;
        while(a < b) {
            int temp = A[a];
            A[a] = A[b];
            A[b] = temp;

            a++;
            b--;
        }
        return A;
    }

    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        int[] arr = {444,994,508,72,125,299,181,238,354,223,691,249,838,890,758,675,424,199,201,788,609,582,979,259,901,371,766,759,983,728,220,16,158,822,515,488,846,321,908,469,84,460,961,285,417,142,952,626,916,247,116,975,202,734,128,312,499,274,213,208,472,265,315,335,205,784,708,681,160,448,365,165,190,693,606,226,351,241,526,311,164,98,422,363,103,747,507,669,153,856,701,319,695,52};
        System.out.println(Arrays.toString(obj.nextPermutation(arr)));
        //626 436 819 100 382 173 817 581 220 95 814 660 397 852 15 532 564 715 179 872 236 790 223 379 83 924 454 846 742 730 689 112 110 516 85 149 228 202 988 212 69 602 887 445 327 527 347 906 54 460 517 376 395 494 827 448 919 799 133 879 709 184 812 514 976 700 156 568 453 267 547 8 951 326 652 772 213 714 706 972 318 768 506 59 854 422
    }
}
