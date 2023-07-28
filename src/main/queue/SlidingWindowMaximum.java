package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximum {

    public int[] slidingMaximum1(final int[] A, int B) {
        int N = A.length;
        if (N == 1)
            return A;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[N - B + 1];
        for (int i = 0; i < B; i++) {
            while (!dq.isEmpty() && A[dq.peekLast()] <= A[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans[0] = A[dq.peekFirst()];
        for (int i = B; i < N; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - B) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && A[dq.peekLast()] <= A[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            ans[i - B + 1] = A[dq.peekFirst()];
        }
        return ans;

    }

    public int[] slidingMaximum(final int[] A, int B) {
        Deque<Integer> dQueue = new LinkedList<>();
        int n = A.length;
        if(n == 1) {
            return A;
        }
        int[] result = new int[n - B + 1];
        for (int i = 0; i < B; i++) {
            while (!dQueue.isEmpty() && A[dQueue.peekLast()] <= A[i]) {
                dQueue.removeLast();
            }
            dQueue.addLast(i);
        }
        result[0] = A[dQueue.peekFirst()];
        for (int i = B; i < n; i++) {
            // Remove element out of window
            if (!dQueue.isEmpty() && dQueue.peekFirst() <= i - B) {
                dQueue.removeFirst();
            }
            while (!dQueue.isEmpty() && A[dQueue.peekLast()] <= A[i]) {
                dQueue.removeLast();
            }

            dQueue.addLast(i);
            result[i - B + 1] = A[dQueue.peekFirst()];
        }
        return result;
    }
}
