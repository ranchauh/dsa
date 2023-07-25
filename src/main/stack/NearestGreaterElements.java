package stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterElements {
    public static int[] prevGreater(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(A[i]);
        }
        return result;
    }

    public static int[] prevGreaterIdx(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    public static int[] nextGreater(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length;
        int[] result = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(A[i]);
        }
        return result;
    }

    public static int[] nextGreaterIdx(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length;
        int[] result = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = n;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(prevGreater(new int[]{4, 5, 2, 10, 8})));  //  [-1, -1, 5, -1, 10]
        System.out.println(Arrays.toString(prevGreater(new int[]{3, 2, 1})));  //  [-1, 3, 2]
        System.out.println(Arrays.toString(nextGreater(new int[]{4, 5, 2, 10, 8})));  //  [5, 10, 10, -1, -1]
        System.out.println(Arrays.toString(nextGreater(new int[]{3, 2, 1})));  //  [-1, -1, -1]
    }
}
