package tree.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestUniquePrefix {

    List<String> shortestUniquePrefix(List<String> words) {
        CharTrie trie = new CharTrie();
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode('\0');
        for(String word : words) {
            trie.insert(root, word);
        }
        for(String word : words) {
            result.add(shortestUniquePrefix(root, word));
        }
        return result;
    }

    String shortestUniquePrefix(TrieNode root, String word) {
        TrieNode curr = root;
        StringBuilder ans = new StringBuilder();
        for(char ch : word.toCharArray()) {
            if(curr.children[ch] == null) {
                return ans.toString();
            }
            if(curr.children[ch].prefixCount > 1) {
                ans.append(ch);
            } else {
                ans.append(ch);
                return ans.toString();
            }
            curr = curr.children[ch];
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        ShortestUniquePrefix ob = new ShortestUniquePrefix();
        System.out.println(ob.shortestUniquePrefix(Arrays.asList("hello","trim", "play", "player","123")));
    }
}
