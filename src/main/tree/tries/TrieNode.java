package tree.tries;

public class TrieNode {
    char ch;
    TrieNode[] children;
    boolean isEnd;
    int frequency;

    TrieNode(char ch) {
        this.ch = ch;
        children = new TrieNode[256]; // ASCII chars
        isEnd = false;
        frequency = 0;
    }
}
