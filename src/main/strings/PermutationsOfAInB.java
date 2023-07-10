package strings;

/**
 * Problem Description
 * You are given two strings, A and B, of size N and M, respectively.
 *
 * You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.
 *
 *
 *
 * Problem Constraints
 * 1 <= N < M <= 105
 *
 *
 *
 * Input Format
 * Given two arguments, A and B of type String.
 *
 *
 *
 * Output Format
 * Return a single integer, i.e., number of permutations of A present in B as a substring.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abc"
 *  B = "abcbacabc"
 * Input 2:
 *
 *  A = "aca"
 *  B = "acaa"
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Permutations of A that are present in B as substring are:
 *     1. abc
 *     2. cba
 *     3. bac
 *     4. cab
 *     5. abc
 *     So ans is 5.
 * Explanation 2:
 *
 *  Permutations of A that are present in B as substring are:
 *     1. aca
 *     2. caa
 */
public class PermutationsOfAInB {
    public int solve(String A, String B) {
        int[] freqA = new int[26];
        for(char ch : A.toCharArray()) {
            freqA[ch - 'a']++;
        }
        int count = 0;
        int[] freqB = new int[26];
        for(int i=0; i<B.length(); i++) {
            freqB[B.charAt(i) - 'a']++;
            if(i >= A.length()) {
                freqB[B.charAt(i-A.length()) - 'a']--;
            }
            if(areEqual(freqA, freqB)) {
                count++;
            }
        }
        return count;
    }

    private boolean areEqual(int[] arr1, int[] arr2) {
        for(int i=0; i<arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationsOfAInB ob = new PermutationsOfAInB();
        System.out.println(ob.solve("p","pccdpeeooadeocdoacddapacaecb")); //3
    }
}
