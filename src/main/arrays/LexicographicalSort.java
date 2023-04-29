package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.
 */
public class LexicographicalSort {
    public int solve(String[] A, String B) {
        int[] alphabets = new int[26];
        // build a map of alphabets with its order as value
        for(int i=0; i<B.length(); i++) {
            alphabets[B.charAt(i)-'a'] = i;
        }
        int n = A.length;
        // For each string in array A check if should come before the next string
        for(int i=0; i<n-1; i++) {
            String s1 = A[i];
            String s2 = A[i+1];
            if(!compare(s1, s2, alphabets)) {
                return 0;
            }
        }
        return 1;
    }

    private boolean compare(String s1, String s2, int[] alphabets) {
        int n = Math.min(s1.length(), s2.length());
        for(int i=0; i<n; i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                int x = alphabets[s1.charAt(i)-'a'];
                int y = alphabets[s2.charAt(i)-'a'];
                return x <= y;
            }
        }
        return s1.length() == s2.length();
    }

    public static void main(String[] args) {
        LexicographicalSort ob = new LexicographicalSort();
        String[] A = { "ipial", "qjqgt", "vfnue", "vjqfp", "eghva", "ufaeo", "atyqz", "chmxy", "ccvgv", "ghtow" };
        String B = "nbpfhmirzqxsjwdoveuacykltg";
        System.out.println(ob.solve(A, B)); //1

        String[] C = { "fine", "none", "no" };
        String D = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(ob.solve(C, D)); // 0
    }
}
