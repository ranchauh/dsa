package strings;

import java.util.Arrays;

/**
 * You are given a string A of size N consisting of lowercase alphabets.
 * You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
 * Find the minimum number of distinct characters in the resulting string.
 */
public class MinDistinctCharacter {
    public static int solve(String A, int B) {
        int[] freq = new int[26];
        // count frequency of each lowercase alphabet in A and find the char with max freq
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            int idx = A.charAt(i) - 97;
            freq[idx]++;
            if (freq[idx] > max) {
                max = freq[idx];
            }
        }

        // Sort the freq array
        Arrays.sort(freq);

        int i = 0;
        for (; i < 25; i++) {
            if (freq[i] == 0) {
                continue;
            }
            if (B <= 0 || freq[i] > B) {
                break;
            }
            B = B - freq[i];
        }
        return 26 - i;
    }

    public static void main(String[] args) {
        System.out.println(solve("abcabbccd", 3)); // 2
    }
}
