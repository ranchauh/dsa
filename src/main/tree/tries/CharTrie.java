package tree.tries;

import jdk.internal.icu.impl.Trie;

public class CharTrie {
    boolean search(TrieNode root, String word) {
        if(root == null) {
            return false;
        }
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch] == null) {
                return false;
            }
            curr = curr.children[ch];
        }
        return curr.isEnd;
    }

    void insert(TrieNode root, String word) {
        if(root == null) {
            root = new TrieNode('\0');
        }
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch] == null) {
                curr.children[ch] = new TrieNode(ch);
            }
            curr = curr.children[ch];
        }
        curr.isEnd = true;
        curr.frequency += 1;
    }
    void delete(TrieNode root, String word) {
        TrieNode curr = root;
        TrieNode last = root;
        for(char ch : word.toCharArray()) {
            if(root.children[ch] == null) {
                return;
            }
            curr = root.children[ch];
        }
    }
}
