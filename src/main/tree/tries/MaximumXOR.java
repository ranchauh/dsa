package tree.tries;

import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 0 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum result of A[i] XOR A[j].
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  7
 * Output 2:
 *
 *  117
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.
 * Explanation 2:
 *
 *  Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.
 */
public class MaximumXOR {
    static class TrieNode {
        int bit;
        TrieNode[] children;
        TrieNode(int bit) {
            this.bit = bit;
            children = new TrieNode[2];
        }
    }
    static class BitTrie {
        TrieNode root;
        BitTrie() {
            root = new TrieNode(-1);
        }

        void insert(int x, int noOfBits) {
            TrieNode curr = this.root;
            for(int i=noOfBits; i>=0; i--) {
                int bit = (x & (1 << i)) > 0 ? 1 : 0 ;
                if(curr.children[bit] == null) {
                    curr.children[bit] = new TrieNode(bit);
                }
                curr = curr.children[bit];
            }
        }
        int maxXOR(int x, int noOfBits) {
            int ans = 0;
            TrieNode curr = this.root;
            for(int i=noOfBits; i>=0; i--) {
                int bit = (x & (1 << i)) > 0 ? 1 : 0;
                TrieNode node = curr.children[1-bit];
                if(node == null) {
                    node = curr.children[bit];
                }
                ans += ((1 << i) * node.bit);
                curr = node;
            }
            return ans;
        }
    }

    static int max(List<Integer> A) {
        int max = Integer.MIN_VALUE;
        for(int x : A) {
            max = Math.max(max, x);
        }
        return max;
    }

    static int noOfBits(int x) {
        int i = 31;
        while(i >= 0 && (x & (1 << i)) == 0) {
            i--;
        }
        return i+1;
    }

    public int solve(List<Integer> A) {
        int max = max(A);
        int noOfBits = noOfBits(max);
        BitTrie trie = new BitTrie();
        for(int x : A) {
            trie.insert(x, noOfBits);
        }
        int maxXor = Integer.MIN_VALUE;
        for(int x : A) {
            int y = trie.maxXOR(x, noOfBits);
            maxXor = Math.max(maxXor, x ^ y);
        }

        return maxXor;
    }

    public static void main(String[] args) {
        MaximumXOR ob = new MaximumXOR();
        System.out.println(ob.solve(Arrays.asList(1, 2, 3, 4, 5))); // 7
        System.out.println(ob.solve(Arrays.asList(5, 17, 100, 11))); // 117
    }

}
