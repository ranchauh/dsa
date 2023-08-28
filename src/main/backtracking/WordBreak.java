package backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string A and a dictionary of words B, determine if A can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Input Format:
 *
 * The first argument is a string, A.
 * The second argument is an array of strings, B.
 * Output Format:
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
 * Constraints:
 *
 * 1 <= len(A) <= 6500
 * 1 <= len(B) <= 10000
 * 1 <= len(B[i]) <= 20
 * Examples:
 *
 * Input 1:
 *     A = "myinterviewtrainer",
 *     B = ["trainer", "my", "interview"]
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".
 *
 * Input 2:
 *     A = "a"
 *     B = ["aaa"]
 *
 * Output 2:
 *     0
 *
 * Explanation 2:
 *     Return 0 ( corresponding to false ) because "a" cannot be segmented as "aaa".
 */
public class WordBreak {
    public int wordBreak(String A, String[] B) {
        Set<String> set = new HashSet<>(Arrays.asList(B));
        return wordBreak(A, set);
    }

    int wordBreak(String word, Set<String> set) {
        if(word.length() == 0) {
            return 1;
        }
        for(int i=1; i<=word.length(); i++) {
            String prefix = word.substring(0,i);
            if(set.contains(prefix)) {
                int ans = wordBreak(word.substring(i), set);
                if(ans == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordBreak ob = new WordBreak();
        System.out.println(ob.wordBreak("myinterviewtrainer", new HashSet<>(Arrays.asList("trainer", "my", "interview")))); //1
        System.out.println(ob.wordBreak("a", new HashSet<>(Arrays.asList("aaa")))); //0
    }
}
