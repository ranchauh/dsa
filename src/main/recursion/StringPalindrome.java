package recursion;

/**
 * Write a recursive function that checks whether string A is a palindrome or Not.
 * Return 1 if the string A is a palindrome, else return 0.
 * Note: A palindrome is a string that's the same when read forward and backward.
 */
public class StringPalindrome {
    public int solve(String A) {
        return palindrome(A, 0, A.length() - 1);
    }

    private int palindrome(String str, int s, int e) {
        if(str.charAt(s) != str.charAt(e)) {
            return 0;
        }
        if(s >= e) {
            return 1;
        }
        return palindrome(str, ++s, --e);
    }

    public static void main(String[] args) {
        StringPalindrome o =new StringPalindrome();
        System.out.println(o.solve("naman"));
    }
}
