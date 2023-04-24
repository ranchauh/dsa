package strings;

/**
 * Given a string A of size N, find and return the longest palindromic substring in A.
 * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
 * Palindrome string:
 * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
 */
public class LongestPalindromeSubstring {
    public String longestPalindrome(String A) {
        int n = A.length();
        String longestPalindrome = A.substring(0, 1);

        // Find odd length palindrome sub-strings.
        for(int mid = 1; mid < n-1; mid++) {
            int left = mid - 1;
            int right = mid + 1;
            String str = findPalindrome(A, left, right);
            if(str.length() > longestPalindrome.length()) {
                longestPalindrome = str;
            }
        }

        // find even length palindrome sub-string
        for(int left = 0; left < n-1; left++) {
            int right = left + 1;
            String str = findPalindrome(A, left, right);
            if(str.length() > longestPalindrome.length()) {
                longestPalindrome = str;
            }
        }

        return longestPalindrome;
    }

    private String findPalindrome(String A, int left, int right) {
        while(A.charAt(left) == A.charAt(right)) {
            left--;
            right++;
            if(left < 0 || right > A.length() -1) {
                break;
            }
        }
        return A.substring(left+1, right);
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring obj = new LongestPalindromeSubstring();
        System.out.println(obj.longestPalindrome("aaaabaaa")); // "aaabaaa"
        System.out.println(obj.longestPalindrome("abba")); // "abba"
    }
}
