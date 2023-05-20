package bit;

/**
 * You are given a number A. You are also given a base B. A is a number on base B.
 * You are required to convert the number A into its corresponding value in decimal number system.
 */
public class AnyBaseToDecimal {
    public static int anyBaseToDecimal(int A, int B) {
        int result = 0;
        int power = 0;
        while(A > 0) {
            int rightMostDigit = A%10;
            result = result + (int) (rightMostDigit * Math.pow(B, power));
            power++;
            A = A/10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(anyBaseToDecimal(1010, 2)); //10
        System.out.println(anyBaseToDecimal(22, 3)); //8
    }
}
