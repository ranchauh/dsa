package strings;

/**
 * You are a software engineer working on a program that analyzes genetic sequences. You are given a sequence of nucleotides represented as a string A of size N, where each nucleotide is represented by a lowercase English letter [a-z]. Your task is to count the number of substrings in A that begin and end with the same nucleotide.
 * For example: if A = "abcba", The substrings of length 1 that start and end with the same letters are "a", "b", "c", "b", and "a". The substring of length 3 that starts and ends with the same letter is "bcb". The substring of length 5 that starts and ends with the same letter is "abcba".
 */
public class GeneticSequence {
    public static long solve(String A) {
        long[] freq = new long[26];
        for(char ch : A.toCharArray()) {
            freq[ch - 'a']++;
        }
        long ans = 0;
        for(long f : freq) {
            ans += f * (f+1)/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve("abbb")); // 7
        System.out.println(solve("abcb")); // 5
    }
}
