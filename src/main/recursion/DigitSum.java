package recursion;

/**
 * Given a number A, we need to find the sum of its digits using recursion.
 */
public class DigitSum {
    private static int digitSum(int n) {
        if(n <= 0) {
            return 0;
        }
        return n%10 + digitSum(n/10);
    }

    public static void main(String[] args) {
        System.out.println(digitSum(9999)); //36
    }
}
