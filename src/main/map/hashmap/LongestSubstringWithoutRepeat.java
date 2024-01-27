package map.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Description
 * Given a string A, find the length of the longest substring without repeating characters.
 *
 * Note: Users are expected to solve in O(N) time complexity.
 *
 *
 *
 * Problem Constraints
 * 1 <= size(A) <= 106
 *
 * String consists of lowerCase,upperCase characters and digits are also present in the string A.
 *
 *
 *
 * Input Format
 * Single Argument representing string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum possible length of substring without repeating characters.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abcabcbb"
 * Input 2:
 *
 *  A = "AaaA"
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Substring "abc" is the longest substring without repeating characters in string A.
 * Explanation 2:
 *
 *  Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 */
public class LongestSubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String A) {
        Set<Character> set = new HashSet<>();
        int n = A.length();
        if(n <= 1) {
            return n;
        }
        int i = 0;
        int j = 0;
        int maxLength = 0;
        while(j < n) {
            while(i < j && set.contains(A.charAt(j))) {
                set.remove(A.charAt(i));
                i++;
            }
            set.add(A.charAt(j));
            j++;
            maxLength = Math.max(maxLength, j-i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println(lengthOfLongestSubstring("AaaA")); //2
    }
}
