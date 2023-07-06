package sorting.selection;

/**
 * Problem Description
 * Find the Bth smallest element in given array A .
 *
 * NOTE: Users should try to solve it in less than equal to B swaps.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= B <= min(|A|, 500)
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first argument is an integer array A.
 *
 * The second argument is integer B.
 *
 *
 *
 * Output Format
 * Return the Bth smallest element in given array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [2, 1, 4, 3, 2]
 * B = 3
 * Input 2:
 *
 * A = [1, 2]
 * B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  3rd element after sorting is 2.
 * Explanation 2:
 *
 *  2nd element after sorting is 2.
 */
public class KthSmallestElement {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthSmallest(final int[] A, int B) {
        int counter = B;
        // apply selection sort to sort the array
        for(int i=0; i<A.length-1 && counter > 0; i++, counter--) {
            int minIdx = i;
            int minValue = A[i];
            for(int j=i+1; j<A.length; j++) {
                if(A[j] < minValue) {
                    minIdx = j;
                    minValue = A[j];
                }
            }
            swap(A, i, minIdx);
        }
        return A[B-1];
    }

    void swap(final int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        KthSmallestElement ob = new KthSmallestElement();
        int[] A = {43,31,68,21,25,4,36,76,6,25,7};
        System.out.println(ob.kthSmallest(A, 3)); //7
    }
}
