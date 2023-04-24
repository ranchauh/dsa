package strings;

/**
 * Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.
 * The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 * Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] A) {
        String lcPrefix = A[0];
        for(int i=1; i < A.length; i++) {
            String str = A[i];
            int j = 0;
            while(lcPrefix.charAt(j) == str.charAt(j)) {
                j++;
                if(j > lcPrefix.length() - 1 || j > str.length() - 1) {
                    break;
                }
            }
            lcPrefix = lcPrefix.substring(0, j);
        }
        return lcPrefix;
    }

    public static void main(String[] args) {
        String[] arr = {"abcdefgh", "aefghijk", "abcefgh"};
        System.out.println(longestCommonPrefix(arr)); // "a"

        String[] arr1 = {"abab", "ab", "abcd"};
        System.out.println(longestCommonPrefix(arr1)); // "ab"
    }
}
