package tree.tries;

import java.util.*;

public class AutoComplete {
    static class Word implements Comparable {
        String word;
        int weight;
        Word(String word, int weight) {
            this.word = word;
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(this.weight, ((Word) o).weight);
        }

        @Override
        public String toString() {
            return this.word + ":"  + this.weight;
        }
    }

    static class TrieNode {
        char ch;
        TrieNode[] children;
        boolean isEnd;
        List<String> topWords;
        TrieNode(char ch) {
            this.ch = ch;
            children = new TrieNode[26];
            isEnd = false;
            topWords = new ArrayList<>();
        }
    }

    static class Trie {
        TrieNode root;
        Trie(TrieNode root) {
            this.root = root;
        }
        void insert(String word) {
            if(root == null) {
                root = new TrieNode('\0');
            }
            TrieNode curr = root;
            for(char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if(curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode(ch);
                }
                curr = curr.children[idx];
                if(curr.topWords.size() < 5) {
                    curr.topWords.add(word);
                }
            }
            curr.isEnd = true;
        }

        List<String> getTopWords(String prefix) {
            TrieNode curr = root;
            for(char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if(curr.children[idx] == null) {
                    return Collections.emptyList();
                }
                curr = curr.children[idx];
            }
            return curr.topWords;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<noOfTestCases; i++) {
            // read n and m
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            // read n words
            line = scanner.nextLine();
            String[] words = line.split(" ");
            // read n weights
            line = scanner.nextLine();
            String[] weights = line.split(" ");
            // read m prefixes
            line = scanner.nextLine();
            String[] prefixes = line.split(" ");

            // build a list
            List<Word> wordList = new ArrayList<>();
            for(int j=0; j<n; j++) {
                wordList.add(new Word(words[j],Integer.parseInt(weights[j])));
            }
            //System.out.println(words);
            Collections.sort(wordList, Collections.reverseOrder());
            //System.out.println(words);
            TrieNode root = new TrieNode('\0');
            Trie trie = new Trie(root);
            for(Word word : wordList) {
                trie.insert(word.word);
            }
            for(String prefix : prefixes) {
                List<String> topWords = trie.getTopWords(prefix);
                if(topWords.isEmpty()){
                    System.out.print(-1 + " ");
                }
                for(String word : topWords) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main1(String[] args) {
        List<Word> words = new ArrayList<>();
        words.add(new Word("abcd",2));
        words.add(new Word("aecd",1));
        words.add(new Word("abaa",3));
        words.add(new Word("abef",4));
        words.add(new Word("acdcc",6));
        words.add(new Word("acbcc", 5));
        //System.out.println(words);
        Collections.sort(words, Collections.reverseOrder());
        //System.out.println(words);
        TrieNode root = new TrieNode('\0');
        Trie trie = new Trie(root);
        for(Word word : words) {
            trie.insert(word.word);
        }
        List<String> prefixes = Arrays.asList("ab","abc","a");
        for(String prefix : prefixes) {
            for(String word : trie.getTopWords(prefix)) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }

}
