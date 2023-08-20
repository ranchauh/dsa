package tree.tries;

import java.util.*;

/**
 * Problem Description
 * Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, which has maximum XOR value.
 *
 * NOTE: If there are multiple subarrays with the same maximum value, return the subarray with minimum length. If the length is the same, return the subarray with the minimum starting index.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the ending index(1-based) of the subarray.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 4, 3]
 * Input 2:
 *
 *  A = [8]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 3]
 * Output 2:
 *
 *  [1, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are 6 possible subarrays of A:
 *  subarray            XOR value
 *  [1]                     1
 *  [4]                     4
 *  [3]                     3
 *  [1, 4]                  5 (1^4)
 *  [4, 3]                  7 (4^3)
 *  [1, 4, 3]               6 (1^4^3)
 *
 *  [4, 3] subarray has maximum XOR value. So, return [2, 3].
 * Explanation 2:
 *
 *  There is only one element in the array. So, the maximum XOR value is equal to 8 and the only possible subarray is [1, 1].
 */
public class MaximumXORSubarray {
    static class TrieNode {
        int bit;
        TrieNode[] children;
        TrieNode(int bit) {
            this.bit = bit;
            children = new TrieNode[2];
        }
    }
    static class Trie {
        TrieNode root;
        Trie() {
            this.root = new TrieNode(-1);
        }

        void insert(int x, int noOfBits) {
            TrieNode curr = this.root;
            for(int i=noOfBits; i>=0; i--) {
                int bit = (x & (1 << i)) > 0 ? 1 : 0;
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

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> prefixXOR = prefixXOR(A);
        int max = max(prefixXOR);
        int noOfBits = noOfBits(max);
        Trie trie = new Trie();
        for(int x : prefixXOR) {
            trie.insert(x, noOfBits);
        }
        int maxXor = Integer.MIN_VALUE;
        for(int x : prefixXOR) {
            int y = trie.maxXOR(x, noOfBits);
            maxXor = Math.max(maxXor, x ^ y);
        }

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<prefixXOR.size(); i++) {
            int x = maxXor ^ prefixXOR.get(i);
            if(map.containsKey(x)) {
                if(result.isEmpty()) {
                    result.add(map.get(x) + 1);
                    result.add(i);
                } else if((i - (map.get(x)+1)) < (result.get(1) - result.get(0))) {
                    result.set(0, map.get(x) + 1);
                    result.set(1,i);
                }
            }
            map.put(prefixXOR.get(i), i);
        }
        return result;
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

    ArrayList<Integer> prefixXOR(ArrayList<Integer> arr) {
        ArrayList<Integer> prefix = new ArrayList<>();
        prefix.add(0); // adding 0 to cover all subarrays
        for(int i=1; i<=arr.size(); i++) {
            prefix.add(prefix.get(i-1) ^ arr.get(i-1));
        }
        return prefix;
    }

    public static void main(String[] args) {
        MaximumXORSubarray ob = new MaximumXORSubarray();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5,2,3,4,1));
        System.out.println(ob.solve(list)); // [1,2]
        list = new ArrayList<>(Arrays.asList(29,13,9,34,32,15,30,9));
        System.out.println(ob.solve(list)); // [1,4]
    }
}
