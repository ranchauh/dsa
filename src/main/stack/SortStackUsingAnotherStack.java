package stack;
import java.util.Arrays;
import java.util.Stack;

/**
 * Problem Description
 * Given a stack of integers A, sort it using another stack.
 *
 * Return the array of integers after sorting the stack using another stack.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 5000
 *
 * 0 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument is a stack given as an integer array A.
 *
 *
 *
 * Output Format
 * Return the array of integers after sorting the stack using another stack.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, 4, 3, 2, 1]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 3, 4, 5]
 * Output 2:
 *
 *  [5, 11, 17, 100]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Just sort the given numbers.
 * Explanation 2:
 *
 *  Just sort the given numbers.
 */
public class SortStackUsingAnotherStack {
    public static int[] sort(int[] A) {
        // create stack from the given array
        Stack<Integer> inputStack = new Stack<>();
        for(int x : A) {
            inputStack.push(x);
        }
        // create temp stack
        Stack<Integer> tempStack = new Stack<>();
        while(!inputStack.isEmpty()) {
            int i = inputStack.pop();
            // while temp stack is not empty or we found a smaller element than i on the temp stack,
            // pop from temp stack and push to input stack.
            while(!tempStack.isEmpty() && tempStack.peek() < i) {
                inputStack.push(tempStack.pop());
            }
            // push i on temp stack
            tempStack.push(i);
        }
        // temp stack will have the sorted elements
        int i = 0;
        while(!tempStack.isEmpty()) {
            A[i] = tempStack.pop();
            i++;
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5, 4, 3, 2, 1}))); //  [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(sort(new int[]{5, 17, 100, 11}))); //  [5, 11, 17, 100]
    }

}
