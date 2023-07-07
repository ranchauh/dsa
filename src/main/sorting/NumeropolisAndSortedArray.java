package sorting;

/**
 *
 * In the bustling city of Numeropolis, there existed a group of skilled mathematicians known as the Sorting Society.
 * They were renowned for their ability to transform chaos into order and unravel complex patterns hidden within arrays of integers.
 * One day, a peculiar challenge came their way – to determine whether an unsorted array of integers A, numbered from 0 to N - 1, could be sorted using a specific set of operations.
 * The only operation allowed is to swap adjacent elements, but with one condition – the absolute difference between the elements being swapped must be 1.
 * Can you figure out if it is possible to sort the array?
 *
 */
public class NumeropolisAndSortedArray {
    public int solve(int[] A) {
        int n = A.length;
        int prevElem = A[0];
        for(int i=1; i<n; i++) {
            if(A[i] < prevElem) {
                int diff = Math.abs(prevElem - A[i]);
                if(diff == 1) {
                    prevElem = A[i-1];
                } else {
                    return 0;
                }
            } else {
                prevElem = A[i];
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        NumeropolisAndSortedArray ob = new NumeropolisAndSortedArray();
        System.out.println(ob.solve(new int[]{1,3,2,6})); //1
        System.out.println(ob.solve(new int[]{2,1,9,7})); //2
    }
}
