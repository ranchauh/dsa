package strings;

/**
 * Find the number of occurrences of bob in string A consisting of lowercase English alphabets.
 */
public class CountWordOccurrences {
    public static int solve(String A) {
        int n = A.length();
        int countBob = 0;
        int i=0;
        while(i < n-2) {
            if(A.charAt(i) == 'b' && "bob".equals(A.substring(i, i+3))) {
                countBob++;
            }
            i++;
        }
        return countBob;
    }

    public static void main(String[] args) {
        System.out.println(solve("abobc")); //1
        System.out.println(solve("bobob")); //2
    }
}
