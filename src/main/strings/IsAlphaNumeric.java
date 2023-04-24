package strings;

public class IsAlphaNumeric {
    public static int isAlphaNumeric(char[] A) {
        for(int i=0; i<A.length; i++) {
            char ch = A[i];
            if(!isBetween(ch, 'A', 'Z') && !isBetween(ch, 'a', 'z') && !isBetween(ch, '0', '9')) {
                return 0;
            }
        }
        return 1;
    }

    private static boolean isBetween(char ch, char start, char end) {
        return ch >= start && ch <= end;
    }

    public static void main(String[] args) {
        char[] a = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'};
        System.out.println(isAlphaNumeric(a));// 1

        char[] b = {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'}; //0
        System.out.println(isAlphaNumeric(b));
    }
}
