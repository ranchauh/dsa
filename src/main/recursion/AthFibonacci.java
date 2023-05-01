package recursion;

/**
 * The Fibonacci numbers are the numbers in the following integer sequence.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
 * Fn = Fn-1 + Fn-2
 * Given a number A, find and return the Ath Fibonacci Number using recursion.
 * Given that F0 = 0 and F1 = 1.
 */
public class AthFibonacci {
    public static int findAthFibonacci(int A) {
        return fib(A);
    }

    private static int fib(int n) {
        if(n == 0) {
            return 0;
        } else if(n <=2 ) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        findAthFibonacci(2); //1
        findAthFibonacci(9); //34
    }
}
