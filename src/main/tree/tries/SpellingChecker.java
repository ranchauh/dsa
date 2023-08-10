package tree.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * Given an array of words A (dictionary) and another array B (which contain some words).
 *
 * You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
 *
 * Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
 *
 * Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.
 *
 * NOTE: Try to do this in O(n) time complexity.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 1000
 *
 * 1 <= sum of all strings in A <= 50000
 *
 * 1 <= |B| <= 1000
 *
 *
 *
 * Input Format
 * First argument is array of strings A.
 *
 * First argument is array of strings B.
 *
 *
 *
 * Output Format
 * Return the binary array of integers according to the given format.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [ "hat", "cat", "rat" ]
 * B = [ "cat", "ball" ]
 * Input 2:
 *
 * A = [ "tape", "bcci" ]
 * B = [ "table", "cci" ]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1, 0]
 * Output 2:
 *
 * [0, 0]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Only "cat" is present in the dictionary.
 * Explanation 2:
 *
 * None of the words are present in the dictionary.
 */
public class SpellingChecker {
    public static List<Integer> check(List<String> A, List<String> B) {
        CharTrie trie = new CharTrie();
        TrieNode root = new TrieNode('\0');
        // insert all the words to dictionary
        for(String word : A) {
            trie.insert(root, word);
        }
        // search given words and build result;
        List<Integer> result = new ArrayList<>();
        for(String word : B) {
            boolean isPresent = trie.search(root, word);
            result.add(isPresent ? 1 : 0);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(check(Arrays.asList("hello","trim", "play", "player","123"),
                Arrays.asList("hell","hello", "player", "123","h123"))); // [0, 1, 1, 1, 0]
    }
}
