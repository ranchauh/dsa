package strings;

/**
 * You are given a function to_lower() which takes a character array A as an argument.
 * Convert each character of A into lowercase characters if it exists. If the lowercase of a character does not exist, it remains unmodified.
 * The uppercase letters from A to Z are converted to lowercase letters from a to z respectively.
 * Return the lowercase version of the given character array.
 */
public class MyStringFunc {
    public static char[] to_lower(char[] A) {
        for(int i=0; i<A.length; i++) {
            char ch = A[i];
            if(ch >=65 && ch <= 90) {
                A[i] ^= (1<<5);
            }
        }
        return A;
    }

    public static char[] to_upper(char[] A) {
        for(int i=0; i<A.length; i++) {
            char ch = A[i];
            if(ch >=97 && ch <= 122) {
                A[i] ^= (1<<5);
            }
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(to_lower(new char[]{'S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'}));
        System.out.println(to_upper(new char[]{'S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'}));
    }
}
