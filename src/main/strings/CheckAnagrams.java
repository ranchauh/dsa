package strings;

/**
 * You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.
 * Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.
 */
public class CheckAnagrams {
    public static int solve(String A, String B) {
        int[] freqA = new int[26];
        int[] freqB = new int[26];

        // Count frequency of letter in A
        for(int i=0; i<A.length(); i++) {
            freqA[A.charAt(i)-97]++;
        }

        // Count frequency of letter in B
        for(int i=0; i<B.length(); i++) {
            freqB[B.charAt(i)-97]++;
        }

        for(int i=0; i<26; i++) {
            if(freqA[i] != freqB[i]) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(solve("cat", "bat")); //0
        System.out.println(solve("secure", "rescue")); // 1
    }
}
