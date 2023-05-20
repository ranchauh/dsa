package bit;

/**
 * A number is known as special bit number if its binary representation contains atleast
 * two consecutive 1’s or set bits. For example 7 wih binary representation 111 is a special
 * bit number. Similarly 3 (11) is also a special bit number.
 */
public class ConsecutiveSetBit {
    private static boolean isSpecialBitNumberNaive(int n) {
        for(boolean isLastBitSet = false; n > 0; n = n >> 1) {
            boolean isCurBitSet = (n%2 == 1);
            if(isLastBitSet && isCurBitSet) {
                return true;
            }
            isLastBitSet = isCurBitSet;
        }
        return false;
    }


    private static void printSpecialBitNumbersNaive(int n) {
        for(int i=0; i<n; i++) {
            if(isSpecialBitNumberNaive(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    /**
     * If a number has at least two consecutive bits set,
     * then left shift followed by bitwise and will result in a non-zero value
     */
    private static boolean IsSpecialBitNumberEfficient(int n) {
        return (n & (n << 1)) > 0;
    }

    private static void printSpecialBitNumbersEfficient(int n) {
        for(int i=0; i<n; i++) {
            if(IsSpecialBitNumberEfficient(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printSpecialBitNumbersNaive(1<<3);
        printSpecialBitNumbersEfficient(1<<3);
        printSpecialBitNumbersNaive(1<<5);
        printSpecialBitNumbersEfficient(1<<5);
    }
}
