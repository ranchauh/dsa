package bit;

/**
 * Given a decimal number A and a base B, convert it into its equivalent number in base B.
 */
public class DecimalToAnyBase {
    public static int decimalToAnyBase(int A, int B) {
        int result = 0;
        int i=0;
        while(A > 0) {
            int rem = A%B;
            result = result + (int) (rem * Math.pow(10, i));
            i++;
            A = A/B;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(decimalToAnyBase(4,3 )); // 11
        System.out.println(decimalToAnyBase(4,2 )); // 100
        System.out.println(decimalToAnyBase(868,2 )); // 100
    }
}
