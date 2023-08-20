package heap;

import java.util.*;

/**
 * Problem Description
 * Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
 * Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.
 *
 * Find and return the array C.
 *
 * NOTE:
 *
 * If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
 * If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return an integer array C, C[i] denotes the median of the first i elements.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 5, 4, 3]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 1, 2, 2, 3]
 * Output 2:
 *
 *  [5, 5, 17, 11]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  stream          median
 *  [1]             1
 *  [1, 2]          1
 *  [1, 2, 5]       2
 *  [1, 2, 5, 4]    2
 *  [1, 2, 5, 4, 3] 3
 * Explanation 2:
 *
 *  stream          median
 *  [5]              5
 *  [5, 17]          5
 *  [5, 17, 100]     17
 *  [5, 17, 100, 11] 11
 */
public class RunningMediun {
    public static List<Integer> solve(List<Integer> arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        result.add(arr.get(0));
        maxHeap.add(arr.get(0));
        for(int i=1; i<arr.size(); i++) {
            int x = arr.get(i);
            if(x < maxHeap.peek()) {
                maxHeap.add(x);
            } else {
                minHeap.add(x);
            }
            // balance heaps: maxHeap.size() - minHeap.size() == 0 || 1
            int diff = maxHeap.size() - minHeap.size();
            if(diff > 1) {
                minHeap.add(maxHeap.poll());
            }
            if(diff < 0) {
                maxHeap.add(minHeap.poll());
            }
            int size = maxHeap.size() + minHeap.size();
            // if size is even, mediun = (maxHeap.peek() + minHeap.peek())/2
            // else mediun = maxHeap.peek();
            if(size % 2 == 0) {
                result.add(maxHeap.peek());
            } else {
                result.add(maxHeap.peek());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(1, 2, 5, 4, 3))); // [1, 1, 2, 2, 3]
        System.out.println(solve(Arrays.asList(5, 17, 100, 11))); // [5, 5, 17, 11]
    }
}
