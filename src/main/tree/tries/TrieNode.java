package tree.tries;

public class TrieNode {
    char ch;
    TrieNode[] children;
    boolean isEnd;
    int frequency;

    int childrenCount;

    int prefixCount;

    TrieNode(char ch) {
        this.ch = ch;
        children = new TrieNode[256]; // ASCII chars
        isEnd = false;
        frequency = 0;
        childrenCount = 0;
        prefixCount = 0;

    }
}
