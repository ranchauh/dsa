package tree.tries;

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
            curr.childrenCount++;
            curr.prefixCount += 1;
            curr = curr.children[ch];
        }
        curr.isEnd = true;
        curr.frequency += 1;
    }

    /**
     * TC:
     * Sc: O(1)
     */
    void delete(TrieNode root, String word) {
        TrieNode curr = root;
        TrieNode last = null;
        char charToDelete = ' ';
        for(char ch : word.toCharArray()) {
            if(curr.children[ch] == null) {
                return;
            }
            // if curr has more than 1 children or its the end node for another work
            // we can't delete it. save it as last and continue.
            if(curr.childrenCount > 1 || curr.isEnd) {
                last = curr;
                charToDelete = ch;
            }
            curr = curr.children[ch];
        }
        curr.isEnd = false;
        // If curr node is leaf, break its connection from the last node
        if(curr.childrenCount == 0 && last != null){
            last.children[charToDelete] = null;
        }
    }
}
